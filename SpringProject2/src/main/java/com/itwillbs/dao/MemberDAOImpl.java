package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	//마이바티스 객체 생성
	@Inject    //root-context.xml에서 SqlSession 객체를 생성해둠
	private SqlSession sqlSession;
	//memberMapper 파일에 정의된 전체 이름 변수에 저장
	private static final String namespace="com.itwillbs.mappers.memberMapper";

	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl insertMember()");
		//마이바티스 메서드 호출
		sqlSession.insert(namespace+".insertMember", memberDTO);    //sql구문이름호출
		
	}

	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl userCheck()");
		return sqlSession.selectOne(namespace+".userCheck", memberDTO);
		
		
	}

	@Override
	public MemberDTO getMember(String id) {
		System.out.println("MemberDAOImpl getMember()");
		return sqlSession.selectOne(namespace+".getMember", id);
	}

	@Override
	public void updateMember(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl updateMember()");
		sqlSession.update(namespace+".updateMember", memberDTO);
		
	}

	@Override
	public void deleteMember(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl deleteMember()");
		sqlSession.delete(namespace+".deleteMember", memberDTO);
		
	}

	@Override
	public List<MemberDTO> getMemberList() {
		return sqlSession.selectList(namespace+".getMemberList");
	}
	
	
	
	


}
