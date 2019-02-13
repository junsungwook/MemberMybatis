package org.member.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.member.config.MybatisManager;
import org.member.mybatis.vo.MemberVO;
import org.springframework.stereotype.Repository;

@Repository("mdao")
public class MemberDAOImpl implements MemberDAO{
	private SqlSession sqlMap;
	
	public MemberDAOImpl() {
		SqlSessionFactory sqlMapper = MybatisManager.getMapper();
		sqlMap = sqlMapper.openSession();
	}

	@Override
	public List<MemberVO> getMemberList() {
		List<MemberVO> list = sqlMap.selectList("listMember");
		return list;
	}

	@Override
	public MemberVO findById(String id) {
		MemberVO user = sqlMap.selectOne("detailMember", id);
		return user;
	}

	@Override
	public void insert(MemberVO user) {
		// TODO Auto-generated method stub
		sqlMap.insert("insertMember",user);
		sqlMap.commit();
	}

	@Override
	public void update(MemberVO user) {
		sqlMap.update("updateMember", user);
		sqlMap.commit();
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		sqlMap.delete("deleteMember",id);
		sqlMap.commit();
	}

	
	


}
