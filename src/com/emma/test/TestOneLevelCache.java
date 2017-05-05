package com.emma.test;



import java.util.LinkedList;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.emma.domain.User;
import com.emma.util.MyBatisUtil;

/**
 * @author gacl
 * ����һ������
 */
public class TestOneLevelCache {
    
    /*
     * һ������: Ҳ��Session���Ļ���(Ĭ�Ͽ���)
     */
    @Test
    public void testCache1() {
        SqlSession session = MyBatisUtil.getSqlSession();
        String statement = "com.emma.mapping.userMapper.getUser";
        User user = session.selectOne(statement, 1);
        System.out.println(user);
        
        /*
         * һ������Ĭ�Ͼͻᱻʹ��
         */
        user = session.selectOne(statement, 1);
        System.out.println(user);
        session.close();
        /*
         1. ������ͬһ��Session,���session�����Ѿ�close()���˾Ͳ��������� 
         */
        session = MyBatisUtil.getSqlSession();
        user = session.selectOne(statement, 1);
        System.out.println(user);
        LinkedList<Integer> lst = new LinkedList<>();
        lst.is
        /*
         2. ��ѯ������һ����
         */
        user = session.selectOne(statement, 2);
        System.out.println(user);
        
        /*
         3. û��ִ�й�session.clearCache()������
         */
        //session.clearCache(); 
        user = session.selectOne(statement, 2);
        System.out.println(user);
        
        /*
         4. û��ִ�й���ɾ�ĵĲ���(��Щ��������������)
         */
        session.update("com.emma.mapping.userMapper.updateUser",
                new User(2, "user", 23));
        user = session.selectOne(statement, 2);
        System.out.println(user);
        
    }
}
