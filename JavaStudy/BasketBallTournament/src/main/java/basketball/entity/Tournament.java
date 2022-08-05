package basketball.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * tounamentテーブルのEntityクラスです
 */
@Data
@Entity
@Table(name="tournament")
public class Tournament {
	// 大会ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tournament_id")
	private Integer tournamentId;
	// 大会名
	@Column(name = "tournament_name")
	private String tournamentName;
	// 大会開催場所
	@Column(name = "tournament_venue")
	private String tournamentVenue;
	// 大会日付
	@Column(name = "tournament_date")
	@Temporal(TemporalType.DATE)
	private Date tournamentDate;
}