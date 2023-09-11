package mulcam.kb04.gifthub.GiftHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mulcam.kb04.gifthub.GiftHub.dto.ExchangeDto;
import mulcam.kb04.gifthub.GiftHub.entity.CombinedView;
import mulcam.kb04.gifthub.GiftHub.service.ExchangeService;

@Controller
public class ExchangeController {
	@Autowired
	private ExchangeService exchangeService;

	@GetMapping("/exchange")
	public String getExchangeDetails(Model model, @RequestParam(value = "page", defaultValue = "1") int currentPage,
			@RequestParam(value = "storeId") String storeId) {
		List<ExchangeDto> exchangeDetailsList = exchangeService.findExchangeDetailsByStoreId(storeId);
		model.addAttribute("exchangeDetailsList", exchangeDetailsList);
		int totalDataCount = exchangeDetailsList.size();
		int dataPerPage = 10;
		int totalPages = (int) Math.ceil((double) totalDataCount / dataPerPage);
		int pagesPerGroup = 5;
		int currentGroup = (int) Math.ceil((double) currentPage / pagesPerGroup);

		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("currentGroup", currentGroup);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("storeId", storeId);
		return "list/exchange";
	}

}
