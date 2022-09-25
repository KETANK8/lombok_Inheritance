/**
 * @author Ketan Kumar
 * Illustrating USE OF LOMBOK,LOGGER AND GLOBAL EXCEPTION IN STUDENT MANAGEMENT SYSTEM TO CREATE STUDENT , NON IT STUDENT, IT STUDENT TO DATABASE USING LOMBOK INHRITANCE IN HIBERNATE 
 * AND PRINT DATA OF ONE OR ALL STUDENT USING LOGGER, DELETE EMPLOYEE USING DATA ACCESS OBJECT AND HQL 
 * CREATING AND USING GLOBAL EXCEPTION
 * ILLUSTRATING INHERITANCE IN ENTITY USING HIBERNATE
 */

package student.inherit;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class studentDao {
	
	Session ses;
	
	// METHOD 1
	// CONNECT METHOD TO BEGIN SESSION AND CONNECT WITH DATABASE
	public void connect(){
		ses=HibernateUtil.getSession();		
		ses.beginTransaction();
	}

	// METHOD 2
	// DISCONNECT METHOD TO END SESSION
	public void disconnect() {
		ses.getTransaction().commit();
		ses.close();
	}

	// METHOD 3
	// REGISTER METHOD TO SAVE STUDENT IN DATABASE
	// METHOD OVERLOADING BASED ON STUDENT OBJECT PARAMETER
	public int register(stud s) {
		int count = (int) ses.save(s);// SAVING STUDENT IN SESSION
		return count;
	}
	
	// METHOD 4
	// REGISTER METHOD TO SAVE STUDENT IN DATABASE
	// METHOD OVERLOADING BASED ON STUDENT OBJECT PARAMETER
	public int register(NonIT n) {
		int count = (int) ses.save(n);// SAVING STUDENT IN SESSION
		return count;
	}
	
	// METHOD 5
	// REGISTER METHOD TO SAVE STUDENT IN DATABASE
	// METHOD OVERLOADING BASED ON STUDENT OBJECT PARAMETER
	public int register(IT i) {
		int count = (int) ses.save(i);// SAVING STUDENT IN SESSION
		return count;
	}
	
	// METHOD 6
	// DELETE METHOD TO DELETE STUDNET FROM DATA BASE USING PRIMARY KEY
	public int delete(int id) {
		Query q = ses.createQuery("delete from stud s where s.stId=: Id").setParameter("Id", id);
		int count = q.executeUpdate();
		return count;
	}
	
	// METHOD 7
	// FETCH METHOD TO FETCH DETAIL OF A STUDENT USING PRIMARY KEY
	public stud fetch(int id) {
		stud s = (stud) ses.load(stud.class, id);
		return s;
	}
	
	// METHOD 8
	// FETCH ALL METHOD TO FETCH LIST OF ALL STUDENT FROM DATABASE
	public List fetchAll() {
		Query q =  ses.createQuery(" from stud");
		List<stud> stlist = q.getResultList();// FETCHING STUDENT IN LIST OF STUDENT TYPE
		return stlist;// RETURNING LIST OF STUDENT
	}

}
