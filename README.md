# Spring Oauth2 Client Credentials flow

## About

This is a poc for consuming apis using oauth2 client credentials flow and spring boot

The application exposes a rest endpoint (http://localhost:8080/test-client) which dynamically fetches access token from a configured source and forwards it to another endpoint.

Currently, the endpoint just returns the auth header that has been forwarded just to test that the process is working.
