package member.controller.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegisterCommandValidator implements Validator{

	private static final String emailRegExp = 
			"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

	private Pattern pattern;	
	
	public RegisterCommandValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterCommand cmd = (RegisterCommand)target;
		if(cmd.getMemberid() == null || cmd.getMemberid().trim().isEmpty()) {
			errors.rejectValue("memberid", "required");
		}else {
			Matcher matcher = pattern.matcher(cmd.getMemberid()); //정규식을 통한 검증
			if(!matcher.matches()) {
				errors.rejectValue("memberid", "bad", new Object[] {"Email", "Format"}, "DefaultMessage"); 
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nick", "required");
		ValidationUtils.rejectIfEmpty(errors, "memberpw", "required");
		ValidationUtils.rejectIfEmpty(errors, "memberpw2", "required");
		
		if(!cmd.getMemberpw().isEmpty()) {
			if(!cmd.getMemberpw().equals(cmd.getMemberpw2())) {
				errors.rejectValue("memberpw2", "nomatch");
			}
		}
		
		
	}

}







