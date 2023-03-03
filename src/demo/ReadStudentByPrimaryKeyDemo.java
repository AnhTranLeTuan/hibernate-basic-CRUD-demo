package demo;

import org.hibernate.Session; 
import org.hibernate.SessionFactory;

import entity.Student;

public class ReadStudentByPrimaryKeyDemo {
	


	public static void main(String[] args) {
		SessionFactory sessionFactory = StaticFunctions.createSessionFactory("hibernate.cfg.xml", Student.class);
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// I will first create the new record into the database by an object, then will use the id obtained from that object to read that record 
			Student student = new Student("David", "Smith","example@gmail.com");
			System.out.println("The student before saving\n" + student+ "\n\n\n");
			StaticFunctions.saveObjectToDatabase(student, session);
			System.out.println("Saved/Created student\n" + student+ "\n\n\n");
			
			// Reading the record using the ID of the above object
			
			Student student2 = StaticFunctions.readObjectFromDatabaseByPrimaryKey(student.getId(), Student.class, sessionFactory.getCurrentSession());
			if (student2 == null) {
				
			} else {
				System.out.println("Read student\n" + student2);
			}
			
		} finally {
			sessionFactory.close();
		}

	}

}
 