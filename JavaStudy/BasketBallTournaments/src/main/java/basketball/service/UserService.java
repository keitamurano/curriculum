package basketball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basketball.form.UserForm;
import basketball.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repository;
	
	public Integer insert(UserForm userForm) {
		// insert実行
		int rowNumber = repository.insertOne(userForm);
		
		return rowNumber;
	}
	
	// カウント用メソッド
	public int count() {
		return repository.count();
	}
	
	// 全件取得用メソッド
	public List<UserForm> selectMany() {
		// 全件取得
		return repository.selectMany();
	}
	
	// 1件取得用メソッド
	public UserForm selectOne(String userId) {
		return repository.selectOne(userId);
	}
	
	// 1件更新用メソッド
	public boolean updateOne(UserForm userForm) {
		// 判定用変数
		boolean result = false;
		// 1件更新
		int rowNumber = repository.updateOne(userForm);
		if (rowNumber > 0) {
			// update成功
			result = true;
		}
		
		return result;
	}
	
	// 1件削除用メソッド
	public boolean deleteOne(String userId) {
		// 1件削除
		int rowNumber = repository.deleteOne(userId);
		// 判定用変数
		boolean result = false;
		
		if (rowNumber > 0) {
			// delete成功
			result = true;
		}
		return result;
	}
}
