package com.emma.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.emma.domain.User;
import com.emma.util.MyBatisUtil;

public class TestCRUDByXmlMapper {

	 @Test
	    public void testAdd(){
	        //SqlSession sqlSession = MyBatisUtil.getSqlSession(false);
	        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
	        /**
	         * ӳ��sql�ı�ʶ�ַ�����
	         * me.gacl.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
	         * addUser��insert��ǩ��id����ֵ��ͨ��insert��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
	         */
	        String statement = "com.emma.mapping.userMapper.addUser";//ӳ��sql�ı�ʶ�ַ���
	        User user = new User();
	        user.setNice_name("emma");
	        user.setUser_name("����");
	        user.setAge(20);
	        //ִ�в������
	        int retResult = sqlSession.insert(statement,user);
	        //�ֶ��ύ����
	        //sqlSession.commit();
	        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
	        sqlSession.close();
	        System.out.println(retResult);
	    }
	    
	    @Test
	    public void testUpdate(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
	        /**
	         * ӳ��sql�ı�ʶ�ַ�����
	         * me.gacl.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
	         * updateUser��update��ǩ��id����ֵ��ͨ��update��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
	         */
	        String statement = "com.emma.mapping.userMapper.updateUser";//ӳ��sql�ı�ʶ�ַ���
	        User user = new User();
	        user.setId(3);
	        user.setUser_name("emma");
	        user.setAge(25);
	        //ִ���޸Ĳ���
	        int retResult = sqlSession.update(statement,user);
	        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
	        sqlSession.close();
	        System.out.println(retResult);
	    }
	    
	    @Test
	    public void testDelete(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
	        /**
	         * ӳ��sql�ı�ʶ�ַ�����
	         * me.gacl.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
	         * deleteUser��delete��ǩ��id����ֵ��ͨ��delete��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
	         */
	        String statement = "com.emma.mapping.userMapper.deleteUser";//ӳ��sql�ı�ʶ�ַ���
	        //ִ��ɾ������
	        int retResult = sqlSession.delete(statement,5);
	        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
	        sqlSession.close();
	        System.out.println(retResult);
	    }
	    
	    @Test
	    public void testGetAll(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession();
	        /**
	         * ӳ��sql�ı�ʶ�ַ�����
	         * me.gacl.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
	         * getAllUsers��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
	         */
	        String statement = "com.emma.mapping.userMapper.getAllUsers";//ӳ��sql�ı�ʶ�ַ���
	        //ִ�в�ѯ����������ѯ����Զ���װ��List<User>����
	        List<User> lstUsers = sqlSession.selectList(statement);
	        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
	        sqlSession.close();
	        System.out.println(lstUsers);
	    }

}