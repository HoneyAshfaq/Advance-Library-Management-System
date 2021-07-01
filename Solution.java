package honey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


class Library{
	ArrayList <String> a=new ArrayList<>();
	ArrayList <String> a1=new ArrayList<>();
	ArrayList <String> a2=new ArrayList<>();
	
	
	Library(String name1,String name2,String name3){
		a1.add(name1);
		a1.add(name2);
		a1.add(name3);		
	}
	
	void add_book(String book) {
		a.add(book);
			
	}
	void available_book() {
		System.out.println("Available books:");
	    for(int k=0;k<a.size();k++) {
			System.out.println("*"+a.get(k));
			
		}
		
	}
	void issued_book(String book,String name,String dt) {
		boolean w=true,q=true;
	      for(int i=0;i<a1.size();i++) {
			 if(a1.get(i).equals(name)) {
				  w=false;
				 System.out.println("Your ID is matched in our database");
				
			       for(int j=0;j<a.size();j++) {
				       if(a.get(j).equals(book)) {
				    	   q=false;
					System.out.printf("(%s) book is issued to (%s) on (%s)"+"\n",book,name,dt);
				
					a2.add(a.get(j));
					a.set(j,""); 
					break;
				   }
			     }
	              break;
	         }  		
	     }
	      if(w) {
	    	  System.out.println("!!!---Invalid ID---!!!");
	    	  q=false;
	       }
	      if(q) {
	    	  System.out.printf("!!!---(%s) book is not available in library (OR) you entered invalid book name---!!!"+"\n",book);
	      }
	     
	 }   
	 	
	void return_book(String book) {
		boolean g=true;
		for(int j=0;j<a2.size();j++) {
			if(a2.get(j).equals(book)){
				g=false;
				a2.remove(j);
				
		     for(int i=0;i<a.size();i++) {
			    if(a.get(i)=="") {
				a.set(i, book);
				System.out.println("Your book is returned");
				break;
			  }
			} break; 
		  }
		}
		   if(g) {
			 System.out.printf("!!!---(%s) book does not belongs to library---!!!"+"\n",book);
		   }
		
     }
}

public class Solution {
	
	public static void main(String[] args)  {
	
	    Scanner sc =new Scanner(System.in);
		Library l=new Library("Honey","Asif","Ashish");
		
		LocalDateTime dt= LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd//MM//yyyy, h:m a");
		String h=dt.format(dtf);
		
		l.add_book("Math");
		l.add_book("DSD");
		l.add_book("MPMC");
		l.add_book("PHY");
		l.add_book("IC");
		l.add_book("SIGNAL");
		l.add_book("DLD");
		l.add_book("VLSI");
		l.add_book("DS");
		
		while(true) {
			try {
	    System.out.println("---------------------------------------------------");
		System.out.println("Press 1 for adding a book in library ");
		System.out.println("Press 2 for show_available  books in library");
		System.out.println("Press 3 for issuing book");
		System.out.println("Press 4 for return a book that you issued from library");
		int number=sc.nextInt();
	
		if(number==1) {
			System.out.println("Enter a book name which you wants to add in library");
			String book_name=sc.next();
			l.add_book(book_name);
			System.out.println("your book is added");
			
		}else if(number==2) {
			l.available_book();
			
		}else if(number==3) {
			System.out.println("Enter your book name");
			String book_name=sc.next();
			System.out.println("Enter your NameID for Security Some reason");
			String name=sc.next();
			l.issued_book(book_name,name,h);
			
		}else if(number==4) {
			System.out.println("Enter the name Which book you want to return ");
			String book_name=sc.next();
			l.return_book(book_name);
			
		}else System.out.println("!!!---Ivalid no.---!!!");
		
			}catch(Exception e) {
				System.out.println("("+sc.next()+")"+" is not no. please enter a valid no.");
				
			}
		
		
	  
   }
}
	

}	
	
	
	