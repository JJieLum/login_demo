# 流程说明

1️⃣首先需要调用登录接口 /user/login

```http
curl --location 'http://localhost:9333/user/login' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJyb2wiOiJST0xFX0FETUlOIiwianRpIjoiMSIsImlzcyI6IlNuYWlsQ2xpbWIiLCJpYXQiOjE2OTcwODgxNTAsInN1YiI6ImFkbWluIiwiZXhwIjoxNjk3MTc0NTUwfQ.S68R35nzPEeOGc8eSfjfWTEk-lnHYgPOdsAM46tmU5M' \
--data '{
    "userName": "admin",
    "password": "root123456"
}'
```

在返回的数据headers中获取Authorization (Bearer开头的token)

2️⃣将接口返回的token在后续调用接口中添加到headers中。

```http
curl --location 'http://localhost:9333/user/getManager' \
--header 'Authorization: Bearer eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJyb2wiOiJST0xFX0FETUlOIiwianRpIjoiMSIsImlzcyI6IlNuYWlsQ2xpbWIiLCJpYXQiOjE2OTcwODgxNTAsInN1YiI6ImFkbWluIiwiZXhwIjoxNjk3MTc0NTUwfQ.S68R35nzPEeOGc8eSfjfWTEk-lnHYgPOdsAM46tmU5M'
```

