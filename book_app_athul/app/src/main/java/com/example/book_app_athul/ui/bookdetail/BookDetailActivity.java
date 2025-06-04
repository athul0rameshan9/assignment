package com.example.book_app_athul.ui.bookdetail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.book_app_athul.R;
import com.example.book_app_athul.model.Book;
import java.util.Locale;

public class BookDetailActivity extends AppCompatActivity {

    public static final String EXTRA_BOOK_ID = "com.example.book_app_athul.EXTRA_BOOK_ID";
    // public static final String EXTRA_BOOK_OBJECT = "com.example.book_app_athul.EXTRA_BOOK_OBJECT"; // If passing full object

    private BookDetailViewModel bookDetailViewModel;

    private ImageView imageViewBookCover;
    private TextView textViewDetailTitle;
    private TextView textViewDetailAuthor;
    private TextView textViewDetailDescription;
    private TextView textViewDetailRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        imageViewBookCover = findViewById(R.id.imageViewBookCover);
        textViewDetailTitle = findViewById(R.id.textViewDetailTitle);
        textViewDetailAuthor = findViewById(R.id.textViewDetailAuthor);
        textViewDetailDescription = findViewById(R.id.textViewDetailDescription);
        textViewDetailRating = findViewById(R.id.textViewDetailRating);

        bookDetailViewModel = new ViewModelProvider(this).get(BookDetailViewModel.class);

        String bookId = getIntent().getStringExtra(EXTRA_BOOK_ID);
        // Book bookFromIntent = getIntent().getParcelableExtra(EXTRA_BOOK_OBJECT); // If passing full object

        if (bookId != null) {
            observeViewModel(bookId);
        }
        // else if (bookFromIntent != null) {
        //    populateUI(bookFromIntent);
        // }
        else {
            Toast.makeText(this, "Book ID not found.", Toast.LENGTH_SHORT).show();
            finish(); // Close activity if no ID
        }
    }

    private void observeViewModel(String bookId) {
        bookDetailViewModel.getBookById(bookId).observe(this, book -> {
            if (book != null) {
                populateUI(book);
            } else {
                Toast.makeText(this, "Book details not found.", Toast.LENGTH_SHORT).show();
                // Optionally finish activity or show error state
            }
        });
    }

    private void populateUI(Book book) {
        textViewDetailTitle.setText(book.getTitle());
        textViewDetailAuthor.setText(book.getAuthor());
        textViewDetailDescription.setText(book.getDescription());
        textViewDetailRating.setText(String.format(Locale.getDefault(), "%.1f / 5.0", book.getRating()));

        // Using placeholder image
        imageViewBookCover.setImageResource(R.drawable.ic_book_placeholder);
        // If book.getThumbnailUrl() was a drawable resource name:
        // int imageResId = getResources().getIdentifier(book.getThumbnailUrl(), "drawable", getPackageName());
        // if (imageResId != 0) {
        //    imageViewBookCover.setImageResource(imageResId);
        // } else {
        //    imageViewBookCover.setImageResource(R.drawable.ic_book_placeholder);
        // }

        // Set activity title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(book.getTitle());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Show back button
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Handle back button press in action bar
        return true;
    }
}