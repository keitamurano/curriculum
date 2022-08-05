package basketball.form;

import lombok.Data;
/**
 * 大会情報のFormクラスです
 */
@Data
public class TournamentForm {
	// 大会名
	private String tournamentName;
	// 大会開催日
	private String tournamentDate;
	// 大会開催場所
	private String tournamentVenue;
}