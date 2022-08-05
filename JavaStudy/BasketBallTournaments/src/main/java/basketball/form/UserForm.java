package basketball.form;

import lombok.Data;

@Data
public class UserForm {
	// ユーザーID
	private String userId;
	// パスワード
	private String password;
	// ユーザー名
	private String userName;
	// チーム名
	private String teamName;
	// 性別ステータス
	private String gender;
	// ロール
	private String role;
}
