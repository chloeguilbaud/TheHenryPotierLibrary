package guilbaud.c.thehenrypotierlibraryapp

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.FrameLayout
import android.widget.ListView
import guilbaud.c.thehenrypotierlibraryapp.fragment.FragmentBookDetail
import guilbaud.c.thehenrypotierlibraryapp.fragment.FragmentBookList
import guilbaud.c.thehenrypotierlibraryapp.model.Book
import guilbaud.c.thehenrypotierlibraryapp.model.BookService
import timber.log.Timber
import android.widget.ArrayAdapter




class LibraryActivity : AppCompatActivity() {

    @VisibleForTesting
    lateinit var bookService: BookService

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val prenoms = arrayOf(
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

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        // Activity initialisation
        init()
        initLandscapeMode()

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(prenoms)

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

    }

    private fun init() {
        bookService = BookService()
        bookService.fetchBooks(this)
    }

    fun onBookServiceSuccess(books : Array<Book>) {
        books.forEach {
            Timber.i("Book onBookServiceSuccess ! : %s", it.toString())
        }
    }

    private fun initLandscapeMode() {

        val landscape = resources.getBoolean(R.bool.landscape)

        // Setting fragment in view in first containerFrameLayout1
        /*supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerFrameLayout1, FragmentBookList())
            .commit()
        findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.INVISIBLE

        if(landscape) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout2, FragmentBookDetail())
                .commit()
            findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.VISIBLE
        }*/

    }
}
