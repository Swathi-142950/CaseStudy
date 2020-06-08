package com.casestudy.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.casestudy.dto.PromoDto;
import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.operations.PromoOperations;

@RestController
@RequestMapping("/api/promo")
@CrossOrigin(origins = "http://localhost:4200")
public class PromoController {

	@Autowired
	private PromoOperations promoOp;
	
	@GetMapping("/fetchPromo")
	public ResponseEntity<List<PromoDto>> fetchPromo() throws CaseStudyException {
		List<PromoDto> promoList = promoOp.fetchPromo();
		return new ResponseEntity<>(promoList, HttpStatus.OK);
	}

	@PostMapping("/savePromo")
	public ResponseEntity<List<PromoDto>> savePromoDetails(@RequestBody List<PromoDto> promoDto)
			throws CaseStudyException {
		List<PromoDto> promoList = promoOp.savePromo(promoDto);
		return new ResponseEntity<>(promoList, HttpStatus.OK);
	}
}
