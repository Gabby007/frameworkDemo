package com.emma.test;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.emma.domain.User;
import com.emma.util.MyBatisUtil;

/**
 * @author gacl
 * ���Զ�������
 */
public class TestTwoLevelCache {
    
    /*
     * ���Զ�������
     * ʹ��������ͬ��SqlSession����ȥִ����ͬ��ѯ�����Ĳ�ѯ���ڶ��β�ѯʱ�����ٷ���SQL��䣬����ֱ�Ӵӻ�����ȡ������
     */
    @Test
    public void testCache2() {
        String statement = "com.emma.mapping.userMapper.getUser";
        SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactory();
        //����������ͬ��SqlSession
        SqlSession session1 = factory.openSession();
        SqlSession session2 = factory.openSession();
        //ʹ�ö�������ʱ��User�����ʵ��һ��Serializable�ӿ�===> User implements Serializable
        User user = session1.selectOne(statement, 1);
        session1.commit();//����Ϊɶ������ط�һ��Ҫ�ύ����֮���������Ż�������,��Ϊ�����������Ǵ�cache��mapper.xml�ж����cache����ȡ�ã�
        				  //���session��commit����ô�����ݾͲ������cache�С����ԣ�ֻ��commit�󣬲���ȡ�á�
        System.out.println("user="+user);
        
        //����ʹ�õ���������ͬ��SqlSession�������Լ�ʹ��ѯ������ͬ��һ������Ҳ���Ὺ��ʹ��
        user = session2.selectOne(statement, 1);
        //session2.commit();
        System.out.println("user2="+user);
        System.out.println(user.equals(user));
    }
}