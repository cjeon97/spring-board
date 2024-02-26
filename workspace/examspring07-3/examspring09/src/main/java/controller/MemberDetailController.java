package controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import examspring.NoSuchMemberException;
import repository.Member;
import service.MemberService;

@Controller
public class MemberDetailController {

	@Autowired
	private MemberService memberService;
	
	// memberService.detail(no)메소드는 에러를 발생시킬수도 있기때문에
	// try-catch문을 이용해야만 한다.
	// 하지만 ExceptionHandler를 이용한다면 해당 에러 발생시
	// 자동으로 동작할 메소드를 만들어 에러를 캣치할 필요가 없다
	@RequestMapping("/member/detail/{no}")
	public String detail(@PathVariable("no")Long no, Model model) {
		//try {
			Member member = memberService.detail(no);
			model.addAttribute("member", member);
		//} catch(NoSuchMemberException nsme) {
		//	nsme.printStackTrace();
		//}
		return "member/detail";
	}
	
	// detail메소드에 no파라미터에 Long타입의 파라미터가 전달되지 않는경우
	// 메소드 자체에서 parseLong이 에러를 발생시킨다
	// @ExceptionHandler를 이용하면 타입미스메치가 발생했을때 어떤 동작을 할지 지정할 수 있다
	@ExceptionHandler(TypeMismatchException.class)
	public String handleValueError() {
		return "member/valueError";
	}
	
	// 해당 에러가 throw됐을때 try-catch문 대신 자동으로 동작할 메소드
	@ExceptionHandler(NoSuchMemberException.class)
	public String handleNotFound() {
		return "member/notFound";
	}
}
