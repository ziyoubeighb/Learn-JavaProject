package com.zyb.mpdemo20210214;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyb.mpdemo20210214.bean.User;
import com.zyb.mpdemo20210214.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Mpdemo20210214ApplicationTests {

    //查询user表所有数据
    @Autowired
    private UserMapper userMapper;
    @Test
    void testSelectList() {
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }
    @Test
    public void testInsertUser(){
        User user = new User();
        user.setAge(18);
        user.setName("lucy");
        user.setEmail("123333@qq.com");
        int ins = userMapper.insert(user);
        System.out.println("插入"+ins+"条数据成功");
        System.out.println(user);
    }

    /**
     * 测试更新
     */
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(2L);
        user.setAge(32);
        int update = userMapper.updateById(user);
        System.out.println("更新"+update+"条数据成功");
    }

    /**
     * 测试 乐观锁插件
     */
    @Test
    public void testOptimisticLocker() {
        //查询
        User user = userMapper.selectById(1L);
        //修改数据
        user.setName("Helen Yao");
        user.setEmail("helen@qq.com");
        //执行更新
        userMapper.updateById(user);
    }

    /**
     * 查询一条id记录
     */
    @Test
    public void TestSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);

    }
    /**
     * 查询一批Id
     */
    @Test
    public void TestSelectBatchByIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2,3,4));
        users.forEach(System.out::println);
    }
    /**
     * 通过map查询
     */
    @Test
    public void testSelectByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","lucy");
        map.put("age",32);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    /**
     * 分页插件，分页查询
     */
    @Test
    public void testPageSelect(){
        //当前页，每页记录数
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page,null);
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getPages());//总页数
        System.out.println(page.getSize());//每页记录数
        System.out.println(page.getTotal());//总记录数
        System.out.println(page.hasNext());//是否有下一页
        System.out.println(page.hasPrevious());//是否有上一页

    }

    /**
     * 删除数据：
     *  1物理删除；
     */
    @Test
    public  void testDelete(){
        //删除一个
        int delete = userMapper.deleteById(1l);
        System.out.println(delete);
        //删除一批
        int res = userMapper.deleteBatchIds(Arrays.asList(2,3,4));
        System.out.println(res);
        //按照条件删除
        Map<String,Object> conds = new HashMap<>();
        conds.put("age",32);
        conds.put("name","121");
        int cond = userMapper.deleteByMap(conds);
        System.out.println(cond);

    }

    /**
     * 逻辑删除
     */
    @Test
    public void testLogicDelete(){
        //删除一个
        int delete = userMapper.deleteById(5l);
        System.out.println(delete);
    }

    /**
     * 测试 性能分析插件
     */
    @Test
    public void testPerformance() {
        User user = new User();
        user.setName("我是Helen");
        user.setEmail("helen@sina.com");
        user.setAge(18);
        userMapper.insert(user);
    }

}
