package com.twu.biblioteca;

public class BibliotecaApp {

    BibliotecaCLI cli;
    Library lib;

    public static void main(String[] args) {

        BibliotecaApp app = new BibliotecaApp();
        app.run();
    }

    public BibliotecaApp() {
        cli = new BibliotecaCLI();
        lib = new Library();
    }

    public void run() {
        cli.printWelcomeMessage();
        cli.showBooks(lib);


    }

}
