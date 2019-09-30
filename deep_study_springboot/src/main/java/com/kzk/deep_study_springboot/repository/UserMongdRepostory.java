package com.kzk.deep_study_springboot.repository;

import com.kzk.deep_study_springboot.entity.UserMongd;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongdRepostory  extends MongoRepository<UserMongd,String> {
    UserMongd findByUserName(String username);
}
