package com.learning.springbootswagger2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "com.learning.springbootswagger2.entity",description = "用户entity")
public class User {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "账号")
    private String username;
    @ApiModelProperty(value = "年龄")
    private int age;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "生日")
    private Date birthday;
}
