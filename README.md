# Auth0 vs. Keycloak vs. Spring Authorization Server

## The purpose of the project

The purpose of the project is to demonstrate the use of some tools for authorization using the OAuth 2.0 and OpenID Connect protocols.
The following solutions are used here as authorization servers:
- [Auth0](https://auth0.com/)
- [Keycloak](https://keycloak.org/)
- [Spring Authorization Server](https://spring.io/projects/spring-authorization-server)

## Start-up and configuration features

The main part of the demo project is the client side ([spring-oauth2-client](./spring-oauth2-client)) module.  
By using different profiles you can run it in the appropriate configuration.   
Profiles are named accordingly, like authorization providers, but in lowercase (`auth0`, `keycloak`, `spring`).  

### Features of launching the client with Auth0

You will need to set extra environment variables:

| Environment variable name  | Value              |
|----------------------------|--------------------|
| OKTA_CLIENT_ID             | your-client-id     |
| OKTA_CLIENT_SECRET         | your-client-secret |
| OKTA_DOMAIN                | your-domain        |

The values can be obtained by using the [Auth0 Admin Console](https://manage.auth0.com/)

### Features of launching the client with Keycloak

For demonstration purposes, keycloak is launched in a docker container with an in-memory DB.  
You just need to run the file [keycloak-docker.yaml](./keycloak-docker.yaml) using docker-compose.

### Features of launching the client with Spring Authorization Server

You will need to run the module [spring-auth-server](./spring-auth-server) as a separate application.  

> **Hint:**  Spring applications may have conflicts with their cookies due to the fact that both instances `spring-auth-server` 
> and `spring-oauth2-client` will be running on localhost. It doesn't matter that they use different ports.  
> Therefore, it is recommended to use a different address than the localhost for one of the services. In this case, you can just add a following entry `auth.mydomain.com    127.0.0.1` to your host file.