# TDS Router
For large installations that need to route Proctors and Students to segmented installations for scalability.

## Project description
The router runs as a standalone application.  The router runs as a self contained java application.  Java 8 is required.

One or more Zone's are defined.  Each zone is a separate installation of TDS Proctor and Student components.
Proctors and Students are directed to router URL.  Then, based on configuration, they are directed to the appropriate Zone.

## Proctor
Proctors should be directed to router-url/proctor.  The router will direct them to authenticate via SSO similar to other TDS components.  Once authenticated the tenancy chain is evaluated against the router rules JSON file.  Based on the chain and the rules the proctor is redirected to the tds proctor in the assigned zone.

The proctor has been enhanced to use the zone id as the first character of the session id.  Two new properties are required for proctor.

 * proctor.TDSRouter.enabled=true
 * proctor.TDSRouter.zone=A


## Student
Students are directed to router-url/student. They are presented with a new login screen:

![login.png](https://bitbucket.org/repo/KBjjyx/images/3674303131-login.png)

After entering the session id the router uses the first character of the session id as the zone and redirects the student to the correct zone.  The router passes a query param ?routersession= that pre populates the session id on the student web application login screen so they do not need to enter it again.

## Configuration

### Routing
The router config file is in src/main/resources/tdsRouteConfig.json

This file defines the Zones, Roles used by Proctors and Tenancy Chain routing rules.

### SAML

The router needs a SAML keystore in /opt/sbtds/tds-router/tdsRouterSamlKeystore.jks

This SAML Configuration needs to be added to the OpenAM circle of trust.  Similar to the setup used for other TDS components.  The router will authenticate the proctor with this SAML configuration.

## Build

Java 8 and Maven are required to build the tds-router.  

Maven Build:

```
#!bash

mvn clean package
```

## Run


```
#!bash

java -jar target/tds-router-1.0.0.RELEASE.jar
```
