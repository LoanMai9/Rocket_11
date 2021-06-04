package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.TestingCategory;
import com.vti.utils.HibernateUtils;

public class TestingCategoryRepository {
	private HibernateUtils hibernateUtils;

	public TestingCategoryRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<TestingCategory> getAllCategories() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<TestingCategory> query = session.createQuery("FROM TestingCategory");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public TestingCategory getCategoryByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get category by id
			TestingCategory category = session.get(TestingCategory.class, id);

			return category;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public TestingCategory getCategoryByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<TestingCategory> query = session.createQuery("FROM TestingCategory WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			TestingCategory category = query.uniqueResult();

			return category;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createCategory(TestingCategory category) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(category);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateCategory(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get Testingcategory
			TestingCategory category = (TestingCategory) session.load(TestingCategory.class, id);

			// update
			category.setName(newName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateCategory(TestingCategory category) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(category);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteCategory(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get category
			TestingCategory category = (TestingCategory) session.load(TestingCategory.class, id);

			// delete
			session.delete(category);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isCategoryExistsByID(short id) {

		// get category
		TestingCategory category = getCategoryByID(id);

		// return result
		if (category == null) {
			return false;
		}

		return true;
	}

	public boolean isCategoryExistsByName(String name) {
		TestingCategory category = getCategoryByName(name);

		if (category == null) {
			return false;
		}
		return true;
	}
}
