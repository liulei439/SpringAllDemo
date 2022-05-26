package com.learning.springbootrediscache.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String username;
    private int age;
    private String address;
    @JsonFormat(timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date birthday;
}
