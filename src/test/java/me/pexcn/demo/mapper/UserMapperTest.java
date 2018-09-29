package me.pexcn.demo.mapper;

import me.pexcn.demo.entity.model.User;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.autoconfigure.MapperAutoConfiguration;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by pexcn on 2018-09-20.
 */
@MybatisTest
@RunWith(SpringRunner.class)
@ImportAutoConfiguration(MapperAutoConfiguration.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserMapperTest {
    @Rule
    public Timeout testTimeout = Timeout.seconds(10);

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
        int result = userMapper.insert(user);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setUsername("google");
        user.setPassword("android");
        int result = userMapper.delete(user);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testDeleteByExample() {
        Example example = Example.builder(User.class).build();
        example.createCriteria().andEqualTo("username", "google");
        int result = userMapper.deleteByExample(example);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        int result = userMapper.deleteByPrimaryKey(2);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testSelectAll() {
        List<User> users = userMapper.selectAll();
        Assert.assertThat(users.size(), Matchers.greaterThan(1));
    }

    @Test
    public void testSelect() {
        User user = new User();
        user.setUid(2L);
        List<User> users = userMapper.select(user);
        Assert.assertNotNull(users);
        Assert.assertThat(users.size(), Matchers.greaterThan(0));
    }

    @Test
    public void testSelectOne() {
        User user = new User();
        user.setUid(2L);
        user.setUsername("max");
        User result = userMapper.selectOne(user);
        Assert.assertNotNull(result);
    }
}
