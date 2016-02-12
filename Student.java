import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Student extends Borrower {
  private String offclass, OSIS, grade;
  private GregorianCalendar returnDate;
  
  public Student(String n, String ID, String g, String c){
    super(n);
    OSIS = ID;
    grade = g;
    offclass = c;
    returnDate = new GregorianCalendar();
    returnDate.add(returnDate.WEEK_OF_MONTH,2);
  }
  
  public GregorianCalendar getReturnDate(){
    return returnDate;
  }
  
}