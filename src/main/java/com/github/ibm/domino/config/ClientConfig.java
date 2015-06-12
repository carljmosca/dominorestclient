/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ibm.domino.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

/**
 *
 * @author moscac
 */
@Sources({ "file:~/.dominorestclient.config"} )
public interface ClientConfig extends Config {
    
    String address();
    String username();
    String password();
    String database();
    boolean ignoreHostNameMatching();
    
}
