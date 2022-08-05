package schoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Springで作成する簡単なログインのサンプルクラスです。
 */
@Controller
public class SchooContoroller {
	/**
	 * トップページへのリクエスト
	 * @return index.htmlのパス
	 */
	@GetMapping("/")// ("/")はhttp://localhost:8080/にアクセスした時にこのメソッドを動かしてくれという意味
	public String index() { // 戻り値は必ずString型にする
		//index.htmlのパスを返却する
		//以下の場合、templates内のindex.htmlを表示する指示
		return "index";
	}
	/**
	 * ログイン処理リクエスト
	 * @param loginId　ログイン
	 * @param loginPassword　パスワード
	 * @return ログイン結果画面のパス
	 */
	@PostMapping("login")
	public String login(@RequestParam("loginId") String loginId,
						@RequestParam("loginPassword") String loginPassword) {
		//ログインチェック
		//今回はDB等を使用せずにリクエストパラメータと文字列の比較でチェック
		if ("schoo".equals(loginId) && "pass".equals(loginPassword)) {
			//ログイン成功
			return "login-ok";
		} else {
			//ログイン失敗
			return "login-ng";
		}
	}
}
