package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.repository.Board;
import board.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("list", boardService.list());
		return "board/list";
	}
	
	@RequestMapping(value="detail/{num}", method=RequestMethod.GET)
	public String detail(@PathVariable("num") long num, Model model) {
		boardService.readCnt(num);
		model.addAttribute("board", boardService.detail(num));
		return "board/detail";
	}
	
	@RequestMapping(value="regist", method=RequestMethod.GET)
	public String form(@ModelAttribute("command")BoardCommand cmd) {
		return "board/regist";
	}
	
	@RequestMapping(value="regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute("command")BoardCommand cmd, Errors errors) {
		Board board = new Board();
		board.setTitle(cmd.getTitle());
		board.setContent(cmd.getContent());
		boardService.regist(board);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="edit/{num}", method=RequestMethod.GET)
	public String edit(@PathVariable("num")long num, Model model) {
		model.addAttribute("command", boardService.detail(num));
		return "board/edit";
	}
	
	@RequestMapping(value="edit/{num}", method=RequestMethod.POST)
	public String edit(
			@PathVariable("num")long num, 
			@ModelAttribute("command")BoardCommand cmd, 
			Errors errors) {
		Board board = new Board();
		board.setNum(cmd.getNum());
		board.setTitle(cmd.getTitle());
		board.setContent(cmd.getContent());
		boardService.edit(board);
		return "redirect:/board/detail/" + cmd.getNum();
	}
	
	@RequestMapping(value="remove/{num}", method=RequestMethod.GET)
	public String remove(@PathVariable("num")long num, Model model) {
		model.addAttribute("command", boardService.detail(num));
		return "board/remove";
	}
	
	@RequestMapping(value="remove/{num}", method=RequestMethod.POST)
	public String remove(@PathVariable("num")long num) {
		boardService.remove(num);
		return "redirect:/board/list";
	}
	

}
