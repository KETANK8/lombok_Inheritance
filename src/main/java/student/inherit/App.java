/**
 * @author Ketan Kumar
 * Illustrating USE OF LOMBOK,LOGGER AND GLOBAL EXCEPTION IN STUDENT MANAGEMENT SYSTEM TO CREATE STUDENT , NON IT STUDENT, IT STUDENT TO DATABASE USING LOMBOK INHRITANCE IN HIBERNATE 
 * AND PRINT DATA OF ONE OR ALL STUDENT USING LOGGER, DELETE EMPLOYEE USING DATA ACCESS OBJECT AND HQL 
 * CREATING AND USING GLOBAL EXCEPTION
 * ILLUSTRATING INHERITANCE IN ENTITY USING HIBERNATE
 */
package student.inherit;

import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;


public class App 
{
	static Logger log=Logger.getLogger(App.class);
	
    public static void main( String[] args ) throws StudentException
    {  
     // CREATING SCANNER OBJECT
     Scanner scan = new Scanner(System.in);
     int sem,choice = 0;
     String name,no,domain;
     
     // CREATING STUDENT OBJECT
     stud st = new stud();
     // CREATING NON IT STUDENT OBJECT
     NonIT nSt = new NonIT();
     // CRATING IT STUDENT OBJECT
     IT iSt = new IT();
     // CRATING STUDENT DAO OBJECT
     studentDao dao = new studentDao();
     
     while(choice<6) {
    	 log.info("\nPress 1 - Register Student \nPress 2 - Register as NON IT \nPress 3 - Rgister as IT \nPress 4 - Fetch Student Detail \nPress 5 - Fetch All Students \nPress 6 - Remove Student \nPress 7 - Exit");
    	 log.info("\n\nEnter your choice : ");
    	 choice = scan.nextInt();
    	 
    	 switch(choice) {
 			// FIRST CASE
 			// TO ADD STUDENT
 			case 1->{
 					log.info("\nEnter First Name : "); 		
 					name = scan.next();
 					st.setStFirst(name);
 					log.info("\nEnter Last Name : ");
 					name = scan.next();
 					st.setStLast(name);
 					log.info("\nEnter Contact NO : ");
 					no = scan.next();
 					st.setPhone(no);
 					
 					// CALLLING CONNECT METHOD TO START SESSION
 					dao.connect();
 					int i = dao.register(st);// ADDING STUDENT INTO DATABASE
 					log.info(i);
 					if(i < 0)
 						// THROWING GLOBAL EXCPTION
 						throw new StudentException("\n\nStudent already exist !!!");
 					else
 						log.info("\n\nStudent added successfully.");
 					
 					// CALLING DISCONNECT METHOD TO END SESSION
 					dao.disconnect();
 					
 			}
    	 	
 			// SECOND CLASS
 			// TO ADD NOT IT STUDENT
 			case 2->{
 				log.info("\nEnter First Name : "); 		
				name = scan.next();
				nSt.setStFirst(name);
				log.info("\nEnter Last Name : ");
				name = scan.next();
				nSt.setStLast(name);
				log.info("\nEnter Contact NO : ");
				no = scan.next();
				nSt.setPhone(no);
				log.info("\nEnter Program Name : ");
				domain = scan.next();
				nSt.setProgram(domain);
				log.info("\nEnter Your Major");
				domain = scan.next();
				nSt.setMajor(domain);
				log.info("\nEnter Academic Year : ");
				sem = scan.nextInt();
				nSt.setYear(sem);
				
				// CALLLING CONNECT METHOD TO START SESSION
				dao.connect();
				int i = dao.register(nSt); // ADDING NOT TECH STUDENT
				if(i < 0)
					// THROWING GLOBAL EXCPTION					
					throw new StudentException("\n\nStudent already exist !!!");
				else
					log.info("\n\nStudent added successfully.");
				
				// CALLING DISCONNECT METHOD TO END SESSION
				dao.disconnect();
				
 			}
 			
 			// THIRD CLASS
 			// TO ADD IT STUDENT
 			case 3->{
 				log.info("\nEnter First Name : "); 		
				name = scan.next();
				iSt.setStFirst(name);
				log.info("\nEnter Last Name : ");
				name = scan.next();
				iSt.setStLast(name);
				log.info("\nEnter Contact NO : ");
				no = scan.next();
				iSt.setPhone(no);
				log.info("\nEnter Sector Name : ");
				domain = scan.next();
				iSt.setSector(domain);
				log.info("\nEnter Your Domain");
				domain = scan.next();
				iSt.setDomain(domain);
				log.info("\nEnter Semester : ");
				sem = scan.nextInt();
				iSt.setSem(sem);
				
				// CALLLING CONNECT METHOD TO START SESSION
				dao.connect();
				int i = dao.register(iSt); // ADDING TECHNICAL STUDENT
				if(i < 0)
					// THROWING GLOBAL EXCPTION
					throw new StudentException("\n\nStudent already exist !!!");
				else
					log.info("\n\nStudent added successfully.");
				
				// CALLING DISCONNECT METHOD TO END SESSION
				dao.disconnect();
 				
 			}
 			
 			// FOURTH CLASS
 			// TO FETCH STUDENT DETAIL
 			case 4 ->{
 				log.info("\nEnter Student Id");
 				int id = scan.nextInt();
 				
 				// CALLLING CONNECT METHOD TO START SESSION
 				dao.connect();
 				stud s = dao.fetch(id); // FETCHING STUDENT OBJECT FROM DATABASE
 				
 				if(s == null) // THROWING GLOBAL EXCPTION	
 					throw new StudentException("\n\nEmployee Does Not Exist!!!");
 				else
 					log.info("\n\n"+s.getStId()+" "+ s.getStFirst()+" "+s.getStLast()+" "+s.getPhone()+"\n"+s);
 				
 				// CALLING DISCONNECT METHOD TO END SESSION
 				dao.disconnect();
 			}
 			
 			// FIFTH CASE
 			// TO FETCH DETAILS OF EVERY STUDENT
 			case 5 ->{
 				
 				// CALLLING CONNECT METHOD TO START SESSION
 				dao.connect();
 				List<stud> stList = dao.fetchAll(); // FETCHING LIST OF ALL STUDENT
 				
 				if(stList == null) // THROWING GLOBAL EXCPTION
 					throw new StudentException("\n\nTable is Empty!!!");
 				else {
 					for(stud s : stList)
 						log.info("\n\n"+s.getStId()+" "+ s.getStFirst()+" "+s.getStLast()+" "+s.getPhone()+"\n"+s);
 				} 				
 				
 				// CALLING DISCONNECT METHOD TO END SESSION
 				dao.disconnect();
 				
 			}
 			
 			// SIXTH CASE
 			// TO DELETE STUDENT FORM DATABASE
 			case 6 ->{
 				
 				// CALLLING CONNECT METHOD TO START SESSION
 				dao.connect();
 				log.info("\nEnter Student Id");
 				int id = scan.nextInt();
 	
 				int i = dao.delete(id); // REMOVING STUDENT FROM DATABASE
 				
 				if(i != 1) // THROWING GLOBAL EXCPTION
 					throw new StudentException("\n\nStudent not Found!!!");
 				else {
 					log.info("\n\nStudent got successfully deleted");
 				}
 				
 				// CALLING DISCONNECT METHOD TO END SESSION
 				dao.disconnect();
 			}    		 
    	 }
     }
     
     // CLOSING SCANNER OBJECT
     scan.close();
    }
}
