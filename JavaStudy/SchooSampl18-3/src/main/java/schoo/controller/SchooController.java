package schoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import schoo.form.UserForm;

/**
 * Springで作成する簡単な情報入力のサンプルクラス
 */
@Controller
public class SchooController {
	/**
	 * トップページへのリクエスト
	 * @return user.htmlのパス
	 */
	@GetMapping("/")
	public String index() {
		// user.htmlのパスを返却する
		return "user";
	}
	/**
	 * 入力チェック処理リクエスト
	 * @param ユーザー情報
	 * @param ユーザー情報の入力チェック結果
	 * @return 結果画面のパス
	 */
	@PostMapping("input")
	public String login(@Validated @ModelAttribute("user") UserForm UserForm,
						BindingResult bindingResult) {
		
		System.out.println(UserForm.getName());
		System.out.println(UserForm.getAge());
		System.out.println(UserForm.getMailAddress());
		
		//入力チェック結果を確認
		if(bindingResult.hasErrors()) {
			return "input-ng";
		} else {
			return "input-ok";
		}
	}
}
