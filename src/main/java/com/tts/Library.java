package com.tts;

import java.util.ArrayList;

public class Library {

    String libraryAddress;
    ArrayList<Book> books;

    public Library(String address) {
        this.libraryAddress = address;
        this.books = new ArrayList();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    // Method: Address
    void printAddress() {
        System.out.println(libraryAddress);
    }

    // Method: borrowBook
    public String borrowBook(String bookTitle) {
        for(int i = 0; i < this.books.size(); ++i) {
            Book libraryBook = (Book)this.books.get(i);
            String libraryBookTitle = libraryBook.getTitle();
            if (libraryBookTitle.equals(bookTitle)) {
                if (!libraryBook.isBorrowed()) {
                    libraryBook.rented();
                    System.out.println("You successfully borrowed " + libraryBookTitle);
                    return null;
                }
                System.out.println("Sorry, this book is already borrowed.");
                return null;
            }
        }
        System.out.println("Sorry, this book is not in our catalog.");
        return null;
    }
    public String returnBook(String bookTitle) {
        boolean found = false;
        for(int i = 0; i < this.books.size(); ++i) {
            Book libraryBook = (Book)this.books.get(i);
            String libraryBookTitle = libraryBook.getTitle();
            if (libraryBookTitle.equals(bookTitle)) {
                if (libraryBook.isBorrowed()) {
                    libraryBook.returned();
                    System.out.println("You successfully returned " + libraryBookTitle);
                    found = true;
                    break;
                }
                if (!found) {
                    System.out.println("Are you sure you got the book from here? It isn't in our system.");
                }
            }
        }
        System.out.println();
        return null;
    }
    // Method: printAvailableBooks
    public void printAvailableBooks() {
        boolean libraryIsEmpty = true;

        for(int i = 0; i < this.books.size(); ++i) {
            Book libraryBook = (Book)this.books.get(i);
            if (!libraryBook.isBorrowed()) {
                System.out.println(libraryBook.getTitle());
                libraryIsEmpty = false;
            }
        }

        if (libraryIsEmpty) {
            System.out.println("No book in catalog");
        }

    }
}




