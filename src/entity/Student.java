package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// @Entity is for telling this class ot its objects will be mapped to the database's table 
// @Table is for telling the table's name on the schema 
@Entity
@Table(name="student")
public class Student {
	
	// @Id indicate this field will map to the primary key
	/* @GeneratedValue is for telling the specific strategy or rule for generating values on 
	the primary key. The usage of strategy types will be depend on the type of DBMS because each strategy type
	 may rely on unique features of the given DBMS. */
	/* As I use MySQL for this project, GenerationType.IDENTITY will be good since this type utilize the 
	its auto-incrementing feature. */
	// Note that in this case, I already enable the auto-incrementing feature on the database's table, so @GeneratedValue will be optional
	// @Column is for telling the coressponding column that will be mapped to the field
	// Note that if the field and the column have the same name, @Column will be optional
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	@Column(name="first_name")
	String first_name;
	@Column(name="last_name")
	String last_name;
	@Column(name="email")
	String email;
	
	public Student(){}

	public Student(String first_name, String last_name, String email) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Override toString() for printing out values from fields for debugging purposes , not required
	@Override
	public String toString() {
		return "Student [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + "]";
	}

	
	
}
