* Steps for implementation

1. Write the openapi spec file

2. Generating code for gin server using oapi-codegen:

   (Don't use this)
   ```shell
   oapi-codegen -config server.cfg.gin.1.yaml openapi-ping.yaml
   ```
   
   Use this:
   ```shell
   oapi-codegen -o ./api/generatedserver-albums-gin.go -config server.cfg.gin.2.yaml openapi-albums.yaml
   ```

3. After the server code is generated, write the handlers

4. Write main.go and use the handlers

5. Testing:

   ```shell
   curl http://localhost:8080/my-custom-basepath/albums
   ```

   ```shell
   curl http://localhost:8080/my-custom-basepath/albums \
       --include \
       --header "Content-Type: application/json" \
       --request "POST" \
       --data '{"id": "4","title": "The Modern Sound of Betty Carter","artist": "Betty Carter","price": 49.99}'
   ```

   ```shell
   curl http://localhost:8080/my-custom-basepath/albums/2
   ```

   Invalid type in query param:
   ```shell
   curl -v http://localhost:8080/my-custom-basepath/albums/"test"
   ```
   
   ```shell
   curl -v http://localhost:8080/my-custom-basepath/albums --header "Content-Type: application/json" --request "POST" --data '{"id": "4","artist": "Betty Carter","price": 49.99}'
   ```

6. Request validation:

   #+begin_src
   [explorer436@explorer436-p50-20eqs27p03 programming-notes]$ curl -v http://localhost:8080/albums        --include        --header "Content-Type: application/json"        --req   uest "POST"        --data '{"id": "4","artist": "Betty Carter","price": 49.99}'
   Note: Unnecessary use of -X or --request, POST is already inferred.
   * Host localhost:8080 was resolved.
   * IPv6: ::1
   * IPv4: 127.0.0.1
   *   Trying [::1]:8080...
   * connect to ::1 port 8080 from ::1 port 44106 failed: Connection refused
   *   Trying 127.0.0.1:8080...
   * Connected to localhost (127.0.0.1) port 8080
   * using HTTP/1.x
   > POST /albums HTTP/1.1
   > Host: localhost:8080
   > User-Agent: curl/8.11.1
   > Accept: */*
   > Content-Type: application/json
   > Content-Length: 51
   >
   * upload completely sent off: 51 bytes
   < HTTP/1.1 400 Bad Request
   HTTP/1.1 400 Bad Request
   < Content-Type: application/json; charset=utf-8
   Content-Type: application/json; charset=utf-8
   < Date: Tue, 11 Feb 2025 21:04:05 GMT
   Date: Tue, 11 Feb 2025 21:04:05 GMT
   < Content-Length: 176
   Content-Length: 176
   <

   * Connection #0 to host localhost left intact
   {"error":"error in openapi3filter.RequestError: request body has an error: doesn't match schema #/components/schemas/Album: Error at \"/title\": property \"title\" is missing"}
   #+end_src
