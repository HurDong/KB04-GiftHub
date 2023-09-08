package mulcam.kb04.gifthub.GiftHub.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mulcam.kb04.gifthub.GiftHub.service.GiftUsedService;

@RestController
public class ListController {

	@Autowired
	private GiftUsedService giftUsedService;

	@GetMapping("/getMonthlyCount")
	public ResponseEntity<Map<Integer, Long>> getMonthlyCount() {
		Map<Integer, Long> counts = giftUsedService.getCountByMonth();
		return ResponseEntity.ok(counts);
	}

		
}