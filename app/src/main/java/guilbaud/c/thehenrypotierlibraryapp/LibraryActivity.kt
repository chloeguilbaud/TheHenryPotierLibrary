package guilbaud.c.thehenrypotierlibraryapp

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import guilbaud.c.thehenrypotierlibraryapp.fragment.FragmentBookDetail
import guilbaud.c.thehenrypotierlibraryapp.fragment.FragmentBookList
import guilbaud.c.thehenrypotierlibraryapp.model.BookService


class LibraryActivity : AppCompatActivity() {

    @VisibleForTesting
    lateinit var bookService: BookService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        bookService = BookService()

        val landscape = resources.getBoolean(R.bool.landscape)

        // TODO replace Step0Fragment in containerFrameLayout
        // Le fragment est placer dans l'élément containerFrameLayout de la vue
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

        bookService.fetchBooks();

    }

}
