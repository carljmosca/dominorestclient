/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.domino.client;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.RuntimeErrorException;
import javax.net.ssl.HttpsURLConnection;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author moscac
 */
public class BaseClient {

    private String host;
    private int port;
    private String username;
    private String password;
    private String protocol;
    private String path;
    private String database;
    private boolean ignoreHostNameMatching;
    protected RestTemplate restTemplate;
    protected Map<String, String> parameters;
    private final String GMT_STRING = "[GMT]";
    private final String PERIOD = ".";
    //protected SimpleDateFormat dateParameterFormat;

    public BaseClient() {
        parameters = new HashMap<>();
        //dateParameterFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setAddress(String address) {
        try {
            URL url = new URL(address);
            setHost(url.getHost());
            if (url.getPort() > 0) {
                setPort(url.getPort());
            }
            setProtocol(url.getProtocol());
        } catch (MalformedURLException ex) {
            Logger.getLogger(BaseClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isIgnoreHostNameMatching() {
        return ignoreHostNameMatching;
    }

    public void setIgnoreHostNameMatching(boolean ignoreHostNameMatching) {
        this.ignoreHostNameMatching = ignoreHostNameMatching;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    protected static class BasicAuthorizationInterceptor implements
            ClientHttpRequestInterceptor {

        private final String username;

        private final String password;

        public BasicAuthorizationInterceptor(String username, String password) {
            this.username = username;
            this.password = (password == null ? "" : password);
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                ClientHttpRequestExecution execution) throws IOException {
            byte[] token = Base64
                    .encode((this.username + ":" + this.password).getBytes());
            request.getHeaders().add("Authorization", "Basic " + new String(token));
            return execution.execute(request, body);
        }

    }

    protected void init() throws RuntimeException {
        init(null);
    }

    protected void init(String pathSuffix) throws RuntimeException {

        if (database == null || database.isEmpty()) {
            throw new RuntimeErrorException(new Error("Database parameter not found"));
        }
        if (ignoreHostNameMatching) {
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
        }

        StringBuilder p = new StringBuilder();
        if (pathSuffix != null && !pathSuffix.isEmpty()) {
            p.append("/mail");
            p.append("/").append(database);
        }
        p.append("/api/calendar");
        if (pathSuffix != null && !pathSuffix.isEmpty()) {
            p.append("/").append(pathSuffix);
        }
        setPath(p.toString());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(Include.NON_NULL);
//        mapper.configure(SerializationFeature. WRITE_NULL_MAP_VALUES, false);

        mapper.registerModule(new Jackson2HalModule());

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(
                Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
        converter.setObjectMapper(mapper);

        restTemplate = new RestTemplate(Collections.<HttpMessageConverter<?>>singletonList(converter));

        List<ClientHttpRequestInterceptor> interceptors = Collections
                .<ClientHttpRequestInterceptor>singletonList(new BasicAuthorizationInterceptor(
                                username, password));
        restTemplate.setRequestFactory(new InterceptingClientHttpRequestFactory(restTemplate.getRequestFactory(),
                interceptors));

    }

    protected String getResourceUriString() {
        StringBuilder resourceUri = new StringBuilder();
        if (!"http".equals(protocol) && !"https".equals(protocol)) {
            protocol = "http";
        }
        resourceUri.append(protocol).append("://").append(host);
        if (port > 0) {
            resourceUri.append(":").append(port);
        }
        if (!path.startsWith("/")) {
            resourceUri.append("/");
        }
        resourceUri.append(path);

        return resourceUri.toString();
    }

    protected URI getUri() {
        return getUri(null);
    }

    protected URI getUri(String pathParam) {

        StringBuilder baseUrl = new StringBuilder();
        if (!"http".equals(protocol) && !"https".equals(protocol)) {
            protocol = "http";
        }
        baseUrl.append(protocol).append("://").append(host);
        if (port > 0) {
            baseUrl.append(":").append(port);
        }
        if (!path.startsWith("/")) {
            baseUrl.append("/");
        }

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl.toString()).path(path
                + (pathParam != null && !pathParam.isEmpty() ? "/" + pathParam : ""));
        parameters.entrySet().stream().forEach((parameter) -> {
            builder.queryParam(parameter.getKey(), parameter.getValue());
        });

        return builder.build().toUri();
    }

    protected HttpEntity<String> getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(headers);
    }

    protected String getDateParameter(ZonedDateTime value) {
        StringBuilder sValue = new StringBuilder(value.format(DateTimeFormatter.ISO_DATE_TIME));
        int i = sValue.indexOf(GMT_STRING);
        if (i >= 0) {
            sValue.delete(i, i + GMT_STRING.length());
        }
        i = sValue.indexOf(PERIOD);
        if (i >= 0) {
            sValue.delete(i, i + 4);
        }
        return sValue.toString();
    }

}
