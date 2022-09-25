/**
 * @author Ketan Kumar
 * Illustrating USE OF LOMBOK,LOGGER AND GLOBAL EXCEPTION IN STUDENT MANAGEMENT SYSTEM TO CREATE STUDENT , NON IT STUDENT, IT STUDENT TO DATABASE USING LOMBOK INHRITANCE IN HIBERNATE 
 * AND PRINT DATA OF ONE OR ALL STUDENT USING LOGGER, DELETE EMPLOYEE USING DATA ACCESS OBJECT AND HQL 
 * CREATING AND USING GLOBAL EXCEPTION
 * ILLUSTRATING INHERITANCE IN ENTITY USING HIBERNATE
 */

package student.inherit;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// USING LOMBOK
@Getter
@Setter
@ToString
@DiscriminatorValue("Non Technical")
@Entity
public class NonIT extends stud {
	private String program;
	private int year;
	private String major;

}
