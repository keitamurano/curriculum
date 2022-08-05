package basketball.controller;


import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import basketball.form.SignupForm;
import basketball.form.UserForm;
import basketball.service.UserService;

@Controller
public class SignupController {

	@Autowired
	private UserService userService;
	
	// ラジオボタン用変数
	private Map<String, Integer> radioGender;
		
	// ラジオボタン初期化メソッド
	private Map<String, Integer> initRadioGender(){
			
		Map<String, Integer> radio = new LinkedHashMap<>();
			
		// 男性、女性、混合をMapに格納
		radio.put("男性チーム", 0);
		radio.put("女性チーム", 1);
		radio.put("混合チーム", 2);
			
		return radio;
	}
		
	@GetMapping("/signup")
	public String getSignUp(@ModelAttribute SignupForm form, Model model) {
		// ラジオボタンの初期化メソッド呼び出し
		radioGender = initRadioGender();
		
		// ラジオボタン用のMapをModelに登録
		model.addAttribute("radioGender", radioGender);
			
		// signup.htmlに画面遷移
		return "login/signup";
	}
	
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated SignupForm form,
							BindingResult bindingResult,
							Model model) {
		// 入力チェックに引っかかった場合、ユーザー登録画面に戻る
		if (bindingResult.hasErrors()) {
			// GETリクエスト用のメソッドを呼び出して、ユーザー登録画面に戻る
			return getSignUp(form, model);
		}
		// formの中身をコンソールに出して確認
		System.out.println(form);
		
		// insert用変数
		UserForm userForm = new UserForm();
		userForm.setUserId(form.getUserId());// ユーザーID
		userForm.setPassword(form.getPassword());// パスワード
		userForm.setUserName(form.getUserName());// ユーザー名
		userForm.setTeamName(form.getTeamName());// チーム名
		userForm.setGender(form.getGender());// 性別ステータス
		userForm.setRole("ROLE_GENERAL");// ロール（一般）
		
		// ユーザー登録処理
	 	Integer result = userService.insert(userForm);
		// login.htmlにリダイレクト
		return "redirect:/login";
	}
}
