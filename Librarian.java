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
        readBooks.add(toBook(line));
    }
   for (Book toAdd: readBooks)
     outputFile.println(toAdd.toString());
    
   
 }
 
 public Book toBook(String info){
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
  
}