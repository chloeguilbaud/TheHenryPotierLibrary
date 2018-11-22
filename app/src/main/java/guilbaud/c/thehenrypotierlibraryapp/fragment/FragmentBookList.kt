package guilbaud.c.thehenrypotierlibraryapp.fragment

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import guilbaud.c.thehenrypotierlibraryapp.adapter.BookAdapter
import guilbaud.c.thehenrypotierlibraryapp.R
import guilbaud.c.thehenrypotierlibraryapp.model.Book
import guilbaud.c.thehenrypotierlibraryapp.model.BookService
import timber.log.Timber

class FragmentBookList : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    @VisibleForTesting
    lateinit var bookService: BookService

    private val prenoms = arrayOf(
        "Bobi",
        "Chloe",
        "KK",
        "Antoine",
        "Benoit",
        "Cyril",
        "David",
        "Eloise",
        "Florent",
        "Gerard",
        "Hugo",
        "Ingrid",
        "Jonathan",
        "Kevin",
        "Logan",
        "Mathieu",
        "Noemie",
        "Olivia",
        "Philippe",
        "Quentin",
        "Romain",
        "Sophie",
        "Tristan",
        "Ulric",
        "Vincent",
        "Willy",
        "Xavier",
        "Yann",
        "Zoé"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_booklist, container, false)
        init()
        return view
    }

    private fun init() {
        bookService = BookService()
        bookService.fetchBooks(this)
    }

    fun onBookServiceSuccess(books : Array<Book>) {
        books.forEach {
            Timber.i("Book onBookServiceSuccess ! : %s", it.toString())
        }

        viewManager = GridLayoutManager(activity, 2)
        //viewManager = LinearLayoutManager(activity)
        viewAdapter = BookAdapter(books)

        recyclerView = view!!.findViewById<RecyclerView>(R.id.fragment_book_list_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

    }


}
