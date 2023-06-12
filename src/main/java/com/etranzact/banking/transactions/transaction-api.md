# Transaction API

This API allows performing transactions on user accounts.

## Perform Transaction

Performs a transaction by subtracting the transaction amount from the initial amount of an account.

**URL:** `/transaction`

**Method:** `POST`

**Request Body:**

- `id` (required, long): The ID of the account.
- `transactionAmount` (required, BigDecimal): The amount to be deducted from the account.

**Response:**

- Success: Returns a success message along with the updated initial amount.
- Insufficient funds: Returns an error message indicating insufficient funds.
- Account not found: Returns an error message indicating that the account was not found.

**Example:**
POST /transaction

{
"id": 12345,
"transactionAmount": 100.00
}

**Success Response:**

HTTP/1.1 200 OK

"Transaction successful. Updated initial amount: 500.00"

**Error Response:**

HTTP/1.1 400 Bad Request

"Insufficient funds. Transaction failed."
HTTP/1.1 404 Not Found

"Account not found. Transaction failed."