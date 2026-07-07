import java.util.Scanner;

import com.dao.BookDao;
import com.dao.BookDaoJdbcImpl;
import com.pojo.Book;
import com.service.BookNotFoundException;
import com.service.BookService;
import com.service.BookServiceImpl;

public class TestBookService {
    public static void main(String[] args) {
//        BookDao dao = new BookDaoCollectionImpl();
        BookDao dao = new BookDaoJdbcImpl();
        BookService service = new BookServiceImpl(dao);
        Scanner scanner = new Scanner(System.in);

        // Pre-populating test data
//        service.save(new Book(101, "Wings Of Fire", "APJ Kalam", 700));
//        service.save(new Book(102, "Metamorphisis", "Frank Kafka", 230));
//        service.save(new Book(103, "Normal People", "Sally Rooney", 500));

        while(true) {
            System.out.println("\n--- BOOK MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Find Book by ISBN");
            System.out.println("5. Find Books by Price Range");
            System.out.println("6. Show Books Ordered by Title");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    
                    service.save(new Book(id, title, author, price));
                    System.out.println("Book saved successfully!");
                    break;

                case 2:
                    System.out.println("\n--- All Books ---");
                    for(Book b : service.list()) {
                        System.out.println(b);
                    }
                    break;

                case 3:
                    System.out.print("Enter ISBN to delete: ");
                    int deleteId = scanner.nextInt();
                    try {
                        service.delete(deleteId);
                        System.out.println("Book deleted successfully!");
                    } catch (BookNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter ISBN to find: ");
                    int findId = scanner.nextInt();
                    try {
                        System.out.println(service.find(findId));
                    } catch (BookNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter Min Price: ");
                    double min = scanner.nextDouble();
                    System.out.print("Enter Max Price: ");
                    double max = scanner.nextDouble();
                    System.out.println("\n--- Books between " + min + " and " + max + " ---");
                    for(Book b : service.findByPrice(min, max)) {
                        System.out.println(b);
                    }
                    break;

                case 6:
                    System.out.println("\n--- Books Ordered by Title ---");
                    service.listOrderByTitle().forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Exiting Application... Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
