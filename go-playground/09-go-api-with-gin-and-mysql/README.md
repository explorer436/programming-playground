Set-up:
https://github.com/explorer436/programming-playground/tree/main/docker-compose-files/mysql

References:
1. https://go.dev/doc/tutorial/database-access

[Todo]

1. Initial set-up of the schema in the database is necessary. If it is not done, we will see errors like this:
    
   ```shell
   [explorer436@explorer436-p50-20eqs27p03 09-go-api-with-gin-and-mysql]$ go run main.go
   Connected!
   2025/02/18 12:43:51 albumsByArtist "John Coltrane": Error 1146 (42S02): Table 'myCustomDatabase.album' doesn't exist
   exit status 1
   ```

2. How to set-up the schema and tables in the database at application start-up?