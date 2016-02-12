import java.util.ArrayList;
import java.util.GregorianCalendar;

public abstract class Borrower
{
  private String name;
  private ArrayList<Book> borrowed;
  
  public Borrower(String n){
    name = n;
    borrowed = new ArrayList<Book>();
  }
  
  public String getName(){
    return name;
  }
  
  public ArrayList<Book> getList(){
    return borrowed;
  }
  
  public void borrowBook(Book book){
    borrowed.add(book);
  }
  
  public abstract GregorianCalendar getReturnDate();
}