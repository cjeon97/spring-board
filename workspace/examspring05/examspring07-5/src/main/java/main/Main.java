package main;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.JavaConfigContext;
import examspring.RegisterCommand;
import service.MemberService;

public class Main {
	
	public static MemberService memberService;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfigContext.class);
		
		memberService = ctx.getBean("memberService", MemberService.class);
		
		while(true) {
			System.out.print("명령>");
			String cmd = in.nextLine();
			
			try {
				if (cmd.startsWith("regist")) {
					registProc(cmd.split(" "));
				} else if (cmd.startsWith("edit")) {
					editProc(cmd.split(" "));
				} else if (cmd.startsWith("out")) {
					outProc(cmd.split(" "));
				} else if (cmd.equalsIgnoreCase("exit")) {
					System.out.println("프로그램 종료");
					break;
				} else {
					System.out.println("도움말");
					System.out.println("regist [ID] [PW] [PW2] [NICK]");
					System.out.println("edit [ID] [CURRPW] [NEWPW1] [NEWPW2]");
					System.out.println("out [ID] [PW]");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void outProc(String[] param) {
		if(param.length < 3) {
			return;
		}
		memberService.out(param[1], param[2]);
	}

	private static void editProc(String[] param) {
		if(param.length < 5) {
			return;
		}
		memberService.editPassword(param[1], param[2], param[3], param[4]);
	}

	private static void registProc(String[] param) {
		if(param.length < 5) {
			return;
		}
		RegisterCommand cmd = new RegisterCommand();
		cmd.setMemberid(param[1]);
		cmd.setMemberpw(param[2]);
		cmd.setMemberpw2(param[3]);
		cmd.setNick(param[4]);
		memberService.regist(cmd);
	}
}
