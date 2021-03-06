package com.niit.Backend.daoimpl;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.dao.CategoryDAO;
import com.niit.Backend.dto.Category;



@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFractory;
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category category = new Category();
		
		
		//adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("this is an television description");
		category.setImageURl("CAT_1.png");
		
		
		categories.add(category);
		
		//adding second category
category = new Category();
		
		
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("this is an mobile description");
		category.setImageURl("CAT_2.png");
		
		
		categories.add(category);
		
		

		//adding third category
category = new Category();
		
		
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("this is an laptop description");
		category.setImageURl("CAT_3.png");
		
		
		categories.add(category);
		
		
		
		
	}
	
			

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}



	@Override
	public Category get(int id) {
		// enhanced loop
		for(Category category : categories) {
			
			if(category.getId() == id) return category;
		}
		
		return null;
	}



	@Override
	@Transactional
	public boolean add(Category category) {
		
		try {
			//add category to the database table
			
			sessionFractory.getCurrentSession().persist(category);
			
			return true;
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	
	}

}
