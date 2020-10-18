package org.websparrow.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.websparrow.entity.STOCK;

import org.websparrow.repository.STOCKRepository;

@RestController
@RequestMapping("/STOCK")

public class STOCKController {
	
	@Autowired
	STOCKRepository stockRepository;

	// insert new category into database
	@PostMapping("/add")
	public STOCK addSTOCK(@RequestBody STOCK stock) {

		return stockRepository.save(stock);
	}

	// fetch all category list from database
	@GetMapping("/all")
	public Iterable<STOCK> allSTOCK() {

		return stockRepository.findAll();
	}

	// fetch specific category by their ID
	@GetMapping("/{stockId}")
	public Optional<STOCK> stockById(@PathVariable("stockId") int stockId) {

		return stockRepository.findById(stockId);
	}

	// update existing category
	@PutMapping("/update")
	public STOCK updateSTOCK(@RequestBody STOCK stock) {

		return stockRepository.save(stock);
	}

	// delete category from database
	@DeleteMapping("/{stockId}")
	public void deleteSTOCK(@PathVariable("stockId") int stockId) {

		stockRepository.deleteById(stockId);
	}
	
	
	 @Test
	    public void whenFindByCreatDate_thenSTOCKs1And2Returned() throws ParseException {
	        List<STOCK> result = stockRepository.findAllBycreateDate(
	          new SimpleDateFormat("DD-MM-YYYY ").parse(""));
	 
	        assertEquals(2, result.size());
	        assertTrue(result.stream()
	          .map(STOCK::getStockId)
	          .allMatch(id -> Arrays.asList(1, 2).contains(id)));
	    }
	 
	    private void assertTrue(boolean allMatch) {
		// TODO Auto-generated method stub
		
	}

		private void assertEquals(int i, int size) {
		// TODO Auto-generated method stub
		
	}

		@Test
	    public void whenFindByPurschaseDatetimeBetween_thenSTOCKs2And3Returned() throws ParseException {
	        List<STOCK> result = stockRepository.findAllBypurschaseDatetimeBetween(
	          new SimpleDateFormat("DD-MM-YYYY").parse(""),
	          new SimpleDateFormat("HR:MI").parse(""));
	 
	        assertEquals(2, result.size());
	        assertTrue(result.stream()
	          .map(STOCK::getStockId)
	          .allMatch(id -> Arrays.asList(2, 3).contains(id)));
	    }
	


}
