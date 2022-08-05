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
}
