import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.*;

public class Teacher extends Borrower {
  private String ID, teacherName;
  private ArrayList<GregorianCalendar> returnDate;
  private ArrayList<Book> borrowed;
  
  public Teacher(String n, String identification, String name){
    super(n);
    ID = identification;
    teacherName = name;
    borrowed = new ArrayList<Book>();
    returnDate = new ArrayList<GregorianCalendar>();
  }
  
  public void toFile() throws IOException{
    PrintWriter outputFile =
                 new PrintWriter(new FileWriter("Teachers.txt"));
    String[] fields = {teacherName, ID};
    String write = "";
    for (String add: fields)
      write += add + ",";
    write += returnDate.toString();
    outputFile.println(write);
    
  }
  
  public void borrowBook(Book book){
    borrowed.add(book);
    GregorianCalendar date = new GregorianCalendar();
    date.add(date.WEEK_OF_MONTH,1);
    returnDate.add(date);
  }
  
  public boolean canBorrow(){
    return !(borrowed.size() == 4);
  }
  
  public ArrayList<GregorianCalendar> getReturnDate(){
    return returnDate;
  }
}