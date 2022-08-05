package basketball.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basketball.entity.Tournament;
import basketball.form.TournamentForm;
import basketball.repository.TournamentRepository;

/**
 * 大会のService実装クラスです.
 */
@Service
public class TournamentServiceImpl implements TournamentService {

	@Autowired
	TournamentRepository tournamentRepository;

	/**
	 * DBに登録されている全ての大会情報を検索します.
	 * @return 大会一覧
	 */
	public List<Tournament> findAll() {
		// Repositoryクラスから全ての情報を検索して返却
		return tournamentRepository.findAll();
	}

	/**
	 * 指定された大会IDからDBに登録されている大会情報を検索します.
	 * @return 大会一覧
	 */
	public List<Tournament> findByTournamentId(Integer tournamentId) {
		// Repositoryクラスから大会IDで検索した結果を返却
		return tournamentRepository.findByTournamentId(tournamentId);
	}

	/**
	 * 大会情報をDBに登録します.
	 */
	public void save(TournamentForm tournamentForm) {
		// TournamentForm内の情報をTournamentクラスに詰め替え
		Tournament tournament = new Tournament();
		tournament.setTournamentName(tournamentForm.getTournamentName());
		tournament.setTournamentDate(Date.valueOf(tournamentForm.getTournamentDate()));
		tournament.setTournamentVenue(tournamentForm.getTournamentVenue());

		// Tournamentクラスの情報を使ってDBに登録する処理を実行
		tournamentRepository.save(tournament);
	}
		// 
	public List<Tournament> deleteByTournamentId(Integer tournamentId) {
		return tournamentRepository.deleteByTournamentId(tournamentId);
	}

	public void delete1(Integer tournamentId) {
		tournamentRepository.deleteByTournamentId(tournamentId);
	}

}