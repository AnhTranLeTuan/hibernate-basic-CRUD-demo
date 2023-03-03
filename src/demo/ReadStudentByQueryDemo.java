package demo;

import org.hibernate.Session; 
import org.hibernate.SessionFactory;

import entity.Student;

public class ReadStudentByQueryDemo {
	


	public static void main(String[] args) {
		SessionFactory sessionFactory = StaticFunctions.createSessionFactory("hibernate.cfg.xml", Student.class);
		Session session = sessionFactory.getCurrentSession();
		
		try {
			/* On this demo, the static function will not be effective because many queries will need to be tested.
			 The reason is that if using the static function, many sessions will also need to be created, resulting in 
			 more instructions will be executed, not really effective. */
			session.beginTransaction();
			System.out.println("\"from Student\"" + "\n" + session.createQuery("from Student").getResultList() +"\n\n\n");
			// "from Student where last_name = 'A'" will be equivalent to "from Student s where s.last_name = 'A'"
			System.out.println("\"from Student where last_name = 'A'\"" + "\n" + session.createQuery("from Student where last_name = 'A'").getResultList() +"\n\n\n");
			System.out.println("\"from Student where last_name ='A' OR first_name='B'\"" + "\n" + 
						session.createQuery("from Student where last_name ='A' OR first_name='B'").getResultList() +"\n\n\n");
			System.out.println("\"from Student where last_name LIKE '%ith'\"" + "\n" + 
					session.createQuery("from Student where last_name LIKE '%ith'").getResultList() +"\n\n\n");		
			
			session.getTransaction().commit();
			session.close();
		} finally {
			sessionFactory.close();
		}

	}

}
 