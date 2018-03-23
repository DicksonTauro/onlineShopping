package com.jrdsi.onlineShoppingBackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jrdsi.onlineShoppingBackend.dao.CategoryDAO;
import com.jrdsi.onlineShoppingBackend.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public List<Category> getCategories() {
		String selelctActiveCategory = "FROM Category WHERE activeInd = :activeInd";
		 Query<Category> query = sessionFactory.getCurrentSession().createQuery(selelctActiveCategory, Category.class);
		 query.setParameter("activeInd", true);
		 return query.getResultList();
 	}

	//getting single category record based on id 
	@Override
	public Category getCategory(Long id) {
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	public boolean addCategory(Category category) {
		
		try{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean updateCategory(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeCategory(Category category) {
		
		category.setActiveInd(false);
		try{
			
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

}
