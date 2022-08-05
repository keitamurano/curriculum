package basketball.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import basketball.entity.Participant;
import basketball.entity.Tournament;
import basketball.form.TournamentEditForm;
import basketball.form.TournamentEntryForm;
import basketball.form.TournamentForm;
import basketball.service.TournamentEntryService;
import basketball.service.TournamentService;

/**
 * イベントコントローラクラス
 */
@Controller
public class TournamentController {
	
	@Autowired
	TournamentService tournamentService;
	@Autowired
	TournamentEntryService tournamentEntryService;
	
	/**
	 * トップページ（大会一覧画面）を表示
	 * @param model
	 * @return 大会一覧画面のパス
	 */
	@GetMapping("/")
	public String index(Model model) {
		//DBに登録されている大会の一覧を取得
		List<Tournament> tournamentList = tournamentService.findAll();
		
		// modelに大会の一覧をセット
		model.addAttribute("tournamentList", tournamentList);
		
		//次に表示する画面のパス（htmlファイルの名称）の返却
		return "tournamentlist";
	}
	
	/**大会の登録画面を表示
	*@param model 大会ID
	*@return 大会登録画面のパス
	*/
	@GetMapping("regist")
	public String regist(Model model) {
		//次に表示する画面のパス（htmlファイルの名称）を返却
		return "regist";
	}
	
	/**
	 * 指定された大会IDの詳細画面を表示
	 * @param tournamentId 大会ID
	 * @param model
	 * @return 大会詳細画面のパス
	 */
	@GetMapping("entry/{tournamentId}")
	public String entry(@PathVariable("tournamentId") Integer tournamentId,
						Model model) {
		//引数で受け取ったイベントIDから大会の情報を取得
		//大会の情報は1件の前提で処理
		List<Tournament> tournament = tournamentService.findByTournamentId(tournamentId);
		
		//modelに結果をセット
		model.addAttribute("tournament", tournament.get(0));
		
		//引数で受け取ったイベントIDから大会の参加者情報を取得
		List<Participant> participantList =
				tournamentEntryService.findByTournamentId(tournamentId);
		
		//modelに結果をセット
		model.addAttribute("participantList", participantList);
		
		//次に表示する画面のパス（htmlファイルの名称）を返却
		return "tournamentdetail";
	}
	
	/**
	 * 大会の登録処理
	 * @param tournamentForm 大会情報
	 * @return 大会一覧画面のパス（tournamentlist.htmlへのリダイレクト）
	 */
	@PostMapping("tournamentregist")
	public String registrationTournament(@ModelAttribute TournamentForm tournamentForm) {
		//フォームから値を取得してデータベース登録処理へ
		tournamentService.save(tournamentForm);
		
		//次に表示する画面のパス（リダイレクト先のページ）を返却
		return "redirect:/";
	}
	
	/**
	 * 大会の参加処理
	 * @param tournamentEntryForm 大会参加者情報
	 * @return 大会詳細画面のパス
	 */
	@PostMapping("entry/add")
	public String entryTournament(
		@ModelAttribute TournamentEntryForm tournamentEntryForm) {
			//フォームから値を取得してデータベース登録処理へ
			tournamentEntryService.save(tournamentEntryForm);
			
			//次に表示する画面のパス（リダイレクト先のページ）を返却
			return "redirect:/entry/" + tournamentEntryForm.getTournamentId();
	}
	
	/**
	 * 大会の情報編集処理
	 * @param 
	 * 
	 */
	@GetMapping("tournamentEdit")
	public String tournamentEdit(@PathVariable Integer tournamentId, Model model) {
		Tournament tournament = tournamentService.findByTournamentId(tournamentId);
		TournamentEditForm tournamentEditForm = new TournamentEditForm();
		tournamentEditForm.setTournamentEditId(Tournament.getTournamentId());
		tournamentEditForm.setTournamentEditName(Tournament.getTournamentName());
		tournamentEditForm.setTournamentEditDate(Tournament.getTournamentDate());
		tournamentEditForm.setTournamentEditVenue(Tournament.getTournamentVenue);
		model.addAttribute(tournamentEditForm);
		return "tournamentEdit";
	}

	/**
	 * 大会の削除処理
	 * @param tournamentId
	 * @return 大会一覧画面のパス
	 */
	@GetMapping("delete1")
	public String deleteTournamentId(@RequestParam Integer tournamentId) {
		//指定されたIDを引数に削除処理へ
		tournamentService.delete1(tournamentId);
		return "redirect:/";
	}
	/**
	 * 参加者の削除処理
	 * @param participantId
	 * @return　大会詳細画面のパス
	 */
	@GetMapping("delete2")
	public String deleteByParticipantId(@RequestParam Integer participantId) {
		tournamentEntryService.delete2(participantId);
		return "redirect:/tournamentdetail";
	}
}