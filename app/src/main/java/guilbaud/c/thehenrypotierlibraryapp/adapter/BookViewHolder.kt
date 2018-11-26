package guilbaud.c.thehenrypotierlibraryapp.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import guilbaud.c.thehenrypotierlibraryapp.R
import guilbaud.c.thehenrypotierlibraryapp.model.Book

/**
 * Book view handler for recycle view book list
 * Reference to view for each data item
 * @author Chloe GUILBAUD
 */
class BookViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    /**
     * View creation
     */
    fun bind(book: Book, clickListener: (Book) -> Unit) {
        val imageView = view.findViewById<ImageView>(R.id.book_cover)
        Glide
            .with(view)
            .load(book.cover)
            .into(imageView);
        view.findViewById<TextView>(R.id.book_title).text = book.title
        view.findViewById<TextView>(R.id.book_price).text = book.price + R.string.devise
        view.setOnClickListener { clickListener(book) }
    }

}