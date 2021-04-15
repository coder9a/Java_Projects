/**
 *  Create a library management system which is capable of issuing books to the students.
 *  Book should have info like:
 *  1. Book name
 *  2. Book Author
 *  3. Student Name
 *  User should be able to add books, return issued books, issue books
 *  Assume that all the users are registered with their IDs in the central database
 */

import java.util.ArrayList;
import java.util.Scanner;

class Book{
    public String name, author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

class MyLibrary{
    public ArrayList<Book> books;
    public MyLibrary(ArrayList<Book> books) {
        this.books = books;
    }
    public void addBook(Book book, String author){
        System.out.println("The book has been added to the library");
        this.books.add(book);
    }
    public void issueBook(Book book, String issued_to){
        System.out.println("The book has been issued from the library to " + issued_to);
        this.books.remove(book);
    }
    public void returnBook(Book b, String returned_by){
        System.out.println("The book has been returned by "+returned_by);
        this.books.add(b);
    }
}
public class LibraryManagementSystem
{
    public static void main(String[] args) {
        ArrayList<Book> bk = new ArrayList<>();
        String book, author;
        Book b1;
        MyLibrary l = null;
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("1. Display Books\n2. Add Books\n3. Issue Book\n4. Return Book\n5. Exit");
            System.out.println("Enter Choice");
            int choice = sc.nextInt();
            if(choice==1)
            {
                l = new MyLibrary(bk);
                System.out.println(l.books);
            }
            else if (choice==2)
            {
                System.out.println("Enter book name");
                book = sc.next();
                System.out.println("Enter author name");
                author = sc.next();
                b1 = new Book(book,author);
                bk.add(b1);
            }
            else if (choice==3)
            {
                System.out.println("Enter book name");
                book = sc.next();
                System.out.println("Enter author name");
                author = sc.next();
                b1 = new Book(book, author);
                System.out.println("Enter Your name");
                String name = sc.next();
                l.issueBook(b1, name);
            }
            else if (choice==4)
            {
                System.out.println("Enter book name");
                book = sc.next();
                System.out.println("Enter author name");
                author = sc.next();
                b1 = new Book(book,author);
                System.out.println("Enter Your name");
                String name = sc.next();
                l.returnBook(b1, name);
            }
            else if (choice==5)
            {
                System.exit(0);
            }
            else
                System.out.println("Enter valid option");
        }
    }
}
