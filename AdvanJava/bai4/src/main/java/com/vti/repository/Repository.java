package com.vti.repository;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Answer;
import com.vti.entity.Exam;
import com.vti.entity.Group;
import com.vti.entity.Image;
import com.vti.entity.Question;
import com.vti.entity.QuestionCategory;
import com.vti.entity.QuestionLevel;
import com.vti.entity.RegistrationUserToken;
import com.vti.entity.ResetPasswordToken;
import com.vti.entity.Testing;
import com.vti.entity.TestingCategory;
import com.vti.entity.User;
import com.vti.entity.UserGroup;
import com.vti.utils.HibernateUtils;

public class Repository {
	private HibernateUtils hibernateUtils;

	public Repository() {
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

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<User> query = session.createQuery("FROM User");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Exam> getAllExams() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Exam> query = session.createQuery("FROM Exam");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Group> getAllGroups() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Group> query = session.createQuery("FROM Group");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Question> getAllQuestions() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Question> query = session.createQuery("FROM Question");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Testing> getAllTestings() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Testing> query = session.createQuery("FROM Testing");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	@SuppressWarnings("unchecked")
	public List<RegistrationUserToken> getAllRegistrationUserTokens() {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<RegistrationUserToken> query = session.createQuery("FROM RegistrationUserToken");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Image> getAllImages() {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Image> query = session.createQuery("FROM Image");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<ResetPasswordToken> getAllResetPasswordTokens() {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<ResetPasswordToken> query = session.createQuery("FROM ResetPasswordToken");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Answer> getAllAnswers() {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Answer> query = session.createQuery("FROM Answer ");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<QuestionCategory> getAllQuestionCategorys() {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<QuestionCategory> query = session.createQuery("FROM QuestionCategory ");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<QuestionLevel> getAllQuestionLevels() {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<QuestionLevel> query = session.createQuery("FROM QuestionLevel ");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserGroup> getAllUserGroups() {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<UserGroup> query = session.createQuery("FROM UserGroup ");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
