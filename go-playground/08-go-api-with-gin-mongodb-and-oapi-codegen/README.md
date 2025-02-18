Reference: https://hungaikev.in/web-development/building-blog-api-gin-ferretdb-oapi-codegen/#generating-server-code

Command to generate the api code: 
```shell
oapi-codegen -o ./api/api.go -config server.cfg.gin.2.yaml api.yaml
```

Launch mongodb container using this: /home/explorer436/Downloads/GitRepositories/programming-playground/docker-compose-files/mongodb/docker-compose-with-mongo-2.yml

```shell
curl -X 'POST' \
  'http://localhost:8080/posts' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "title": "my first blog",
  "content": "some random content"
}'
```

```shell
curl -X 'GET'   'http://localhost:8080/posts'   -H 'accept: application/json'
```

TODO
This is not failing if MongoDB is not available.