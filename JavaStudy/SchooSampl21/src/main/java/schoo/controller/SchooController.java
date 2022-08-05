package schoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import schoo.entity.UserEntity;
import schoo.form.UserForm;
import schoo.service.UserService;

/**
 * ユーザー機能クラス
 */
@Controller
public class SchooController {

	@Autowired
	UserService userService;
	
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
	 * @param bindingResult 入力チェック結果
	 * @param model 次ページにわたす情報
	 * @return 処理結果ページのパス
	 */
	@PostMapping("user-input")
	public String regist(@Validated @ModelAttribute UserForm userForm,
						BindingResult bindingResult,
						Model model) {
		//今回は党力処理なし
		//入力値のチェックを行い結果によって次の画面を変更
		if(bindingResult.hasErrors()) {
			return "regist-ng";
		} else {
			UserEntity userEntity = userService.createUser(userForm);
			return "regist-ok";
		}
	}
}
