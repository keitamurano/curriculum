package schoo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SchooController {
	/**
	 * トップページへのリクエスト
	 * @param input.htmlのパス
	 */
	@GetMapping("/")
	public String index() {
		return "input";
	}
	/**
	 * 入力処置リクエスト
	 * @param 入力メッセージ
	 *@return 結果画面のパス
	 */
	@PostMapping("input")
	public String input(@RequestParam String message1,
						@RequestParam String message2,
						@RequestParam String message3,
						Model model) {
		//endが入力されたらリストを作成しない
		if(!"end".equals(message3)) {
			model.addAttribute("result","処理が終了しました");
			//input画面で入力されたメッセージをリストにセット
			ArrayList<String> messages = new ArrayList<>();
			messages.add(message1);
			messages.add(message2);
			messages.add(message3);
			//インラインで表示するメッセージをセット
			model.addAttribute("messages", messages);
		}
		return "output";
	}
}
