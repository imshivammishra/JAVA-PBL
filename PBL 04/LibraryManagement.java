import java.util.ArrayList;
import java.util.Scanner;

class Book {

    int id;
    String title;
    String author;
    boolean available;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    void display() {
        System.out.println("Book ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Status: " +
                (available ? "Available" : "Issued"));
        System.out.println("----------------------");
    }
}

public class LibraryManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        // Adding books
        books.add(new Book(1, "Java Programming", "James Gosling"));
        books.add(new Book(2, "Python Basics", "Guido van Rossum"));
        books.add(new Book(3, "Clean Code", "Robert Martin"));
        books.add(new Book(4, "Web Development", "Jon Duckett"));

        int choice;

        do {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Search by Title");
            System.out.println("2. Search by Author");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    boolean foundTitle = false;

                    for (Book book : books) {
                        if (book.title.equalsIgnoreCase(title)) {
                            book.display();
                            foundTitle = true;
                        }
                    }

                    if (!foundTitle) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();

                    boolean foundAuthor = false;

                    for (Book book : books) {
                        if (book.author.equalsIgnoreCase(author)) {
                            book.display();
                            foundAuthor = true;
                        }
                    }

                    if (!foundAuthor) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();

                    boolean issued = false;

                    for (Book book : books) {

                        if (book.id == issueId) {

                            if (book.available) {
                                book.available = false;
                                System.out.println("Book issued successfully.");
                            } else {
                                System.out.println("Book is already issued.");
                            }

                            issued = true;
                            break;
                        }
                    }

                    if (!issued) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();

                    boolean returned = false;

                    for (Book book : books) {

                        if (book.id == returnId) {

                            if (!book.available) {
                                book.available = true;
                                System.out.println("Book returned successfully.");
                            } else {
                                System.out.println("Book was not issued.");
                            }

                            returned = true;
                            break;
                        }
                    }

                    if (!returned) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.println("\n===== ALL BOOKS =====");

                    for (Book book : books) {
                        book.display();
                    }
                    break;

                case 6:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}