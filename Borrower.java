import java.util.ArrayList;
import java.util.GregorianCalendar;

public abstract class Borrower
{
  private String name;
  
  public Borrower(String n){
    name = n;
    
  }
  
  public String getName(){
    return name;
  }
  
  
  public abstract void borrowBook(Book book);
  
  public abstract boolean canBorrow();
  
  public abstract ArrayList<GregorianCalendar> getReturnDate();
}