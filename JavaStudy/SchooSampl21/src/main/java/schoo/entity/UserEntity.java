package schoo.entity;

import lombok.Data;

/**
 * ユーザー用Entity
 */
@Data
public class UserEntity {
	private Integer userId;
	private String userName;
	private Integer age;
}
