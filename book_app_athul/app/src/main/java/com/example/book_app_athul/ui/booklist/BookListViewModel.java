package com.example.book_app_athul.ui.booklist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.book_app_athul.model.Book;
import com.example.book_app_athul.repository.BookRepository;
import java.util.List;

public class BookListViewModel extends ViewModel {
    private final BookRepository bookRepository;
    private LiveData<List<Book>> books;

    // Constructor for ViewModelProvider
    public BookListViewModel() {
        this.bookRepository = BookRepository.getInstance();
        this.books = bookRepository.getBooks();
    }

    // If you need to pass parameters, use a ViewModelFactory
    // public BookListViewModel(BookRepository bookRepository) {
    //    this.bookRepository = bookRepository;
    //    this.books = bookRepository.getBooks();
    // }

    public LiveData<List<Book>> getBooks() {
        if (books == null) {
            books = bookRepository.getBooks();
        }
        return books;
    }
}