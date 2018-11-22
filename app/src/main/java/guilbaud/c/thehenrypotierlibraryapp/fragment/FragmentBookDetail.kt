package guilbaud.c.thehenrypotierlibraryapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import guilbaud.c.thehenrypotierlibraryapp.R
import guilbaud.c.thehenrypotierlibraryapp.model.Book

class FragmentBookDetail : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bookdetails, container, false)
    }

    fun updateView(book : Book) {
        /*val imageView = view!!.findViewById<ImageView>(R.id.book_cover)
        Glide
            .with(view!!)
            .load(book.cover)
            .into(imageView);*/
        view!!.findViewById<TextView>(R.id.book_title).text = book.title
        view!!.findViewById<TextView>(R.id.book_price).text = book.price
        view!!.findViewById<TextView>(R.id.book_synopsis).text = book.synopsis[0]
    }

}