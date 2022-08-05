package basketball.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import basketball.entity.Tournament;

/**
 * tournamentテーブルを操作するためのRepositoryクラスです
 */
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
	/**
	 * 指定した大会IDから大会の情報を検索します.
	 * @param tournamentId 大会IDz
	 * @return	大会一覧
	 */
	public List<Tournament> findByTournamentId(Integer tournamentId);
	@Transactional
	public List<Tournament> deleteByTournamentId(Integer tournamentId);
}