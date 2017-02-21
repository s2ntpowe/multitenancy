package net.codejava.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import net.codejava.spring.model.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManager;
import org.springframework.transaction.annotation.Transactional;

public class UserDAOImpl implements UserDAO {
	private EntityManagerFactory entFactory;

	public UserDAOImpl(EntityManagerFactory sessionFactory) {
		this.entFactory = sessionFactory;
	}

	@Override
	public List<User> list(String tenantId) {

		SessionFactory sessionFactory = entFactory.unwrap(SessionFactory.class);
		Session session = sessionFactory
		        .withOptions()
		        .tenantIdentifier(tenantId)
		        .openSession();
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) session
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

}
