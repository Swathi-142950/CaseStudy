package com.casestudy.casestudy.operations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.casestudy.dto.WasherDto;
import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.model.Washer;
import com.casestudy.casestudy.repository.WasherRepo;

@Service
public class WasherOperations {

	@Autowired
	WasherRepo washerRepo;
	
	public List<WasherDto> getAllWashers() {
		List<WasherDto> washerDtoList = new ArrayList<>();
		
		List<Washer> washerList = washerRepo.findAll();
		washerList.stream().forEach(washer->{
			WasherDto washerDto = new WasherDto();
			washerDto.setId(washer.getId());
			washerDto.setName(washer.getName());
			washerDto.setRatings(washer.getRatings());
			washerDto.setPhoneNumber(washer.getPhoneNumber());
			washerDtoList.add(washerDto);
		});
		return washerDtoList;
	}
	 
	public List<WasherDto> addOrUpdateWasher(List<WasherDto> washerDtoList) throws CaseStudyException{
		List<Washer> washerList = new ArrayList<>();
		for(WasherDto washerDto : washerDtoList) {
			Washer washer = washerRepo.findById(washerDto.getId());
			if(null == washer) {
				washer = new Washer();
				Random random = new Random();
				washer.setId(random.nextInt(10000));
			}
			washer.setName(washerDto.getName());
			washer.setPhoneNumber(washerDto.getPhoneNumber());
			washer.setStatus("Active");
			washer.setRatings(washerDto.getRatings());
			washerList.add(washer);
		}
		washerRepo.save(washerList);
		return getAllWashers();
	}
	
	public List<WasherDto> activeOrInactiveWasher(List<WasherDto> washerdtos) {
		List<Washer> washerList = new ArrayList<>();
		for(WasherDto washerPackage : washerdtos) {
			Washer washerFetch = washerRepo.findById((washerPackage.getId()));
			washerFetch.setEmailId(washerPackage.getEmailId());
			washerFetch.setName(washerPackage.getName());
			washerFetch.setPhoneNumber(washerPackage.getPhoneNumber());
			washerFetch.setStatus(washerPackage.getStatus());
			washerList.add(washerFetch);
			washerRepo.save(washerList);
		}
		return getAllWashers();
	}
	
	public ByteArrayInputStream washerReportToExcelFile() throws CaseStudyException{
		
		try(Workbook workbook = new XSSFWorkbook()){
			 List<WasherDto> washers = getAllWashers();
				
			Sheet sheet = workbook.createSheet("Washers");
			
			Row row = sheet.createRow(0);
	        Cell cell = row.createCell(0);
	        cell.setCellValue("WasherId");
	        
	        cell = row.createCell(1);
	        cell.setCellValue("Name");

	        cell = row.createCell(2);
	        cell.setCellValue("Mobile");
	
	        cell = row.createCell(3);
	        cell.setCellValue("Email");
	        
	        cell = row.createCell(4);
	        cell.setCellValue("Ratings");
	        for(int i = 0; i < washers.size(); i++) {
	        	Row dataRow = sheet.createRow(i + 1);
	        	dataRow.createCell(0).setCellValue(washers.get(i).getId());
	        	dataRow.createCell(1).setCellValue(washers.get(i).getName());
	        	dataRow.createCell(2).setCellValue(washers.get(i).getPhoneNumber());
	        	dataRow.createCell(3).setCellValue(washers.get(i).getEmailId());
	        	dataRow.createCell(4).setCellValue(washers.get(i).getRatings());
	        }

	        sheet.autoSizeColumn(0);
	        sheet.autoSizeColumn(1);
	        sheet.autoSizeColumn(2);
	        sheet.autoSizeColumn(3);
	        ByteArrayOutputStream outputStreambyte = new ByteArrayOutputStream();
	        workbook.write(outputStreambyte);
	        return new ByteArrayInputStream(outputStreambyte.toByteArray());
		} catch (IOException ex) {
			throw new CaseStudyException("Could not create Excel Sheet" + ex.getMessage());
		}
	}
	
}
