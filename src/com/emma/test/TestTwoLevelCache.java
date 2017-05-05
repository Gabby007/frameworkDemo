package com.emma.test;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.emma.domain.User;
import com.emma.util.MyBatisUtil;

/**
 * @author gacl
 * 测试二级缓存
 */
public class TestTwoLevelCache {
    
    /*
     * 测试二级缓存
     * 使用两个不同的SqlSession对象去执行相同查询条件的查询，第二次查询时不会再发送SQL语句，而是直接从缓存中取出数据
     */
    @Test
    public void testCache2() {
        String statement = "com.emma.mapping.userMapper.getUser";
        SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactory();
        //开启两个不同的SqlSession
        SqlSession session1 = factory.openSession();
        SqlSession session2 = factory.openSession();
        //使用二级缓存时，User类必须实现一个Serializable接口===> User implements Serializable
        User user = session1.selectOne(statement, 1);
        session1.commit();//不懂为啥，这个地方一定要提交事务之后二级缓存才会起作用,因为，二级缓存是从cache（mapper.xml中定义的cache）中取得，
        				  //如果session不commit，那么，数据就不会放入cache中。所以，只有commit后，才能取得。
        System.out.println("user="+user);
        
        //由于使用的是两个不同的SqlSession对象，所以即使查询条件相同，一级缓存也不会开启使用
        user = session2.selectOne(statement, 1);
        //session2.commit();
        System.out.println("user2="+user);
        System.out.println(user.equals(user));
    }
}