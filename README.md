# Wed RESTful API Server

Provide API for front-end development or mobile app.  
Writen in java code, using spring boot framwork.

For the following request you can use postman.

## Authentication

---

send to: http://localhost:8080/auth/login  
include in body:

```json
{
  "email": "daopm@gmail.com",
  "password": "password"
}
```

to login with user 'daopm' already exist in server

---

send to: http://localhost:8080/auth/register  
include in body:

```json
{
  "email": "example@test.com",
  "password": "fooFee",
  "fullname": "Exam Test"
}
```

to register user with email 'example@test.com'

---

## Wedding

---

send to: http://localhost:8080/weddings  
include in header with:

```
Key: Authorization
VALUE: Bearer <the jwt you received when login successfull>
```

to get wedding list

---

## Invitation

---

send to: http://localhost:8080/invitation/all  
to get invitation list

send to: http://localhost:8080/invitation/{id}  
with {id} is the id of the invitation  
to get the specific invitation

Example result:

```json
{
  "data": {
    "id": 1,
    "name": "Nguyen Van An",
    "relationship": "brother",
    "content": "welcome",
    "invitationLink": "google.com",
    "hasMorePeople": true,
    "weddingId": 1
  },
  "error": null
}
```

---

## Photo

---

send to: http://localhost:8080/photo/all  
to get photo list

send to: http://localhost:8080/photo/{id}  
to get the specific photo

Example result:

```json
{
  "data": {
    "id": 1,
    "title": "Quang Minh - Hong Dao",
    "imageUrl": "https://www.google.com",
    "weddingId": 2
  },
  "error": null
}
```

---
