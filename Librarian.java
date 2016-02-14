import java.io.*;
import java.util.ArrayList;

public class Librarian 
{
  
 public void addNewBook(Book book) throws IOException{
   PrintWriter outputFile =
                 new PrintWriter(new FileWriter("Book.txt"));
   outputFile.println(book);
   outputFile.close();
   System.out.println("Book added");
 }
 
 public void removeOldBook(Book book) throws IOException{
   BufferedReader inputFile =
                 new BufferedReader(new FileReader("Book.txt"), 1024);
   PrintWriter outputFile =
                 new PrintWriter(new FileWriter("Book.txt"));
   ArrayList<Book> readBooks = new ArrayList<Book>();
   String line;
    while ((line = inputFile.readLine()) != null)
    {
      if (line.equals(book.toString()))
        continue;
      else
        readBooks.add(Book.toBook(line));
    }
   for (Book toAdd: readBooks)
     outputFile.println(toAdd.toString());
    
   
 }
  
}