package schoo.service;

import org.springframework.stereotype.Service;

import schoo.entity.UserEntity;
import schoo.form.UserForm;

/**
*ユーザー用処理Serviceクラス
*/
@Service
public class UserServiceImple implements UserService {
	/**
	 * ユーザーFormの内容をEntityに変換して返す
	 * @param userForm ユーザーForm情報
	 * @return ユーザーEntityクラス
	 */
	public UserEntity createUser(UserForm userForm) {
		//FormクラスからEntityクラスに情報を詰め替え
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(userForm.getUserName());
		userEntity.setAge(userForm.getAge());
		return userEntity;
	}
}