package examspring08;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello동작");
		return "hello";
	}
	
	@RequestMapping("/hello2")
	public String test01(HttpServletRequest req) {
		req.setAttribute("now", LocalDateTime.now());
		return "hello2";
	}
	
	@RequestMapping("/test02")
	public String test02(HttpServletRequest req) {
		int n = Integer.parseInt(req.getParameter("n"));
		n *= n;
		req.setAttribute("n", n);
		return "test02";
	}
	
	@RequestMapping("/test03")
	public String test03(HttpServletRequest req, int n) {
		n *= n;
		req.setAttribute("n", n);
		return "test02";
	}
	
	@RequestMapping("/test04")
	public String test04(HttpServletRequest req, @RequestParam("n") int n2) {
		n2 *= n2;
		req.setAttribute("n", n2);
		return "test02";
	}
	
	@RequestMapping("/test05")
	public String test05(Model model, @RequestParam("n") int n2) {
		n2 *= n2;
		model.addAttribute("n", n2); // 뷰에서 사용할 결과값 저장
		return "test02";
	}
	
	@RequestMapping("/test06")
	public ModelAndView test06(ModelAndView mav, @RequestParam("n") int n2) {
		n2 *= n2;
		mav.addObject("n", n2); // 뷰에서 사용할 결과값 저장
		mav.setViewName("test02"); // 뷰이름까지 저장하여 전달
		return mav;
	}
	
	@RequestMapping(value="/test07", method=RequestMethod.GET)
	@ResponseBody // 뷰를 통하지않고 문자열을 직접응답(REST API형태 구현 시 활용)
	public String test07(@RequestParam("n") int n2) {
		n2 *= n2;
		return "{result: " + n2 + "}";
	}
	//요청 파라미터에 @RequestBody를 지정하여 JSON과 같은 타입의 요청 데이터를 받을 수 있음
	//@GetMapping, @PostMapping, @PutMapping, @DeleteMapping ... 활용
}
