package schoo.service;

import org.springframework.stereotype.Service;

import schoo.entity.UserEntity;
import schoo.form.UserForm;

/**
 * ユーザー用処理Serviceクラス
 */
@Service
public class UserServiceimple {
	//ユーザーID管理用
	private int userId = 0;
	
	public UserEntity createUser(UserForm userForm) {
		//ユーザー情報
		//Entityクラスは本来DBなどに格納する用途（今回はDBの使用なしなのでここまで）
		UserEntity userEntity = new UserEntity();
		//ユーザーIDを更新（IDも本来はDBなどで管理する）
		userId = userId + 1;
		userEntity.setUserId(userId);
		userEntity.setUserName(userForm.getUserName());
		userEntity.setAge(userForm.getAge());
		return userEntity;
	}
}
