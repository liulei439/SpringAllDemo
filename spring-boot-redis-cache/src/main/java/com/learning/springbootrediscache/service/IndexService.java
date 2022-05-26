package com.learning.springbootrediscache.service;


import com.learning.springbootrediscache.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "student")
public interface IndexService {
    @Cacheable(key = "#p0")
    User queryUserInfo(int id);

    @CachePut(key = "#p0.id")
    User updateUserInfo(User user);

    @CacheEvict(key = "#p0")
    int deleteUserInfo(int id);

    int insertUserInfo(User user);
}
