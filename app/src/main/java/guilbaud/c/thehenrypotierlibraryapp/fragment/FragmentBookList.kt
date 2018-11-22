package guilbaud.c.thehenrypotierlibraryapp.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import guilbaud.c.thehenrypotierlibraryapp.MyViewModel
import guilbaud.c.thehenrypotierlibraryapp.adapter.BookAdapter
import guilbaud.c.thehenrypotierlibraryapp.R
import guilbaud.c.thehenrypotierlibraryapp.model.Book
import timber.log.Timber
import java.nio.channels.Selector

/**
 * Fragment enabling book list display
 * @author Chloe GUILBAUD
 */
class FragmentBookList : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var model: MyViewModel = MyViewModel()
    private lateinit var itemSelector: Selector

    private var listener: OnBookItemClickListener? = null

    /**
     * Gets
     */
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        when(context) {
            is OnBookItemClickListener -> listener = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_booklist, container, false)

        /* Called on Activity onCreate() */

        activity?.let {
            model = ViewModelProviders.of(it).get(MyViewModel::class.java)
            model.getBooks().observe(this, Observer {
                it?.let {books ->
                    // do some thing with the number
                    // Adapter and manager initialisation
                    viewManager = GridLayoutManager(activity, 2)
                    viewAdapter = BookAdapter(books!!) { book : Book -> bookItemClicked(book) }

                    recyclerView = view!!.findViewById<RecyclerView>(R.id.fragment_book_list_view).apply {

                        // Improving performance by fixing layout size for fix content
                        setHasFixedSize(true)

                        // Setting linear layout manager
                        layoutManager = viewManager

                        // Setting view adapter
                        adapter = viewAdapter

                    }
                }
            })
        }

        /*model = ViewModelProviders.of(this).get(MyViewModel::class.java)
        model.getBooks().observe(this, Observer<Array<Book>>{ books ->

            // Adapter and manager initialisation
            viewManager = GridLayoutManager(activity, 2)
            viewAdapter = BookAdapter(books!!) { book : Book -> bookItemClicked(book) }

            recyclerView = view!!.findViewById<RecyclerView>(R.id.fragment_book_list_view).apply {

                // Improving performance by fixing layout size for fix content
                setHasFixedSize(true)

                // Setting linear layout manager
                layoutManager = viewManager

                // Setting view adapter
                adapter = viewAdapter

            }

        })*/


        return view
    }

    /**
     * Book service initialisation
     */
    private fun init() {

    }

    /**
     * Called on book service success request
     */
    fun onBookServiceSuccess(books : Array<Book>) {



    }

    fun bookItemClicked(book : Book) {
        model.select(book)
        listener?.onClick()
    }

    interface OnBookItemClickListener {
        fun onClick()
    }


}
