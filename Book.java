import java.io.*;
import java.util.ArrayList;

public class Book {
  private String ISBN, bookName, author, category, status;
  private boolean available;
  private ArrayList<String> borrowerIDs;
  
  //Constructor for a Book object  
  public Book(String ID, String bname, String auth, String cat, String stat) throws IOException{
    ISBN = ID;
    bookName = bname;
    author = auth;
    category = cat;
    status = stat;
    available = true;
    borrowerIDs = new ArrayList<String>();
    loadPreviousBorrowers();
  }
  
  //Method to convert something to strings
  public String toString(){
    String[] fields = {ISBN, bookName, author, category, status};
    String write = "";
    for (String add: fields)
      write += add + ",";
    for (String id: borrowerIDs)
      write += id + ",";
    return write.substring(0, write.length() - 1);
  }
  
  public static Book toBook(String info) throws IOException{
   String[] fields = new String[5];
   for (int i = 0; i < 5; i++){
     if (info.indexOf(",") == -1){
       fields[i] = info;
       break;
     }
     fields[i] = info.substring(0,info.indexOf(","));
     info = info.substring(info.indexOf(",") + 1);
   }
   return new Book(fields[0],fields[1],fields[2],fields[3],fields[4]);
 }
  
  //Method to change a book's status
  public void updateStatus(String newStatus){
    status = newStatus;
  }
  
  //Checks if a book is available
  public boolean isAvailable(){
    return available;
  }
  
  //If a user wants to borrow a book, the book's availability status is changed to unavailable
  public void borrow(){
    available = false;
  }
  
  //If a user wants to return a book, the book's availability status is changed to available
  public void handIn(){
    available = true;
  }
  
  public void loadPreviousBorrowers() throws IOException{
    BufferedReader inputFile =
                 new BufferedReader(new FileReader("Books.txt"), 1024);
    String line;
    while ((line = inputFile.readLine()) != null)
    {
      if (line.contains(ISBN)){
        ArrayList<String> users = new ArrayList<String>();
        for (int i = 0; i < line.length(); i++)
          if (line.charAt(i) == ','){
          users.add(line.substring(0,i));
          line = line.substring(i+1);
          i = 0;
        }
        for (int i = 7; i < users.size(); i++){
          if (Student.findStudent(users.get(i)) != null)
            borrowerIDs.add(Student.findStudent(users.get(i)).getID());
          else if (Teacher.findTeacher(users.get(i)) != null)
            borrowerIDs.add(Teacher.findTeacher(users.get(i)).getID());
        }
      }
    }
    
  }
  
  
  public ArrayList<Student> getBorrowHistory() throws IOException{
    ArrayList<Student> borrowers = new ArrayList<Student>();
    for (String ID: borrowerIDs)
      borrowers.add(Student.findStudent(ID));
    return borrowers;
  }
    
}
