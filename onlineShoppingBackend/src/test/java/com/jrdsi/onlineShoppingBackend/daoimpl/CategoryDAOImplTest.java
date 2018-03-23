/*package com.jrdsi.onlineShoppingBackend.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jrdsi.onlineShoppingBackend.dao.CategoryDAO;
import com.jrdsi.onlineShoppingBackend.dto.Category;

public class CategoryDAOImplTest {

	public static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private static Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();

		context.scan("com.jrdsi.onlineShoppingBackend");

		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDao");

	}

	@Test
	public void testAddCategory() {
		Category cat1 = new Category();
		cat1.setActiveInd(true);
		cat1.setDescription("This is test Mobile category");
		cat1.setName("T");
		cat1.setImageUrl("CAT_2.png");
		assertEquals("Category Added Successfully", true, categoryDAO.addCategory(cat1));
	}

	@Test
	public void testGetCategory() {
		Category cat1 = categoryDAO.getCategory(Long.valueOf(1));

		assertNotNull(cat1);
		assertEquals("get single category record", "Television", cat1.getName());
	}

	@Test
	public void testUpdateCategory() {

		Category cat1 = categoryDAO.getCategory(Long.valueOf(1));
		cat1.setActiveInd(true);
		assertEquals("Should update the category record", true, categoryDAO.updateCategory(cat1));
		cat1 = categoryDAO.getCategory(Long.valueOf(1));
		assertEquals("Should set Active Indicator to false", true, cat1.getActiveInd());

	}

	@Test
	public void testGetCategories() {
		List<Category> categories = categoryDAO.getCategories();
		assertEquals("Should get All the categories", 1, categories.size());
	}

}
*/