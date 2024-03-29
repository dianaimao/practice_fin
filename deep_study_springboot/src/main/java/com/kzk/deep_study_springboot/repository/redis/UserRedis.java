package com.kzk.deep_study_springboot.repository.redis;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kzk.deep_study_springboot.entity.User;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class UserRedis {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    public void add(String key, Long time, User user){
        Gson gson=new Gson();
        redisTemplate.opsForValue().set(key,gson.toJson(user),time, TimeUnit.MINUTES);
    }

    public User get(String key){
        Gson gson=new Gson();
        User user=null;
        String userJson=redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(userJson))
            user=gson.fromJson(userJson,User.class);
        return user;
    }
    public List<User> getList(String key){
        Gson gson=new Gson();
        List<User> ts=null;
        String listJsons=redisTemplate.opsForValue().get(key);
        if(StringUtils.isEmpty(listJsons))
            ts=gson.fromJson(listJsons,new TypeToken<List<User>>(){}.getType());
        return ts;
    }
    public void delete(String key){
        redisTemplate.opsForValue().getOperations().delete(key);
    }
}
