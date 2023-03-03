package demo;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = StaticFunctions.createSessionFactory("hibernate.cfg.xml", Student.class);
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Student student = new Student("B", "Smith","example@gmail.com");
			
			// Start the transaction to insert the object to the table 
			StaticFunctions.saveObjectToDatabase(student, session);
		} finally {
			sessionFactory.close();
		}

	}

}
 