package db

import (
	"database/sql"
	"fmt"
	"log"

	"github.com/go-sql-driver/mysql"
	"github.com/joho/godotenv"
)

var db *sql.DB

func InitDb() {
	envFile, _ := godotenv.Read(".env")

	// Capture connection properties.
	cfg := mysql.Config{
		// User:   os.Getenv("DBUSER"),
		// Passwd: os.Getenv("DBPASS"),
		User:   envFile["DBUSER"],
		Passwd: envFile["DBPASS"],
		Net:    "tcp",
		Addr:   "127.0.0.1:3306",
		DBName: "myCustomDatabase",
	}
	// Get a database handle.
	var err error
	db, err = sql.Open("mysql", cfg.FormatDSN())
	if err != nil {
		// log.Fatal(err)
		log.Fatalf("Failed to openb connection to the database: %v", err)
	}

	pingErr := db.Ping()
	if pingErr != nil {
		// log.Fatal(pingErr)
		log.Fatalf("Failed to ping the database: %v", err)
	}
	fmt.Println("Connected!")
}
