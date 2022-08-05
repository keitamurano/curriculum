package basketball.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import basketball.entity.Participant;

/**
 * participantテーブルを操作するためのRepositoryクラスです
 */
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
	@Transactional
	public List<Participant> deleteByParticipantId(Integer participantId);
}