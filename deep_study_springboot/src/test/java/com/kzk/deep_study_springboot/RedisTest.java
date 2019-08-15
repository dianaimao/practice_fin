package com.kzk.deep_study_springboot;

import com.kzk.deep_study_springboot.entity.Department;
import com.kzk.deep_study_springboot.entity.Role;
import com.kzk.deep_study_springboot.entity.User;
import com.kzk.deep_study_springboot.repository.redis.UserRedis;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private UserRedis userRedis;
    @Before
    public void setup(){
        Department department=new Department();
        department.setName("开发部");

        Role role=new Role();
        role.setName("admin");

        User user=new User();
        user.setName("user");
        user.setCreateTime(new Date());
        user.setDepartment(department);

        List<Role> roles=new ArrayList<>();
        roles.add(role);

        user.setRoles(roles);

        userRedis.delete(this.getClass().getName()+":userByname:"+user.getName());
        userRedis.add(this.getClass().getName()+":userByname:"+user.getName(),10L,user);

    }
    @Test
    public void test(){
        User user=userRedis.get(this.getClass().getName()+":userByname:user");
        Assert.notNull(user,"fail...");
        System.out.println("用户名"+user.getName()+"单位"+"角色"+user.getDepartment().getName()+user.getRoles().get(0).getName());
    }
}
