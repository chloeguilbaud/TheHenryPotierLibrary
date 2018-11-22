package guilbaud.c.thehenrypotierlibraryapp.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import guilbaud.c.thehenrypotierlibraryapp.MyViewModel
import guilbaud.c.thehenrypotierlibraryapp.R
import guilbaud.c.thehenrypotierlibraryapp.model.Book

class FragmentBookDetail : Fragment() {

    private lateinit var model: MyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_booklist, container, false)

        model = activity?.run {
            ViewModelProviders.of(this).get(MyViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        model.selected.observe(this, Observer<Book> { book ->
            // Update the UI
            view!!.findViewById<TextView>(R.id.book_title).text = book!!.title
            view.findViewById<TextView>(R.id.book_price).text = book.price
            view.findViewById<TextView>(R.id.book_synopsis).text = book.synopsis[0]
        })

        return view
    }



    fun updateView(book : Book) {



        /*val imageView = view!!.findViewById<ImageView>(R.id.book_cover)
        Glide
            .with(view!!)
            .load(book.cover)
            .into(imageView);*/

    }

}