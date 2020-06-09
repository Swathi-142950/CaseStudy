package com.casestudy.casestudy.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.casestudy.dto.BookingDetailsDto;
import com.casestudy.casestudy.dto.CarsDto;
import com.casestudy.casestudy.dto.CustomerDto;
import com.casestudy.casestudy.model.BookingDetails;
import com.casestudy.casestudy.model.Cars;
import com.casestudy.casestudy.model.Customer;
import com.casestudy.casestudy.repository.BookingRepo;

@Service
public class BookingDetailsOperations {

	@Autowired
	BookingRepo bookingRepo;
	
	public BookingDetailsDto saveBooking(BookingDetailsDto bookingDto) {
		BookingDetails booking = new BookingDetails();
		Cars cars = new Cars();
		cars.setBrand(bookingDto.getCarDetails().getBrand());
		cars.setCategory(bookingDto.getCarDetails().getCategory());
		cars.setName(bookingDto.getCarDetails().getName());
		booking.setCarDetails(cars);
		Customer customer = new Customer();
		customer.setId(bookingDto.getCustomerDetails().getId());
		customer.setCustomer_address(bookingDto.getCustomerDetails().getCustomer_address());
		customer.setCustomer_name(bookingDto.getCustomerDetails().getCustomer_name());
		customer.setCustomer_phone(bookingDto.getCustomerDetails().getCustomer_phone());
		customer.setCustomer_service_date(bookingDto.getCustomerDetails().getCustomer_service_date());
		customer.setCustomer_service_time(bookingDto.getCustomerDetails().getCustomer_service_time());
		customer.setCustomer_vehicle_number(bookingDto.getCustomerDetails().getCustomer_vehicle_number());
		booking.setCustomerDetails(customer);
		booking.setPayment(bookingDto.getPayment());
		Random random = new Random();
		booking.setId(random.nextInt(1000));
		bookingRepo.save(booking);
		bookingDto.setId(booking.getId());
		return bookingDto;
	}
	
	public List<BookingDetailsDto> getBooking() {
		List<BookingDetails> bookingList = new ArrayList<>();
		List<BookingDetailsDto> bookingListDto = new ArrayList<>();
		bookingList = bookingRepo.findAll();
		bookingList.stream().forEach(bookingFetch -> {
			BookingDetailsDto bookingdto = new BookingDetailsDto();
			CarsDto carsDto = new CarsDto();
			CustomerDto customerDto = new CustomerDto();
			carsDto.setBrand(bookingFetch.getCarDetails().getBrand());
			carsDto.setCategory(bookingFetch.getCarDetails().getCategory());
			carsDto.setName(bookingFetch.getCarDetails().getName());
			customerDto.setCustomer_address(bookingFetch.getCustomerDetails().getCustomer_address());
			customerDto.setCustomer_name(bookingFetch.getCustomerDetails().getCustomer_name());
			customerDto.setCustomer_phone(bookingFetch.getCustomerDetails().getCustomer_phone());
			customerDto.setCustomer_service_date(bookingFetch.getCustomerDetails().getCustomer_service_date());
			customerDto.setCustomer_service_time(bookingFetch.getCustomerDetails().getCustomer_service_time());
			customerDto.setCustomer_vehicle_number(bookingFetch.getCustomerDetails().getCustomer_vehicle_number());
			bookingdto.setCarDetails(carsDto);
			bookingdto.setCustomerDetails(customerDto);
			bookingdto.setPayment(bookingFetch.getPayment());
			bookingListDto.add(bookingdto);
		});
		return bookingListDto;
	}
}
