package schoo.form;

import javax.validation.constraints.NotNull;

/**
 * ログイン用Form
 */
public class LoginForm {
	@NotNull
	private String loginId;
	@NotNull
	private String loginPassword;
	/**
	 * @return loginId
	 */
	public String getLoginId(String loginId) {
		return loginId;
	}
	/**
	 * @param loginId セットする loginId
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**
	 * @param loginPassword
	 */
	public String getLoginPassword(String loginPassword) {
		return loginPassword;
	}
	/**
	 * @param loginPassword セットする loginPassword
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
}
