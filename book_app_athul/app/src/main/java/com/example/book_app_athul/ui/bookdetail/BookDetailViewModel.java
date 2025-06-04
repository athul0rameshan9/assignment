package com.example.book_app_athul.ui.bookdetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.book_app_athul.model.Book;
import com.example.book_app_athul.repository.BookRepository;

public class BookDetailViewModel extends ViewModel {
    private final BookRepository bookRepository;

    // Constructor for ViewModelProvider
    public BookDetailViewModel() {
        this.bookRepository = BookRepository.getInstance();
    }

    // If you need to pass parameters, use a ViewModelFactory
    // public BookDetailViewModel(BookRepository bookRepository) {
    //    this.bookRepository = bookRepository;
    // }

    public LiveData<Book> getBookById(String bookId) {
        return bookRepository.getBookById(bookId);
    }
}