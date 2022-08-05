package schoo.service;

import schoo.entity.UserEntity;
import schoo.form.UserForm;

/**
 * ユーザー用処理Serviceクラス
 */
public interface UserService {
	public UserEntity createUser(UserForm userForm);
}
