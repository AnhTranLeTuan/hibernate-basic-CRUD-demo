package demo;

import org.hibernate.SessionFactory;

import entity.Student;

public class UpdateStudentByQueryDemo {
	


	public static void main(String[] args) {
		SessionFactory sessionFactory = StaticFunctions.createSessionFactory("hibernate.cfg.xml", Student.class);
		
		try {
			// I will first print out all records in the database, then will updating all of them using the query, then reprint them again for checking 
			System.out.println("\"from Student\"");
			StaticFunctions.readObjectFromDatabaseByQuery("from Student", sessionFactory.getCurrentSession());
			System.out.println("\n\n\n");
			
			
			// Update records which change email from example@gmail.com to ex@gmail.com
			StaticFunctions.updateDatabaseRecordsByQuery("UPDATE Student set email = 'ex@gmail.com'", sessionFactory.getCurrentSession());
			
			System.out.println("\n\nRereading the records");
			System.out.println("\"from Student\"");
			StaticFunctions.readObjectFromDatabaseByQuery("from Student", sessionFactory.getCurrentSession());
			System.out.println("\n\n\n");
			
		} finally {
			sessionFactory.close();
		}

	}

}
 