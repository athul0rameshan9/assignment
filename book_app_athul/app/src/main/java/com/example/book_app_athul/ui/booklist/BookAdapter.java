package com.example.book_app_athul.ui.booklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.book_app_athul.R;
import com.example.book_app_athul.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> books = new ArrayList<>();
    private final OnBookClickListener onBookClickListener;
    private Context context;


    public interface OnBookClickListener {
        void onBookClick(Book book);
    }

    public BookAdapter(Context context, OnBookClickListener listener) {
        this.context = context;
        this.onBookClickListener = listener;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book currentBook = books.get(position);
        holder.titleTextView.setText(currentBook.getTitle());
        holder.authorTextView.setText(currentBook.getAuthor());

        // For placeholder, we use a fixed drawable.
        // If thumbnailUrl was a real URL, you'd use an image loading library here.
        // For now, let's assume getThumbnailUrl() might return a drawable resource name
        // or we just use the default placeholder.
        holder.thumbnailImageView.setImageResource(R.drawable.ic_book_placeholder);
        // Example if thumbnailUrl was a resource name (more complex to manage this way)
        // int imageResId = context.getResources().getIdentifier(currentBook.getThumbnailUrl(), "drawable", context.getPackageName());
        // if (imageResId != 0) {
        //    holder.thumbnailImageView.setImageResource(imageResId);
        // } else {
        //    holder.thumbnailImageView.setImageResource(R.drawable.ic_book_placeholder);
        // }


        holder.itemView.setOnClickListener(v -> {
            if (onBookClickListener != null) {
                onBookClickListener.onBookClick(currentBook);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        notifyDataSetChanged(); // In a real app, use DiffUtil for better performance
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextView;
        private final TextView authorTextView;
        private final ImageView thumbnailImageView;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewBookTitle);
            authorTextView = itemView.findViewById(R.id.textViewBookAuthor);
            thumbnailImageView = itemView.findViewById(R.id.imageViewBookThumbnail);
        }
    }
}