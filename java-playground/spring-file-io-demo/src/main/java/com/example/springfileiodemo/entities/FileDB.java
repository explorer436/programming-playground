package com.example.springfileiodemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class FileDB {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    /**
     * mysql> describe files;
     * +-------+----------------+------+-----+---------+-------+
     * | Field | Type           | Null | Key | Default | Extra |
     * +-------+----------------+------+-----+---------+-------+
     * | id    | varchar(255)   | NO   | PRI | NULL    |       |
     * | data  | varbinary(255) | YES  |     | NULL    |       |
     * | name  | varchar(255)   | YES  |     | NULL    |       |
     * | type  | varchar(255)   | YES  |     | NULL    |       |
     * +-------+----------------+------+-----+---------+-------+
     */
}
