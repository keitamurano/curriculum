package basketball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String getLogin(Model model) {
		// login.htmlに遷移
		return "login/login";
	}
	
	@PostMapping("/login")
	public String postLogin(Model model) {
		// ホーム画面に遷移
		return "redirect:/home";
	}
}
