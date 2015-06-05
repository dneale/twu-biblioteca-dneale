package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private static ArrayList<String> menuItems;
    private Library lib;
    Scanner scanner;

    private User currentUser;

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.run();

    }

    public BibliotecaApp() {
        lib = new Library();
        this.currentUser = new User(0, "", "", "", "");
        menuItems = new ArrayList<String>();
        menuItems.add("listbooks - list the currently available books");
        menuItems.add("listmovies - list the currently available movies");
        menuItems.add("checkout - check out a book");
        menuItems.add("return - return a book");
        menuItems.add("userinfo - view your information");
        menuItems.add("exit - exit Biblioteca");

    }

    public void run() {
        scanner = new Scanner(System.in);
        if (!runLogin())
        {
            System.out.println("Login failed. Exiting");
            return;
        }
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

    public String listMovies() {
        String output = "MOVIE LIST (name, director, year released, rating):\n";
        for (Movie movie : lib.getMovieList()) {
            if (!movie.isCheckedOut())
                output += movie.getTitle() + ", " + movie.getDirector() + ", " + movie.getYearReleased() + ", " + movie.getRating() + '\n';
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

            System.out.print("Enter an option: ");
            String option = scanner.nextLine();

            if (option.equals("listbooks")) {
                output = listBooks();
            }
            else if (option.equals("listmovies")) {
                output = listMovies();
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
            else if (option.equals("userinfo"))
            {
                output = currentUser.showInfo();
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
        } catch (ItemNotFoundException e) {
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
        } catch (ItemNotFoundException e) {
            return "That book is not available.";
        }
        if (!b.isCheckedOut())
        {
            b.checkOut(currentUser);
            return "Thank you! Enjoy the book.";
        }
        else
        {
            return "That book is not available.";
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }


    public boolean login(int id, String password)
    {
        for (User u : lib.getUserList()) {
            if (u.getId() == id){
                if (u.getPassword().equals(password)) {
                    currentUser = u;
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }

    public boolean runLogin()
    {
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        try{
            return login(Integer.parseInt(userId), password);
        }
        catch (NumberFormatException e) {
            return false;
        }

    }


}
