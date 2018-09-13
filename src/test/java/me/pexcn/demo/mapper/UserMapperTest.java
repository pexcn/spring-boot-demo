package me.pexcn.demo.mapper;

import me.pexcn.demo.entity.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.autoconfigure.MapperAutoConfiguration;

/**
 * Created by pexcn on 2018-09-20.
 */
@MybatisTest
@RunWith(SpringRunner.class)
@ImportAutoConfiguration(MapperAutoConfiguration.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testIsExistUser() {
        Assert.assertTrue(userMapper.isExistUser("max"));
        Assert.assertFalse(userMapper.isExistUser("this_is_not_exist"));
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setPassword("ss");
        user.setUsername("15");
        userMapper.insert(user);
    }
}
