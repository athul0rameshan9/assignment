package com.example.book_app_athul.network;

import com.example.book_app_athul.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MockBookService {

    private static MockBookService instance;
    private final ArrayList<Book> mockBooks = new ArrayList<>();

    private MockBookService() {
        // Initialize with some mock data
        mockBooks.add(new Book("1", "The Great Gatsby", "F. Scott Fitzgerald", "A story of wealth, love, and the American Dream in the Roaring Twenties.", 4.5f, "ic_book_placeholder"));
        mockBooks.add(new Book("2", "To Kill a Mockingbird", "Harper Lee", "A powerful story addressing racial injustice in the American South.", 4.8f, "ic_book_placeholder"));
        mockBooks.add(new Book("3", "1984", "George Orwell", "A dystopian novel set in a totalitarian society.", 4.7f, "ic_book_placeholder"));
        mockBooks.add(new Book("4", "Pride and Prejudice", "Jane Austen", "A classic romance novel.", 4.6f, "ic_book_placeholder"));
        mockBooks.add(new Book("5", "The Catcher in the Rye", "J.D. Salinger", "A story about teenage angst and alienation.", 4.3f, "ic_book_placeholder"));
    }

    public static synchronized MockBookService getInstance() {
        if (instance == null) {
            instance = new MockBookService();
        }
        return instance;
    }

    public LiveData<List<Book>> getBooks() {
        MutableLiveData<List<Book>> data = new MutableLiveData<>();
        // Simulate network delay or async operation if needed
        data.setValue(new ArrayList<>(mockBooks)); // Return a copy
        return data;
    }

    public LiveData<Book> getBookById(String bookId) {
        MutableLiveData<Book> data = new MutableLiveData<>();
        for (Book book : mockBooks) {
            if (Objects.equals(book.getId(), bookId)) {
                data.setValue(book);
                return data;
            }
        }
        data.setValue(null); // Book not found
        return data;
    }
}