package schoo.form;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * ユーザー用Form
 */
@Data
public class UserForm {
	@NotNull
	private String userName;
	@NotNull
	private Integer age;
}
