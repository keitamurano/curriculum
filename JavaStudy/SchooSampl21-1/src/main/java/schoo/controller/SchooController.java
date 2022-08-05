package schoo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import schoo.form.UserForm;

@Controller
public class SchooController {
	/**
	 * トップページの表示
	 * @return index.htmlのパス
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}
	/**
	 * ユーザー情報登録処理
	 * @param userForm ユーザー用Form
	 * @oaram bindingResult 入力チェック結果
	 * @return 処理結果ページのパス
	 */
	@PostMapping("user-input")
	public String regist(@Validated @ModelAttribute UserForm userForm,
						BindingResult bindingResult) {
		//今回は登録処理はなし
		//入力値のチェックを行い結果によって次の画面を変更
		String result = "regist-ok";
		if(bindingResult.hasErrors()) {
			result = "regist-ng";
		}
		return result;
	}
}
