package com.dfec.springbootmybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dfec.springbootmybatisplus.entity.User;
import com.dfec.springbootmybatisplus.mapper.UserMapper;
import com.dfec.springbootmybatisplus.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringbootmybatisplusApplicationTests {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private UserMapper userMapper;

    private User user;

    @Before
    public void produceUser(){
        User user =new User();
        user.setName("测试数据");
        user.setAge(20);
        user.setEmail("testEmail");
        this.user=user;

    }

    //serviceImp的使用

    /*
    *
    * 查询user 用户信息
    * */
    @Test
    public void findUser(){
        List<User> list = iUserService.list();
        list.forEach(System.out::println);
    }
    /*
    * 添加数据
    * */
    @Test
    public  void saveUser(){
        boolean flage = iUserService.save(this.user);
        System.out.println(flage);
    }

    /*
    * 修改用户信息
    * */
    @Test
    public void updataUser(){
        this.user.setId(3);
        boolean flage = iUserService.updateById(this.user);
        System.out.println(flage);
    }
    /*
    * 删除用户信息
    * */
    @Test
    public void deleteUser(){
        boolean flage = iUserService.removeById(3);
        System.out.println(flage);
    }
    /*
    * 分页（注意配置分页类）
    * */
    @Test
    public void page(){
        Page<User> page = iUserService.page(new Page<User>(2, 3));
        System.out.println(page.getSize());//页的大小
        List<User> records = page.getRecords();
        records.forEach(System.out::println);
    }

}
