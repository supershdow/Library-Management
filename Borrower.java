import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.*;

public abstract class Borrower
{
  private String name;
  
  public Borrower(String n){
    name = n;
    
  }
  
  public String getName(){
    return name;
  }
  
  public abstract void borrowBook(Book book) throws IOException;
  
  public abstract boolean canBorrow();
  
  public abstract ArrayList<GregorianCalendar> getReturnDate();
  
  public abstract boolean hasBorrowedBooks();
  
  public abstract void removeBook(Book book);
  
  public abstract String getID();
  
}