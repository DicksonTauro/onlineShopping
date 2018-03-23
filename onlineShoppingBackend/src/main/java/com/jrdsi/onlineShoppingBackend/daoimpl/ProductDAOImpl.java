package com.jrdsi.onlineShoppingBackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jrdsi.onlineShoppingBackend.dao.ProductDAO;
import com.jrdsi.onlineShoppingBackend.dto.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Product getProduct(Integer id) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Product();
		}
	}

	@Override
	public List<Product> getProductList() {
		try {
			return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public boolean addProduct(Product product) {

		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		product.setActiveInd(Boolean.FALSE);
		return updateProduct(product);
	}

	@Override
	public List<Product> getActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE activeInd = :activeInd";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class)
				.setParameter("activeInd", Boolean.TRUE).getResultList();
	}

	@Override
	public List<Product> getActiveProductsByCategory(Integer categoryId) {

		String selectActiveProctsByCategory = "FROM Product WHERE activeInd = :activeInd AND categoryId = :categoryId";

		return sessionFactory.getCurrentSession().createQuery(selectActiveProctsByCategory, Product.class)
				.setParameter("activeInd", Boolean.TRUE)
				.setParameter("categoryId", categoryId)
				.getResultList();

	}

	@Override
	public List<Product> getLatestActiveProducts(Integer count) {
		String selectLatestActiveProducts = "FROM Product WHERE activeInd = :activeInd ORDER BY id";
		
		return sessionFactory.getCurrentSession().createQuery(selectLatestActiveProducts, Product.class)
		.setParameter("activeInd", Boolean.TRUE)
		.setFirstResult(0)
		.setMaxResults(count)
		.getResultList();
	}

}
