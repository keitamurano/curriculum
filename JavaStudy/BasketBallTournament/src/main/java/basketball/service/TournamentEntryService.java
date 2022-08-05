package basketball.service;

import java.util.List;

import basketball.entity.Participant;
import basketball.form.TournamentEntryForm;

/**
 * 大会参加者のServiceインターフェースです.
 */
public interface TournamentEntryService {
	/**
	 * 指定した大会IDに紐づく参加者の一覧を取得します.
	 * @param tournamentId 大会ID
	 * @return 参加者の一覧
	 */
	public List<Participant> findByTournamentId(Integer tournamentId);
	/**
	 * 大会参加者の情報をDBに登録します.
	 * @param tournamentEntryForm 大会参加者情報
	 */
	public void save(TournamentEntryForm tournamentEntryForm);
	/* 指定された大会IDからDBに登録されている参加者情報を検索します。
	 * @param eventId
	 * @return　大会一覧
	 */
	public List<Participant> deleteByParticipantId(Integer participantId);
	/**
	 * 参加者情報をDBから削除します。
	 */
	public void delete2(Integer participantId) ;
}