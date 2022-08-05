package basketball.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import basketball.form.SignupForm;
import basketball.form.UserForm;
import basketball.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;
	
	// 性別ステータスのラジオボタン用変数
	private Map<String, Integer> radioGender;
	
	// ラジオボタン初期化メソッド
	private Map<String, Integer> initRadioGender() {
		
		Map<String, Integer> radio = new LinkedHashMap<>();
		// 男性、女性、混合をMapに格納
		radio.put("男性チーム", 0);
		radio.put("女性チーム", 1);
		radio.put("混合チーム", 2);
					
		return radio;
	}
	
	@GetMapping("/home")
	public String getHome(Model model) {
		// コンテンツ部分にユーザー詳細を表示するための文字列を登録
		model.addAttribute("contents", "login/home :: home_contents");
		return "login/homeLayout";
	}
	
	@GetMapping("/userList")
	public String getUserList(Model model) {
		
		// コンテンツ部分にユーザー一覧を表示するための文字列を登録
		model.addAttribute("contents", "login/userList :: userList_contents");
		// ユーザー一覧の生成
		List<UserForm> userList = userService.selectMany();
		// Modelにユーザーリストを登録
		model.addAttribute("userList", userList);
		// データ件数を取得
		int count = userService.count();
		model.addAttribute("userListCount", count);
		return "login/homeLayout";
	}
	
	// ユーザー詳細画面のGETメソッド
	@GetMapping("/userDetail/{id:.+}")
	public String getUserDetail(@ModelAttribute SignupForm form,
			Model model,
			@PathVariable("id") String userId) {
		// ユーザーIDの確認
		System.out.println("userId = " + userId);
		
		// コンテンツ部分にユーザー詳細を表示するための文字列を登録
		model.addAttribute("contents", "login/userDetail :: userDetail_contents");
		// 性別ステータス用ラジオボタンの初期化
		radioGender = initRadioGender();
		// ラジオボタン用のMapをModelに登録
		model.addAttribute("radioGender", radioGender);
		
		// ユーザーIDのチェック
		if (userId != null && userId.length() > 0) {
			// ユーザー情報を取得
			UserForm userForm = userService.selectOne(userId);
			// Userクラスをフォームクラスに変換
			form.setUserId(userForm.getUserId());
			form.setUserName(userForm.getUserName());
			form.setTeamName(userForm.getTeamName());
			form.setGender(userForm.getGender());
			// Modelに登録
			model.addAttribute("signupForm", form);
		}
		return "login/homeLayout";
	}
	@PostMapping("/logout")
	public String postLogout() {
		return "redirect:/login";
	}
}
