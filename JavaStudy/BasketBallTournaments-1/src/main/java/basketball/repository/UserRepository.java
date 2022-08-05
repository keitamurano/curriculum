package basketball.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import basketball.form.UserForm;

public interface UserRepository {

	// Userテーブルの件数を取得
	public int count() throws DataAccessException;
	// Userテーブルにデータを1件insert
	public int insertOne(UserForm userForm) throws DataAccessException;
	// Userテーブルのデータを1件取得
	public UserForm selectOne(String userId) throws DataAccessException;
	// Userテーブルの全データを取得
	public List<UserForm> selectMany() throws DataAccessException;
	// Userテーブルを1件更新
	public int updateOne(UserForm userForm) throws DataAccessException;
	// Userテーブルを1件削除
	public int deleteOne(String useId) throws DataAccessException;
}
