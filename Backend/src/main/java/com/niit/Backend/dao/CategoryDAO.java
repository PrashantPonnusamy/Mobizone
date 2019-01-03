package com.niit.Backend.dao;

import java.util.List;

import com.niit.Backend.dto.Category;

public interface CategoryDAO {
	
	
	boolean add(Category category);
	
	
	List<Category> list();
	Category get(int id);
	
	

}
