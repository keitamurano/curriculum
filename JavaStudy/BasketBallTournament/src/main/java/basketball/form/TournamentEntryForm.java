package basketball.form;

import lombok.Data;
/**
 * 大会参加情報のFormクラスです
 */
@Data
public class TournamentEntryForm {
	// 大会ID
	private Integer tournamentId;
	// 大会参加者代表者名
	private String participantName;
	// 大会参加チーム名
	private String participantTeamName;
	
}