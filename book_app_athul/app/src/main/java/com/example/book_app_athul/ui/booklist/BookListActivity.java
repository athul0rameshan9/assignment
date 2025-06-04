package com.example.book_app_athul.ui.booklist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.book_app_athul.R;
import com.example.book_app_athul.model.Book;
import com.example.book_app_athul.ui.bookdetail.BookDetailActivity;
import java.util.ArrayList;

public class BookListActivity extends AppCompatActivity implements BookAdapter.OnBookClickListener {

    private BookListViewModel bookListViewModel;
    private RecyclerView recyclerViewBooks;
    private BookAdapter bookAdapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        recyclerViewBooks = findViewById(R.id.recyclerViewBooks);
        progressBar = findViewById(R.id.progressBar);

        recyclerViewBooks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewBooks.setHasFixedSize(true);

        bookAdapter = new BookAdapter(this, this);
        recyclerViewBooks.setAdapter(bookAdapter);

        // Initialize ViewModel
        bookListViewModel = new ViewModelProvider(this).get(BookListViewModel.class);

        observeViewModel();

        // Optionally, trigger data loading if not done automatically by ViewModel
        // (Our ViewModel loads data in its constructor/getter)
    }

    private void observeViewModel() {
        progressBar.setVisibility(View.VISIBLE); // Show progress bar initially

        bookListViewModel.getBooks().observe(this, books -> {
            progressBar.setVisibility(View.GONE);
            if (books != null) {
                bookAdapter.setBooks(books);
            } else {
                // Handle error or empty state
                bookAdapter.setBooks(new ArrayList<>()); // Clear list
            }
        });
    }

    @Override
    public void onBookClick(Book book) {
        Intent intent = new Intent(BookListActivity.this, BookDetailActivity.class);
        intent.putExtra(BookDetailActivity.EXTRA_BOOK_ID, book.getId());
        // If you want to pass the whole Book object (it's Parcelable):
        // intent.putExtra(BookDetailActivity.EXTRA_BOOK_OBJECT, book);
        startActivity(intent);
    }
}