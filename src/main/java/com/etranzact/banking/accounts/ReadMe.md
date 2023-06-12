## API Documentation: Account API

This document provides information about the RESTful API endpoints available in the `com.etranzact.banking.accounts` package. These endpoints allow you to perform CRUD operations on the `Account` entity.

### Base URL
The base URL for all endpoints is `/accounts`.

### Endpoints

#### Get Accounts
- Method: GET
- URL: `/accounts`
- Description: Retrieves a list of all accounts.
- Response Body: List of `Account` objects
- Response Status: 200 OK

#### Add Account
- Method: POST
- URL: `/accounts/addAccount`
- Description: Creates a new account.
- Request Body: `Account` object (JSON)
- Response Body: Created `Account` object
- Response Status: 201 Created

#### Update Account
- Method: PUT
- URL: `/accounts/updateAccount/{id}`
- Description: Updates an existing account.
- Path Variable: `id` (Long) - The ID of the account to be updated
- Request Parameters:
    - `accountType` (optional) - The new account type
    - `customerDetails` (optional) - The new customer details
    - `dateCreated` (optional) - The new date created
    - `initialAmount` (optional) - The new initial amount
- Response Status: 204 No Content

#### Delete Account
- Method: DELETE
- URL: `/accounts/deleteAccount/{id}`
- Description: Deletes an account.
- Path Variable: `id` (Long) - The ID of the account to be deleted
- Response Status: 204 No Content

Please note that the request and response formats, as well as the error handling, are not described in detail here. Make sure to handle appropriate request validations and error responses in your implementation.

For more information about each endpoint, refer to the corresponding method in the `com.etranzact.banking.accounts.AccountController` class.