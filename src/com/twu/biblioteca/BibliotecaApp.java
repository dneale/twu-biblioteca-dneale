package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    Library lib;
    private static ArrayList<String> menuItems;

    public static void main(String[] args) {

        BibliotecaApp app = new BibliotecaApp();
        app.run();
    }

    public BibliotecaApp() {
        lib = new Library();
        menuItems = new ArrayList<String>();
        menuItems.add("listbooks - list the currently available books");
        menuItems.add("checkout - check out a book");
        menuItems.add("return - return a book");
        menuItems.add("exit - exit Biblioteca");
    }

    public void run() {
        printWelcomeMessage();
        System.out.println(listBooks());
        showMenu();
        runPrompt();
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!\n");
    }

    public String listBooks() {
        String output = "BOOK LIST (name, author, year published):\n";
        for (Book book : lib.getBookList()) {
            if (!book.isCheckedOut())
                output += book.getTitle() + ", " + book.getAuthor() + ", " + book.getYearPublished() + '\n';
        }
        return output;
    }

    public void showMenu() {
        System.out.println("MENU LIST (select an option):");
        for (String item : menuItems)
            System.out.println(item);
    }

    public void runPrompt() {
        String output;
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an option: ");
            String option = scanner.nextLine();

            if (option.equals("listbooks")) {
                output = listBooks();
            }
            else if (option.equals("checkout")) {
                System.out.print("Enter book name: ");
                String bookName = scanner.nextLine();
                output = commandCheckoutBook(bookName);
            }
            else if (option.equals("return")) {
                System.out.print("Enter book name: ");
                String bookName = scanner.nextLine();
                output = commandReturnBook(bookName);
            }
            else if (option.equals("exit")) {
                System.out.println("Exiting");
                break;
            }
            else
            {
                System.out.println("Select a valid option!");
                showMenu();
                continue;
            }
            System.out.println(output);
        }
    }

    public String commandReturnBook(String name) {
        Book b;
        try {
            b = lib.findBook(name);
        } catch (BookNotFoundException e) {
            return "That is not a valid book to return.";
        }
        if (b.isCheckedOut())
        {
            b.checkIn();
            return "Thank you for returning the book.";
        }
        else
        {
            return "That is not a valid book to return.";
        }
    }

    public String commandCheckoutBook(String name) {
        Book b;
        try {
            b = lib.findBook(name);
        } catch (BookNotFoundException e) {
            return "That book is not available.";
        }
        if (!b.isCheckedOut())
        {
            b.checkOut();
            return "Thank you! Enjoy the book.";
        }
        else
        {
            return "That book is not available.";
        }
    }


}
