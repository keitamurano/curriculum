package schoo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Springで作成する簡単なセッション管理のサンプルクラス
 */
@Controller
public class SchooController {
	
	@Autowired
	private HttpSession session;
	
	/**
	 * トップページへのリクエスト
	 * @return input.htmlのパス
	 */
	@GetMapping("/")
	public String index() {
		// input.htmlのパスを返却する
		return "input";
	}
	/**
	 * セッション処理リクエスt
	 * @param messege　メッセージ
	 * @return 完了画面のパス
	 */
	@PostMapping("input")
	public String login(@RequestParam("message") String message) {
		// 現在のセッション内の情報を表示
		String sessionMessage = (String)session.getAttribute("sessionMassage");
		System.out.println("----- メッセージ（追加前） -----");
		System.out.println(sessionMessage);
		
		// メッセージを追加してセッション内に格納
		// 少し見やすくするために空白文字を間に入れる
		sessionMessage = sessionMessage + " " + message;
		session.setAttribute("sessionMessage", sessionMessage);
		
		System.out.println("----- メッセージ（追加後） -----");
		System.out.println(sessionMessage);
		
		return "finish";
	}
}
