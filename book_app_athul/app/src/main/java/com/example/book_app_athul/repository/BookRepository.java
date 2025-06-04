package com.example.book_app_athul.repository;

import androidx.lifecycle.LiveData;
import com.example.book_app_athul.model.Book;
import com.example.book_app_athul.network.MockBookService; // Or your Retrofit service
import java.util.List;

public class BookRepository {
    private static BookRepository instance;
    private final MockBookService mockBookService;

    private BookRepository(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    public static synchronized BookRepository getInstance() {
        if (instance == null) {
            // In a real app, you might inject the service
            instance = new BookRepository(MockBookService.getInstance());
        }
        return instance;
    }

    public LiveData<List<Book>> getBooks() {
        return mockBookService.getBooks();
    }

    public LiveData<Book> getBookById(String bookId) {
        return mockBookService.getBookById(bookId);
    }
}