# Account Resource API
This repository contains code related to the Account API (Stage 4)

##  Overview
This stage builds upon Stage 3 by introducing security enhancements using OAuth2 and JSON Web Token (JWT). This secures the customer data retrieval process and ensure that only authorized users can access protected resources (customer lists).

## Files Overview
### These two files are new to stage 4
1. SecurityConfig.java

This class configures security settings and integrates OAuth2 and JWT for authentication and authorization. All customer endpoints are protected using OAuth2's and JWT tokens are validated to ensure only authorized users can access the data.

2. TokenService generates JWT tokens after successful authentication. This service integrates with OAuth2, generating tokens that clients use to access secured resources (customer lists). The token encodes the user's identity and permissions and includes details like expiration time.


## Branches overview

- **main**: initial Spring setup of code
- **august-22**: branch with auth implementation (generating a token)

  
  
