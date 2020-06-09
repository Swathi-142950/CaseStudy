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

import com.casestudy.casestudy.dto.BookingDetailsDto;
import com.casestudy.casestudy.model.BookingDetails;
import com.casestudy.casestudy.operations.BookingDetailsOperations;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingDetailsController {

	@Autowired
	BookingDetailsOperations bookingDetailsOp;
	
	@GetMapping("/getBookingDetails")
	public ResponseEntity<List<BookingDetailsDto>> getBookingDetails() {
		List<BookingDetailsDto> listBookingDetails = bookingDetailsOp.getBooking();
		return new ResponseEntity<List<BookingDetailsDto>>(listBookingDetails, HttpStatus.OK);
	}
	
	@PostMapping("/saveBookingDetails")
	public ResponseEntity<BookingDetailsDto> saveBookingDetails(@RequestBody BookingDetailsDto bookingDetailsDto) {
		BookingDetailsDto bookingReturn = bookingDetailsOp.saveBooking(bookingDetailsDto);
		return new ResponseEntity<BookingDetailsDto>(bookingReturn, HttpStatus.OK);
	}
	
}
