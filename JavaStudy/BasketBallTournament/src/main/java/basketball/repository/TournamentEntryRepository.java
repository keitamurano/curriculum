package basketball.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import basketball.entity.TournamentEntry;

/**
 * tournament_entryテーブルを操作するためのRepositoryクラスです
 */
public interface TournamentEntryRepository extends JpaRepository<TournamentEntry, Integer> {
	/**
	 * 指定した大会IDから大会参加者の情報を検索します.
	 * @param tournamentId 大会ID
	 * @return	大会参加者一覧
	 */
	public List<TournamentEntry> findByTournamentId(Integer tournamentId);
}