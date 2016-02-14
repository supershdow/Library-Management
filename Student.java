import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.*;

public class Student extends Borrower {
  private String offclass, OSIS, grade;
  private ArrayList<GregorianCalendar> returnDate;
  private ArrayList<Book> borrowed;
  
  public Student(String n, String ID, String g, String c){
    super(n);
    OSIS = ID;
    grade = g;
    offclass = c;
    borrowed = new ArrayList<Book>();
    returnDate = new ArrayList<GregorianCalendar>();
  }
  
  public void toFile() throws IOException{
    PrintWriter outputFile =
                 new PrintWriter(new FileWriter("Students.txt"));
    outputFile.println(toString());
  }
  
  public String toString() {
    String[] fields = {getName(), OSIS, offclass, grade};
    String write = "";
    for (String add: fields)
      write += add + ",";
    for (int i = 0; i < borrowed.size(); i++){
      write += borrowed.get(i) + "," + returnDate.toString();
      if (borrowed.size() == 2)
        write+=",";
    }
    
    return write;
  }
  
  public void borrowBook(Book book){
    borrowed.add(book);
    GregorianCalendar date = new GregorianCalendar();
    date.add(date.WEEK_OF_MONTH,2);
    returnDate.add(date);
  }
  
  public static Student findStudent(String ID) throws IOException{
    BufferedReader inputFile =
                 new BufferedReader(new FileReader("Students.txt"), 1024);
   String line;
    while ((line = inputFile.readLine()) != null)
    {
      if (line.contains(ID)){
        String[] fields = new String[4];
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
      return new Student(fields[0],fields[1],fields[2],fields[3]); 
      }
    }
    return null;
  }
  
  public boolean canBorrow(){
    return !(borrowed.size() == 2);
  }
  
  public ArrayList<GregorianCalendar> getReturnDate(){
    return returnDate;
  }
  
}