package basketball.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class SignupForm {
	// 入力必須、メールアドレス形式
	// ユーザーID
	@NotBlank
	@Email
	private String userId;
	
	// 入力必須、長さ4−20まで、半角英数字のみ
	// パスワード
	@NotBlank
	@Length(min = 4, max = 20)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String password;
	
	// 入力必須
	// ユーザー名
	@NotBlank
	private String userName;
	
	// 入力必須
	// チーム名
	@NotBlank
	private String teamName;
	
	private Integer gender;
}
