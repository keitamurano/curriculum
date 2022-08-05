package schoo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserForm {
	@NotBlank
	private String name;
	@NotBlank
	@Pattern(regexp = "[0-9]*")
	private String age;
	@NotBlank
	private String mailAddress;
	
	public UserForm(String name, String age, String mailAddress) {
		this.name = name;
		this.age = age;
		this.mailAddress = mailAddress;
	}
	
	public UserForm() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getMailAddress() {
		return mailAddress;
	}
	
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
}
