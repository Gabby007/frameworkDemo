package com.emma.test;

import com.emma.domain.Order;
import com.emma.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test2 {
    
    /*@Test
    public void testGetOrderById(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        *//**
         * ӳ��sql�ı�ʶ�ַ�����
         * me.gacl.mapping.orderMapper��orderMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getOrderById��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         *//*
        String statement = "com.emma.mapping.orderMapper.getOrderById";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����������ѯ����Զ���װ��Order���󷵻�
        Order order = sqlSession.selectOne(statement,1);//��ѯorders����idΪ1�ļ�¼
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        System.out.println(order);//��ӡ�����null��Ҳ����û�в�ѯ����Ӧ�ļ�¼
    }*/
    
    @Test
    public void testGetOrderById2(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * ӳ��sql�ı�ʶ�ַ�����
         * me.gacl.mapping.orderMapper��orderMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * selectOrder��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
        String statement = "com.emma.mapping.orderMapper.selectOrder";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����������ѯ����Զ���װ��Order���󷵻�
        Order order = sqlSession.selectOne(statement,1);//��ѯorders����idΪ1�ļ�¼
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        System.out.println(order);//��ӡ�����Order [id=1, orderNo=aaaa, price=23.0]
    }
    
   /* @Test
    public void testGetOrderById3(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        *//**
         * ӳ��sql�ı�ʶ�ַ�����
         * me.gacl.mapping.orderMapper��orderMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * selectOrderResultMap��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         *//*
        String statement = "com.emma.mapping.orderMapper.selectOrderResultMap";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����������ѯ����Զ���װ��Order���󷵻�
        Order order = sqlSession.selectOne(statement,1);//��ѯorders����idΪ1�ļ�¼
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        System.out.println(order);//��ӡ�����Order [id=1, orderNo=aaaa, price=23.0]
    }*/
}