package com.example.springfileiodemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DBResponseFile {
    private String name;
    private String url;
    private String type;
    private long size;
}
