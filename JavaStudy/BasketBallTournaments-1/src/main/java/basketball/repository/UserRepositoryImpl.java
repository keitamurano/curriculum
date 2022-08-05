package basketball.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import basketball.form.UserForm;

@Repository("UserRepositoryImpl")
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	JdbcTemplate jdbc;
	
	// Userテーブルの件数を取得
	@Override
	public int count() throws DataAccessException {
		// 全権取得してカウント
		int count = jdbc.queryForObject("SELECT COUNT(*) FROM m_user", Integer.class);
		return count;
	}
	
	// Userテーブルにデータを1件insert
	@Override
	public int insertOne(UserForm userForm) throws DataAccessException {
		
		int rowNumber = jdbc.update("INSERT INTO m_user(user_id,"
				+ "password,"
				+ "user_name,"
				+ "team_name,"
				+ "gender,"
				+ "role)"
				+ "VALUES(?, ?, ?, ?, ?, ?)",
				userForm.getUserId(),
				userForm.getPassword(),
				userForm.getUserName(),
				userForm.getTeamName(),
				userForm.getGender(),
				userForm.getRole());
		return rowNumber;
	}
	
	// Userテーブルのデータを1件取得
	@Override
	public UserForm selectOne(String userId) throws DataAccessException {
		
		// 1件取得
		Map<String, Object> map = jdbc.queryForMap("SELECT * FROM m_user" + "WHERE user_id = ?", userId);
		
		// 結果返却用の変数
		UserForm userForm = new UserForm();
		
		// 取得したデータを結果返却用の変数にセットしていく
		userForm.setUserId((String) map.get("user_id")); // ユーザーID
		userForm.setPassword((String) map.get("password")); // パスワード
		userForm.setUserName((String) map.get("user_name")); // ユーザー名
		userForm.setTeamName((String) map.get("team_name")); // チーム名
		userForm.setGender((Integer) map.get("gender")); // 性別ステータス
		userForm.setRole((String) map.get("role")); // ロール
		
		return userForm;
		
	}
	
	// Userテーブルの全データを取得
	@Override
	public List<UserForm> selectMany() throws DataAccessException {
		
		// m_userテーブルのデータを全件取得
		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM m_user");
		// 結果返却用の変数
		List<UserForm> userList = new ArrayList<>();
		// 取得したデータを結果返却用のListに格納していく
		for (Map<String, Object> map : getList) {
			
			// UserFormインスタンスの生成
			UserForm userForm = new UserForm();
			// Userインスタンスに取得したデータをセットする
			userForm.setUserId((String) map.get("user_id")); // ユーザーID
			userForm.setPassword((String) map.get("password")); // パスワード
			userForm.setUserName((String) map.get("user_name")); // ユーザー名
			userForm.setTeamName((String) map.get("team_name")); // チーム名
			userForm.setGender((Integer) map.get("gender")); // 性別ステータス
			userForm.setRole((String) map.get("role")); // ロール
			// 結果返却用のListに追加
			userList.add(userForm);
		}
		return userList;
	}
		
	// Userテーブルを1件更新
	@Override
	public int updateOne(UserForm userForm) throws DataAccessException {
		return 0;
	}
	
	// Userテーブルを1件削除
	public int deleteOne(String userId) throws DataAccessException {
		return 0;
	}
	
}
