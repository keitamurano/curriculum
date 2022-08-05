package basketball.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * participantテーブルのEntityクラスです
 */
@Data
@Entity
@Table(name="participant")
public class Participant {
	// 参加チームID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "participant_id")
	private Integer participantId;
	// 参加チーム名
	@Column(name = "participant_tame_name")
	private String participantTeamName;
	// 代表者名
	@Column(name = "participant_name")
	private String participantName;
}