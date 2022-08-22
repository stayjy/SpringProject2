package com.itwillbs.controller;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@RestController
public class AjaxController {

	@Inject
	private MemberService memberService;
	
	//	가상주소 시작점 http://localhost:8080/myweb2/member/iddup 
	@RequestMapping(value = "/member/iddup", method = RequestMethod.GET)
	public ResponseEntity<String> iddup(HttpServletRequest request) {
		String id=request.getParameter("id");
		
		MemberDTO memberDTO=memberService.getMember(id);
		
		String result="";
		if(memberDTO!=null) {
			// 아이디 있음 , 아이디 중복
			result="iddup";
		}else {
			// 아이디 없음, 아이디 사용가능
			result="idok";
		}
		
		ResponseEntity<String> entity=new ResponseEntity<String>(result,HttpStatus.OK);
		return entity;
	}
	
	//	가상주소 시작점 http://localhost:8080/myweb2/member/listjson 
	@RequestMapping(value = "/member/listjson", method = RequestMethod.GET)
	public ResponseEntity<List<MemberDTO>> listjson(HttpServletRequest request) {
		
		List<MemberDTO> memberList=memberService.getMemberList();
		
		
		ResponseEntity<List<MemberDTO>> entity=
				new ResponseEntity<List<MemberDTO>>(memberList,HttpStatus.OK);
		return entity;
		
		// json 데이터 변경 프로그램 설치하면 => 자동으로 json 데이터 변환
		// pom.xml 코드 입력
//			<dependency>
//			    <groupId>com.fasterxml.jackson.core</groupId>
//			    <artifactId>jackson-databind</artifactId>
//			    <version>2.5.4</version>
//			</dependency>
		
	}
	
}
