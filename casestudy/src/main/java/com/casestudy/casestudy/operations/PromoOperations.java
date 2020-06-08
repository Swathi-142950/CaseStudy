package com.casestudy.casestudy.operations;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.casestudy.dto.PromoDto;
import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.model.Promo;
import com.casestudy.casestudy.repository.PromoRepo;

@Service
public class PromoOperations {

	@Autowired
	PromoRepo promoRepo;

	public List<PromoDto> fetchPromo() throws CaseStudyException {
		List<Promo> promo = promoRepo.findAll();
		List<PromoDto> promoDtoList = new ArrayList<>();
		promo.stream().forEach(promoFetch -> {
			PromoDto promoDto = new PromoDto();
			promoDto.setId(promoFetch.getId());
			promoDto.setPromoCode(promoFetch.getPromoCode());
			promoDto.setDescription(promoFetch.getDescription());
			promoDtoList.add(promoDto);
		});
		return promoDtoList;
	}

	public List<PromoDto> savePromo(List<PromoDto> promoListDto) throws CaseStudyException {
		List<Promo> promoList = new ArrayList<>();
		for (PromoDto promoPackage : promoListDto) {
			if (!promoPackage.isDeleteFlag()) {
				Promo promoFetch = promoRepo.findById(promoPackage.getId());
				if (null == promoFetch) {
					promoFetch = new Promo();
					Random random = new Random();
					promoFetch.setId(random.nextInt(10000));
					promoFetch.setPromoCode(generatePromoCode());
				} else {
					promoFetch.setPromoCode(promoPackage.getPromoCode());
				}
				promoFetch.setDescription(promoPackage.getDescription());
				promoList.add(promoFetch);
				promoRepo.save(promoList);
			} else {
				promoRepo.delete(promoPackage.getId());
			}
		}
		return fetchPromo();
	}
	
	public String generatePromoCode() { 
     	char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < 6; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output ;
	}
}
