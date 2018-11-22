package guilbaud.c.thehenrypotierlibraryapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import guilbaud.c.thehenrypotierlibraryapp.R
import guilbaud.c.thehenrypotierlibraryapp.model.Book

class BookAdapter(private val books: Array<Book>) : RecyclerView.Adapter<BookAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        // Creating list item view
        val view : View =  LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_booklist_item, parent, false)

        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.view.findViewById<TextView>(R.id.book_title).text = books[position].title
        holder.view.findViewById<TextView>(R.id.book_price).text = books[position].price
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = books.size
}