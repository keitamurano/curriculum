package schoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import schoo.form.UserForm;

@Controller
public class SchooController {
	
	@GetMapping("/")
	public String index() {
		return "user";
	}
	
	@PostMapping("input")
	public String input(@Validated@ModelAttribute UserForm userForm,
						BindingResult bindingResult,
						Model model) {
		String message;
		
		if(bindingResult.hasErrors()) {
			message = "入力に誤りがあります。";
		}else {
			message = "正しく入力できました。";
		}
		
		model.addAttribute("message", message);
		
		return "user";
	}
}
