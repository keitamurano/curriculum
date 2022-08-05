package basketball.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * tournament_entryテーブルのEntityクラスです
 */
@Data
@Entity
@Table(name="tournament_entry")
public class TournamentEntry {
	// 大会参加ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tournament_entry_id")
	private Integer tournamentEntryId;
	// 大会ID
	@Column(name = "tournament_id")
	private Integer tournamentId;
	// 大会参加者ID
	@Column(name = "participant_id")
	private Integer participantId;
}