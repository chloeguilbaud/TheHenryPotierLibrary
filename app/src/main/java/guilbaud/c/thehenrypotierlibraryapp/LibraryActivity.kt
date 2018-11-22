package guilbaud.c.thehenrypotierlibraryapp

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import guilbaud.c.thehenrypotierlibraryapp.fragment.FragmentBookDetail
import guilbaud.c.thehenrypotierlibraryapp.fragment.FragmentBookList
import guilbaud.c.thehenrypotierlibraryapp.model.Book
import guilbaud.c.thehenrypotierlibraryapp.model.BookService
import timber.log.Timber


class LibraryActivity : AppCompatActivity() {

    @VisibleForTesting
    lateinit var bookService: BookService

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        // Activity initialisation
        init()
        initLandscapeMode()

    }

    private fun init() {
        bookService = BookService()
    }

    fun onBookServiceSuccess(books : Array<Book>) {
        books.forEach {
            Timber.i("Book onBookServiceSuccess ! : %s", it.toString())
        }
    }

    private fun initLandscapeMode() {

        val landscape = resources.getBoolean(R.bool.landscape)

        // Setting fragment in view in first containerFrameLayout1
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerFrameLayout1, FragmentBookList())
            .commit()
        findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.INVISIBLE

        if(landscape) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout2, FragmentBookDetail())
                .commit()
            findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.VISIBLE
        }

    }
}
