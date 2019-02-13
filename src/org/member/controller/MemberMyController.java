package org.member.controller;

import java.util.List;

import org.member.mybatis.mapper.MemberDAOImpl;
import org.member.mybatis.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*컨트롤러라고 인식 고고*/
@Controller
public class MemberMyController {
	
	@Autowired
	private MemberDAOImpl mdao;

	//test
	@RequestMapping("myTest.my")
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data","mybatis controller에서 저장한 데이터");
		mv.setViewName("result");
		return mv;
	}
	
	//insert-form
	@RequestMapping("myInsert.my")
	public ModelAndView insert() {
		return new ModelAndView("memberInsert");
	}
	//insert
	@RequestMapping(value="myInsert.my",method=RequestMethod.POST)
	public ModelAndView insert(MemberVO user) {
		mdao.insert(user);
		return new ModelAndView("redirect:myList.my");
	}
	//list
	@RequestMapping("myList.my")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		List<MemberVO> list = mdao.getMemberList();
		mv.addObject("list",list);
		mv.setViewName("list");
		return mv;
	}
	//delete
	@RequestMapping("/myDelete.my")
	public ModelAndView delete(String id) {
		mdao.delete(id);
		return new ModelAndView("redirect:myList.my");
	}
	
	//detail
	@RequestMapping("/myDetail.my")
	public ModelAndView detail(String id) {
		ModelAndView mv = new ModelAndView();
		MemberVO user = mdao.findById(id);
		mv.addObject("user",user);
		mv.setViewName("detail");
		return mv;
	}
	
	//update
	@RequestMapping("/myUpdate.my")
	public ModelAndView update(MemberVO user) {
		mdao.update(user);
		return new ModelAndView("redirect:myList.my");
	}
}
