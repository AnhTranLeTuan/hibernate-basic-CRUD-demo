package demo;

import org.hibernate.SessionFactory;

import entity.Student;

public class DeleteStudentByQueryDemo {
	


	public static void main(String[] args) {
		SessionFactory sessionFactory = StaticFunctions.createSessionFactory("hibernate.cfg.xml", Student.class);
		
		try {
			// I will first print out all records in the database, then will delete some records by using the query, then reprint them again for checking 
			System.out.println("\"from Student\"");
			StaticFunctions.readObjectFromDatabaseByQuery("from Student", sessionFactory.getCurrentSession());
			System.out.println("\n\n\n");
			
			
			// Delete records with first name = 'Harry'
			StaticFunctions.updateDatabaseRecordsByQuery("DELETE from Student where first_name = 'Harry'", sessionFactory.getCurrentSession());
			
			System.out.println("\n\nRereading the records");
			System.out.println("\"from Student\"");
			StaticFunctions.readObjectFromDatabaseByQuery("from Student", sessionFactory.getCurrentSession());
			System.out.println("\n\n\n");
			
		} finally {
			sessionFactory.close();
		}

	}

}
 