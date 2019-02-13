package org.member.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisManager {
	public static SqlSessionFactory sqlMapper;
	static {
		try {
			String resource="org/member/config/Configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO �ڵ� ������ catch ���
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getMapper() {
		return sqlMapper;
	}
}

