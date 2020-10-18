package org.websparrow.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.websparrow.entity.Category;
import org.websparrow.repository.CategoryRepository;



@RestController
@RequestMapping("/categorys")

public class CategoryController {
	
	@Autowired
	CategoryRepository categoryrepository;

	// insert new category into database
	@PostMapping("/add")
	public Category addCategory(@RequestBody Category category) {

		return categoryrepository.save(category);
	}

	

	// fetch all category list from database
	@GetMapping("/all")
	public Iterable<Category> allCategory() {

		return categoryrepository.findAll();
	}

	// fetch specific category by their ID
	@GetMapping("/{categoryId}")
	public Optional<Category> packproductById(@PathVariable("categoryId") int categoryId) {

		return categoryrepository.findById(categoryId);
	}

	// update existing category
	@PutMapping("/update")
	public Category updatePACKPRODCUT(@RequestBody Category category) {

		return categoryrepository.save(category);
	}

	// delete category from database
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") int categoryId) {

		categoryrepository.deleteById(categoryId);
	}



}
