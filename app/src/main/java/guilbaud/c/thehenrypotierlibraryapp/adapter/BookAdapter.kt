package guilbaud.c.thehenrypotierlibraryapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import guilbaud.c.thehenrypotierlibraryapp.R
import guilbaud.c.thehenrypotierlibraryapp.model.Book

/**
 * Book adapter for RecycleView
 * @author Chloe GUILBAUD
 */
class BookAdapter(private val books: Array<Book>, val clickListener:
    (Book) -> Unit) : RecyclerView.Adapter<BookViewHolder>() {

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
     * Replace view content for book list item
     */
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position], clickListener)
    }

    // Return book list size
    override fun getItemCount() = books.size

}