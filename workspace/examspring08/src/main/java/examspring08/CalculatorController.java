package examspring08;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import calc.AddCalc;
import calc.DivCalc;
import calc.MinCalc;
import calc.MulCalc;

@Controller
public class CalculatorController {

	// 계산기 메인
	@RequestMapping("/calculator")
	public String index(Model model) {
		return "calviews/index";
	}
	
	// 덧셈(form, proc)
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model) {
		return "calviews/addForm";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Model model, int n1, int n2) {
		int result = new AddCalc().clac(n1, n2);
		model.addAttribute("n1", n1);
		model.addAttribute("n2", n2);
		model.addAttribute("result", result);
		return "calviews/addProc";
	}
	
	// 뺄셈(form, proc)
	@RequestMapping(value="/min", method=RequestMethod.GET)
	public String min(Model model) {
		return "calviews/minForm";
	}
	
	@RequestMapping(value="/min", method=RequestMethod.POST)
	public String min(Model model, int n1, int n2) {
		int result = new MinCalc().clac(n1, n2);
		model.addAttribute("n1", n1);
		model.addAttribute("n2", n2);
		model.addAttribute("result", result);
		return "calviews/minProc";
	}
	
	// 곱셈(form, proc)
	@RequestMapping(value="/mul", method=RequestMethod.GET)
	public String mul(Model model) {
		return "calviews/mulForm";
	}
	
	@RequestMapping(value="/mul", method=RequestMethod.POST)
	public String mul(Model model, int n1, int n2) {
		int result = new MulCalc().clac(n1, n2);
		model.addAttribute("n1", n1);
		model.addAttribute("n2", n2);
		model.addAttribute("result", result);
		return "calviews/mulProc";
	}
	
	// 나눗셈(form, proc)
	@RequestMapping(value="/div", method=RequestMethod.GET)
	public String div(Model model) {
		return "calviews/divForm";
	}
	
	@RequestMapping(value="/div", method=RequestMethod.POST)
	public String div(Model model, int n1, int n2) {
		int result = new DivCalc().clac(n1, n2);
		model.addAttribute("n1", n1);
		model.addAttribute("n2", n2);
		model.addAttribute("result", result);
		return "calviews/divProc";
	}
	
}
