package com.kzk.deep_study_springboot;

import com.kzk.deep_study_springboot.entity.Department;
import com.kzk.deep_study_springboot.entity.Role;
import com.kzk.deep_study_springboot.entity.User;
import com.kzk.deep_study_springboot.repository.DepartmentRepository;
import com.kzk.deep_study_springboot.repository.RoleRepository;
import com.kzk.deep_study_springboot.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeepStudySpringbootApplicationTests {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    RoleRepository roleRepository;
    @Before   //初始化方法 对于每个测试方法都要执行一次
    public void initDate(){
        userRepository.deleteAll();
        roleRepository.deleteAll();
        departmentRepository.deleteAll();

        Department department=new Department();
        department.setName("开发部");
        departmentRepository.save(department);
        Assert.notNull(department.getId(),"department id is null");

        Role role=new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.notNull(role.getId(),"role id is null");

        User user=new User();
        user.setName("user");
        user.setCreateTime(new Date());
        user.setDepartment(department);
        List<Role> roles=roleRepository.findAll();
        Assert.notNull(roles,"roles is null");
        user.setRoles(roles);

        userRepository.save(user);
        Assert.notNull(user.getId(),"user id is null");
    }
    @Test
    public void contextLoads() {
//        Pageable pageable=new PageRequest(0,10,new Sort(Sort.Direction.ASC,"id"));  过时
        Pageable pageable=PageRequest.of(0,10,new Sort(Sort.Direction.ASC,"id"));
        Page<User> page=userRepository.findAll(pageable);
        Assert.notNull(page,"page is null");   //断言  判断是否成立 抛出异常
        for(User user:page.getContent()){
            System.out.println(user.getName());
        }

        System.out.println("over twice");
    }

}
