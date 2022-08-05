package schoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Springで作成する簡単な情報入力のサンプルクラスです.
 */
@Controller
public class SchooController {
	/**
	 * トップページへのリクエスト
	 * @return input.htmlのパス
	 */
	@GetMapping("/")
	public String index() {
		return "input";
	}
	/**
	 * 入力処理リクエスト
	 * @param 	入力メッセージ
	 * @return 結果画面のパス
	 */
	@PostMapping("input")
	public String input(@RequestParam String message,
						Model model) {
		// input画面で入力されたメッセージをModelにセット
		model.addAttribute("message", message);
		return "output";
	}
}