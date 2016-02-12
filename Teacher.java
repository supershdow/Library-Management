import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Teacher extends Borrower {
  private String ID, teacherName;
  private GregorianCalendar returnDate;
  
  public Teacher(String n, String identification, String name){
    super(n);
    ID = identification;
    teacherName = name;
    returnDate = new GregorianCalendar();
    returnDate.add(returnDate.WEEK_OF_MONTH,2);
  }
  
  
  
  public GregorianCalendar getReturnDate(){
    return returnDate;
  }
}