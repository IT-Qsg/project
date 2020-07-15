package com.dfec.springbootmybatis;

import com.dfec.springbootmybatis.entity.Person;
import com.dfec.springbootmybatis.entity.User;
import com.dfec.springbootmybatis.service.PersonService;
import com.github.pagehelper.Page;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@SpringBootTest
class DemoApplicationTests {

    @Autowired
    @Qualifier("jdbcProductService")
    private JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("jdbcUserService")
    private JdbcTemplate jdbcTemplate2;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void redisTest() {
        // redis存储数据
        String key = "qsg";
       // redisTemplate.opsForValue().set(key, "qsg");
        // 获取数据
        String value = (String) redisTemplate.opsForValue().get(key);
        System.out.println("获取缓存中key为" + key + "的值为：" + value);

        User user = new User();
        user.setUsername("qsg");
        user.setPassword("123");
        user.setId(1);
       /* user.setRealname("rname");
        String userKey = "userkey";
        redisTemplate.opsForValue().set(userKey, user);*/
        User newUser = (User) redisTemplate.opsForValue().get("userkey");
        System.out.println("获取缓存中key为" + "userkey" + "的值为：" + newUser);
    }
    @Test
    public void TestConn1() throws SQLException {
        Connection conn = jdbcTemplate1.getDataSource().getConnection();
        System.out.println("数据库连接1:::"+conn);
    }
    @Test
    public void TestConn2() throws SQLException {
        Connection conn = jdbcTemplate2.getDataSource().getConnection();
        System.out.println("数据库连接2:::"+conn);
    }
    private Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Autowired
    private PersonService personService;

    Person person = null;

    @Test
    public  void testInsert() {
        person = new Person();
        person.setName("测试");
        person.setAddress("address");
        person.setAge(10);
        long insert = personService.insert(person);
        person.setId(insert);
        System.out.println(person);
    }

    @Test
    public void testFindAll() {
        List<Person> persons = personService.findAll();
    }

    @Test
    public void testFindByPage() {
        Page<Person> persons = personService.findByPage(2, 2);
        for (Person person1 : persons) {
            System.out.println(person1);
        }
    }
    // 测试mybatis缓存
    @Test
    public void testCache() {
        long begin = System.currentTimeMillis();
        List<Person> persons = personService.findAll();
        long ing = System.currentTimeMillis();
        personService.findAll();
        long end = System.currentTimeMillis();
        logger.info("第一次请求时间：" + (ing - begin) + "ms");
        logger.info("第二次请求时间:" + (end - ing) + "ms");
    }

    // 测试Redis存储和获取一个List
    @Test
    public void testRedisCacheSetList() {
//        List<Person> persons = new ArrayList<>();
       /* Person person =null;
        for(int i = 1;i<10;i++){
            person= new Person();
            person.setId((long)i);
            person.setName("测试"+i);
            person.setAddress("address"+i);
            person.setAge(10);
            persons.add(person);
        }*/

        /*
        redis 获取存入的对象
        */
        List<Person> persons = new ArrayList<>();
        if(redisTemplate.hasKey("personKey"))
            persons = (List<Person>) redisTemplate.opsForValue().get("personKey");
        else{
            //使用mybatis 获取用户信息并且将用户信息存入redis
            redisTemplate.opsForValue().set("personKey", personService.findAll());
            persons = (List<Person>) redisTemplate.opsForValue().get("personKey");
        }
        persons.forEach(System.out::println);

       /* System.out.println(redisTemplate);
        redisTemplate.opsForValue().set("persionKey", persons);
        persons = (List<Person>) redisTemplate.opsForValue().get("persionKey");*/

      //  System.out.println(persons);

        System.out.println("set+++++++++");

        redisTemplate.delete("per");
       /* redisTemplate.opsForList().leftPush("per",persons);
        List per = redisTemplate.opsForList().range("per", 0, -1);*/
//        per.forEach(System.out::println);

        redisTemplate.opsForValue().set("123","456");
        System.out.println("*********************************"+redisTemplate.opsForValue().get("123"));
    }

    // 测试Redis存储和获取一个Object
    @Test
    public void testRedisCacheSetObject() {
        redisTemplate.opsForValue().set(person.getId() + "", person, 2, TimeUnit.MINUTES);
        Object p = redisTemplate.opsForValue().get(person.getId() + "");
        if (p instanceof Person) {
            Person person1 = (Person) p;
            System.out.println(person1);
        }
    }
    // 测试 通过Spring Aware获取Spring容器中的额Bean
    /*@Test
    public void testApplicationContextAware() {
        RedisTemplate redisTemplate = SpringContextHolder.getBean("redisTemplate");
        System.out.println(redisTemplate);
    }*/
}
