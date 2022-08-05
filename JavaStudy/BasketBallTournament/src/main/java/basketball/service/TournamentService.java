package basketball.service;

import java.util.List;

import basketball.entity.Tournament;
import basketball.form.TournamentForm;

/**
 * 大会のServiceインターフェースです.
 */
public interface TournamentService {
	/**
	 * DBに登録されている全ての大会情報を検索します.
	 * @return 大会一覧
	 */
	public List<Tournament> findAll();
	/**
	 * 指定された大会IDからDBに登録されている大会情報を検索します.
	 * @return 大会一覧
	 */
	public List<Tournament> findByTournamentId(Integer tournamentId);
	/**
	 * 大会情報をDBに登録します.
	 */
	public void save(TournamentForm tournamentForm);
	/**
	 * 指定された大会IDからDBに登録されている大会情報を検索します。
	 * @param eventId
	 * @return　大会一覧
	 */
	public List<Tournament> deleteByTournamentId(Integer tournamentId);
	/**
	 * 大会情報をDBから削除します。
	 */
	public void delete1(Integer tournamentId) ;
}
