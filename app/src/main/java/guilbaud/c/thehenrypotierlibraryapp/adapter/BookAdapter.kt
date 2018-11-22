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
class BookAdapter(private val books: Array<Book>) : RecyclerView.Adapter<BookAdapter.MyViewHolder>() {

    // Reference to view for each data item
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    lateinit var viewGroup : ViewGroup

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        this.viewGroup = parent

        // Creating list item view
        val view : View =  LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_booklist_item, parent, false)

        return MyViewHolder(view)
    }


    /**
     * Replace view content for list item
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val imageView = holder.view.findViewById<ImageView>(R.id.book_cover)
        Glide
            .with(viewGroup)
            .load(books[position].cover)
            .into(imageView);
        holder.view.findViewById<TextView>(R.id.book_title).text = books[position].title
        holder.view.findViewById<TextView>(R.id.book_price).text = books[position].price
    }

    // Return book list size
    override fun getItemCount() = books.size

}