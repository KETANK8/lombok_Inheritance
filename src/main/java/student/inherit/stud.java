/**
 * @author Ketan Kumar
 * Illustrating USE OF LOMBOK,LOGGER AND GLOBAL EXCEPTION IN STUDENT MANAGEMENT SYSTEM TO CREATE STUDENT , NON IT STUDENT, IT STUDENT TO DATABASE USING LOMBOK INHRITANCE IN HIBERNATE 
 * AND PRINT DATA OF ONE OR ALL STUDENT USING LOGGER, DELETE EMPLOYEE USING DATA ACCESS OBJECT AND HQL 
 * CREATING AND USING GLOBAL EXCEPTION
 * ILLUSTRATING INHERITANCE IN ENTITY USING HIBERNATE
 */

package student.inherit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
// USING LOMBOK
@ToString
@Getter 
@Setter
public class stud {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int stId;
	private String stFirst;
	private String stLast;
	private String Phone;

}
