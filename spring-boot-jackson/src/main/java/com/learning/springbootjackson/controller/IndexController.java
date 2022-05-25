package com.learning.springbootjackson.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.springbootjackson.entity.User;
import com.learning.springbootjackson.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用的最多的jackson @RequestBody @RestController @ResponseBody
 *
 */
@RestController
public class IndexController {
    @Autowired
    private IndexService indexService;

    @Resource
    private ObjectMapper mapper;

    @GetMapping("/getInfo/{id}")
    public User getInfo(@PathVariable("id") int id){
        return indexService.queryUserInfo(id);
    }

    /**
     * readTree方法可以接受一个字符串或者字节数组、文件、InputStream等， 返回JsonNode作为根节点，你可以像操作XML DOM那样操作遍历JsonNode以获取数据。
     * @return
     */
    @RequestMapping("readJsonString")
    public String readJsonString() {
        try {
            String json = "{\"name\":\"lei\",\"age\":25}";
            JsonNode node = this.mapper.readTree(json);
            String name = node.get("name").asText();
            int age = node.get("age").asInt();
            return name + " " + age;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析多级JSON例子：
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("readJsonString2")
    public String readJsonString2() throws JsonProcessingException {
        String json = "{\"name\":\"lei\",\"hobby\":{\"first\":\"sleep\",\"second\":\"eat\"}}";;
        JsonNode node = this.mapper.readTree(json);
        JsonNode hobby = node.get("hobby");
        String first = hobby.get("first").asText();
        return first;
    }

    @RequestMapping("readJsonAsObject")
    public String readJsonAsObject() {
        try {
            String json = "{\"username\":\"lei\",\"age\":26}";
            User user = mapper.readValue(json, User.class);
            String name = user.getUsername();
            int age = user.getAge();
            return name + " " + age;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
