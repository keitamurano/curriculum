package schoo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import schoo.form.LoginForm;

/**
 * ログイン機能クラス
 */
@Controller
public class SchooController {
	
	@Autowired
	HttpSession session;
	
	@ModelAttribute
	public LoginForm setUpForm() {
		return new LoginForm();
	}
	/**
	 * トップページの表示<br>
	 * ログイン済みの場合はログアウト画面を表示
	 * @return
	 */
	@GetMapping("/")
	public String index(Model model) {
		//ログイン状態のチェック
		String login = (String)session.getAttribute("login");
		if ("ok".equals(login)) {
			model.addAttribute("userName", "スクー太郎");
			return "logout";
		} else {
			return "index";
		}
	}
	/**
	 * ログイン処理
	 * @param loginForm ログインForm
	 * @param bindengResult 入力チェック結果
	 * @return 処理結果ページのパス
	 */
	@PostMapping("login")
	public String login(@Validated LoginForm loginForm,
						BindingResult bindingResult,
						Model model) {
		//入力チェック
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "ログインできませんでした");
			return "index";
		}
		//IDとパスワードのチェック
		if ("schoo".equals(loginForm.getLoginId()) &&
			"pass".equals(loginForm.getLoginPassword())) {
			session.setAttribute("login", "ok");
			model.addAttribute("userName","スクー太郎");
			return "login";
		} else {
			model.addAttribute("message", "ログアウトしました");
			return "index";
		}
	}
	/**
	 * ログアウト処理
	 * @return
	 */
	@GetMapping("logout")
	public String logout(Model model) {
		session.invalidate();
		model.addAttribute("message", "ログアウトしました");
		return "index";
	}
}
