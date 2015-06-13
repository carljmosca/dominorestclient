# Domino REST client
This library contains convenience methods and classes for the IBM Domino Access Services.

In order to run the unit tests, the configuration file ".dominorestclient.config" should be placed in the user's home directory.
It should contain the following:

- address=https://my.dominoserver.com/
- username=username
- password=password
- database=databasename (i.e dbprefix/username.nsf)
- ignoreHostNameMatching=false

The Domino Access Services reference is <a href="http://www-10.lotus.com/ldd/ddwiki.nsf/xpAPIViewer.xsp?lookupName=IBM+Domino+Access+Services+9.0.1#action=openDocument&content=catcontent&ct=api">here</a>
