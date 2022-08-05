package basketball.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basketball.entity.Participant;
import basketball.entity.TournamentEntry;
import basketball.form.TournamentEntryForm;
import basketball.repository.ParticipantRepository;
import basketball.repository.TournamentEntryRepository;

/**
 * イベント参加者のService実装クラスです.
 */
@Service
public class TournamentEntryServiceImpl implements TournamentEntryService {

	@Autowired
	TournamentEntryRepository tournamentEntryRepository;
	@Autowired
	ParticipantRepository participantRepository;

	/**
	 * 指定したイベントIDに紐づく参加者の一覧を取得します.
	 * @param tournamentId イベントID
	 * @return 参加者の一覧
	 */
	public List<Participant> findByTournamentId(Integer tournamentId) {
		// 指定したイベントIDから大会参加者の情報を取得
		List<TournamentEntry> tournamentEntryList =
			tournamentEntryRepository.findByTournamentId(tournamentId);

		// 大会参加者のIDを取得
		// 大会参加者は複数いる可能性がある
		List<Integer> ids = new ArrayList<Integer>();
		for(TournamentEntry tournamentEntry : tournamentEntryList) {
			ids.add(tournamentEntry.getParticipantId());
		}

		// 大会参加者の情報を検索して返却
		List<Participant> participantList =
			participantRepository.findAllById(ids);
		return participantList;
	}

	/**
	 * 大会参加者の情報をDBに登録します.
	 * @param tournamentEntryForm 大会参加者情報
	 */
	public void save(TournamentEntryForm tournamentEntryForm) {
		// 大会参加代表者・チームの情報を登録
		Participant participant = new Participant();
		participant.setParticipantName(tournamentEntryForm.getParticipantName());
		participant.setParticipantTeamName(tournamentEntryForm.getParticipantTeamName());
		participantRepository.save(participant);

		// 大会参加情報を登録
		TournamentEntry tournamentEntry = new TournamentEntry();
		tournamentEntry.setTournamentId(tournamentEntryForm.getTournamentId());
		tournamentEntry.setParticipantId(participant.getParticipantId());
		tournamentEntryRepository.save(tournamentEntry);
	}
	
	public List<Participant> deleteByParticipantId(Integer participantId) {
		return participantRepository.deleteByParticipantId(participantId);
	}

	public void delete2(Integer participantId) {
		participantRepository.deleteByParticipantId(participantId);
	}
}