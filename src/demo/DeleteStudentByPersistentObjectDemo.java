package demo;

import org.hibernate.SessionFactory;

import entity.Student;

public class DeleteStudentByPersistentObjectDemo {
	


	public static void main(String[] args) {
		SessionFactory sessionFactory = StaticFunctions.createSessionFactory("hibernate.cfg.xml", Student.class);
		
		try {
			/* I will first save the Student object to database, then use its ID to read it from database. The returned object
			 will be the persistent object, which mean if we call the delete method from the session object on it, the coressponding 
			 record on the database will also be deleted. */
			/* Note that the record on the database will only be deleted after we get, commit the transaction */
			
			Student student = new Student("David", "Smith","example@gmail.com");
			StaticFunctions.saveObjectToDatabase(student, sessionFactory.getCurrentSession());
			System.out.println("Saved/Created student\n" + student + "\n\n\n");
			
			// Delete the just-saved student record
			StaticFunctions.deleteRecordOnDatabaseByPersistentObject(student.getId(), Student.class,sessionFactory.getCurrentSession());
			
			// Checking by rereading it on the database, which the returned value will be null if it already get deleted
			
			if (StaticFunctions.readObjectFromDatabaseByPrimaryKey(student.getId(), Student.class, sessionFactory.getCurrentSession()) == null) {
				System.out.println("The record has been deleted");
			} else {}
		} finally {
			sessionFactory.close();
		}

	}

}
 