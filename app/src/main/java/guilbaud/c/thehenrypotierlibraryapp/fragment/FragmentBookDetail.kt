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
import timber.log.Timber

class FragmentBookDetail : Fragment() {

    private lateinit var model: MyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_bookdetails, container, false)

        Timber.plant(Timber.DebugTree())
        Timber.i("FRAG 2")

        /*model = activity?.run {
            ViewModelProviders.of(this).get(MyViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        Timber.i("FRAG 2 MAIN slected " + model.selected.value)
        model.selected.observe(this, Observer<Book> { book ->
            Timber.i("FRAG 2 SELECTED MODIF")
            // Update the UI
            view!!.findViewById<TextView>(R.id.book_title).text = book!!.title
            view.findViewById<TextView>(R.id.book_price).text = book.price
            view.findViewById<TextView>(R.id.book_synopsis).text = book.synopsis[0]
        })*/
        //model = ViewModelProviders.of(parentFragment!!).get(MyViewModel::class.java)

        activity?.let {
            model = ViewModelProviders.of(it).get(MyViewModel::class.java)
            model.selected.observe(this, Observer {
                it?.let { book ->
                    Timber.i("FRAG ref model " + book.title)
                    view!!.findViewById<TextView>(R.id.book_title).text = book!!.title
                    view.findViewById<TextView>(R.id.book_price).text = book.price
                    view.findViewById<TextView>(R.id.book_synopsis).text = book.synopsis[0]
                }
            })
        }

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