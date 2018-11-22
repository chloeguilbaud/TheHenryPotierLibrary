package guilbaud.c.thehenrypotierlibraryapp.fragment

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import guilbaud.c.thehenrypotierlibraryapp.adapter.BookAdapter
import guilbaud.c.thehenrypotierlibraryapp.R
import guilbaud.c.thehenrypotierlibraryapp.model.Book
import guilbaud.c.thehenrypotierlibraryapp.service.BookService

/**
 * Fragment enabling book list display
 * @author Chloe GUILBAUD
 */
class FragmentBookList : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    @VisibleForTesting
    lateinit var bookService: BookService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_booklist, container, false)
        init()
        return view
    }

    /**
     * Book service initialisation
     */
    private fun init() {
        bookService = BookService()
        bookService.fetchBooks(this)
    }

    /**
     * Called on book service success request
     */
    fun onBookServiceSuccess(books : Array<Book>) {

        // Adapter and manager initialisation
        viewManager = GridLayoutManager(activity, 2)
        viewAdapter = BookAdapter(books)

        recyclerView = view!!.findViewById<RecyclerView>(R.id.fragment_book_list_view).apply {

            // Improving performance by fixing layout size for fix content
            setHasFixedSize(true)

            // Setting linear layout manager
            layoutManager = viewManager

            // Setting view adapter
            adapter = viewAdapter

        }

    }


}
