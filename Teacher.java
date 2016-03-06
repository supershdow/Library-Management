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
        BufferedReader inputFile =
                 new BufferedReader(new FileReader("Teachers.txt"), 1024);
    ArrayList<String> teachers = new ArrayList<String>();
    String line;
    while ((line = inputFile.readLine()) != null){
      if (toString().contains(line))
        teachers.add(toString());
      else
        teachers.add(line);
    }
    PrintWriter outputFile =
                 new PrintWriter(new FileWriter("Teachers.txt"));
    for (String add: teachers)
      outputFile.println(add);
    inputFile.close();
    outputFile.close();
    
  }
  
  public void borrowBook(Book book){
    borrowed.add(book);
    GregorianCalendar date = new GregorianCalendar();
    date.add(date.WEEK_OF_MONTH,1);
    returnDate.add(date);
    book.borrow();
  }
  
  public boolean canBorrow(){
    return !(borrowed.size() == 4);
  }
  
  public boolean hasBorrowedBooks(){
    return borrowed.size() > 0;
  }
  
  public ArrayList<GregorianCalendar> getReturnDate(){
    return returnDate;
  }
  
  public static Teacher findTeacher(String info) throws IOException{
    BufferedReader inputFile =
                 new BufferedReader(new FileReader("Students.txt"), 1024);
   String line;
    while ((line = inputFile.readLine()) != null)
    {
      if (line.contains(info)){
        String[] fields = new String[3];
        fields[0] = line.substring(0,line.indexOf(",",line.indexOf(",")+1));
        line = line.substring(line.indexOf(",",line.indexOf(",")+1)+1);
        for (int i = 1; i < fields.length; i++){
          if (line.indexOf(",") == -1){
            fields[i] = line;
            break;
          }
          fields[i] = line.substring(0,line.indexOf(","));
          line = line.substring(line.indexOf(",") + 1);
        }
      return new Teacher(fields[0],fields[1],fields[2]); 
      }
    }
    return null;
  }
  
  public void removeBook(Book book){
    returnDate.remove(borrowed.indexOf(book));
    borrowed.remove(book);
    book.handIn();
  }
  
  public String getID(){
    return ID;
  }
 }