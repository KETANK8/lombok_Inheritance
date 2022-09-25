/**
 * @author Ketan Kumar
 * Illustrating USE OF LOMBOK,LOGGER AND GLOBAL EXCEPTION IN STUDENT MANAGEMENT SYSTEM TO CREATE STUDENT , NON IT STUDENT, IT STUDENT TO DATABASE USING LOMBOK INHRITANCE IN HIBERNATE 
 * AND PRINT DATA OF ONE OR ALL STUDENT USING LOGGER, DELETE EMPLOYEE USING DATA ACCESS OBJECT AND HQL 
 * CREATING AND USING GLOBAL EXCEPTION
 * ILLUSTRATING INHERITANCE IN ENTITY USING HIBERNATE
 */

package student.inherit;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

// IMPLEMENTING HIBERNATE
// SETTING HIBERNATE USING HIBERNATE PROPERTIES AND WITHOUT CREATTING CFG FILE
public class HibernateUtil {

	private static SessionFactory sesfac;
	
	public static SessionFactory getSessionFactory() {
		
		if(sesfac==null) {
			
		try {
				Configuration config=new Configuration();
				Properties pro=new Properties();
			
				pro.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
				pro.put(Environment.URL, "jdbc:mysql://localhost:3306/student");
				pro.put(Environment.USER,"root" );
				pro.put(Environment.PASS, "142307");
				pro.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
				pro.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				pro.put(Environment.HBM2DDL_AUTO,"update");
				pro.put(Environment.SHOW_SQL,"false");
				
				config.setProperties(pro);
				config.addAnnotatedClass(stud.class).addAnnotatedClass(NonIT.class).addAnnotatedClass(IT.class);
				sesfac=config.buildSessionFactory();
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		return sesfac;
	}
	
	public static Session getSession() {
		
		return getSessionFactory().openSession();
	}
}
