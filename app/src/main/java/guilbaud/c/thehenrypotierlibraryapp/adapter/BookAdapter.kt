package guilbaud.c.thehenrypotierlibraryapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import guilbaud.c.thehenrypotierlibraryapp.R
import guilbaud.c.thehenrypotierlibraryapp.model.Book

/**
 * Book adapter for RecycleView
 * @author Chloe GUILBAUD
 */
class BookAdapter(private val books: Array<Book>, val clickListener:
    (Book) -> Unit) : RecyclerView.Adapter<BookViewHolder>() {

    // Reference to view for each data item
    //class BookViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    lateinit var viewGroup : ViewGroup

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): BookViewHolder {
        this.viewGroup = parent

        // Creating list item view
        val view : View =  LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_booklist_item, parent, false)

        return BookViewHolder(view)
    }


    /**
     * Replace view content for list item
     */
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        (holder as BookViewHolder).bind(books[position], clickListener)
    }

    // Return book list size
    override fun getItemCount() = books.size

}