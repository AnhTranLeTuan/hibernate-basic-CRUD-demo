package demo;

import org.hibernate.Session; 
import org.hibernate.SessionFactory;

import entity.Student;

public class UpdateStudentByPersistentObjectDemo {
	


	public static void main(String[] args) {
		SessionFactory sessionFactory = StaticFunctions.createSessionFactory("hibernate.cfg.xml", Student.class);
		Session session = sessionFactory.getCurrentSession();
		
		try {
			/* I will first save the Student object to database, then use its ID to read it from 
			 database. The returned object will be the persistent object, which mean if we update it, the coressponding 
			 record on the database will also be updated. */
			/* Note that the record on the database will only be updated after we get, commit the transaction. Before that,
			 only the object in the memory will be updated. */
			
			Student student = new Student("David", "Smith","example@gmail.com");
			StaticFunctions.saveObjectToDatabase(student, session);
			System.out.println("Saved/Created student\n" + student + "\n\n\n");
			
			
			// I won't use the static function here since it won't be flexible enough for this situation
			Session session2 = sessionFactory.getCurrentSession();
			session2.beginTransaction();
			Student student2 = session2.get(Student.class, student.getId());
			// Updatte the returned object, so after calling the get, commit transaction, the database's record will be updated
			student2.setFirst_name("Harry");
			session2.getTransaction().commit();
			session2.close();
			
			// Checking the updated record by rereading it again  
			
			System.out.println("Updated student\n "+StaticFunctions.readObjectFromDatabaseByPrimaryKey(student.getId(), Student.class, sessionFactory.getCurrentSession()));
			
		} finally {
			sessionFactory.close();
		}

	}

}
 