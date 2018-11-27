package guilbaud.c.thehenrypotierlibraryapp.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import guilbaud.c.thehenrypotierlibraryapp.R
import guilbaud.c.thehenrypotierlibraryapp.fragment.FragmentBookDetail
import guilbaud.c.thehenrypotierlibraryapp.fragment.FragmentBookList
import guilbaud.c.thehenrypotierlibraryapp.view.model.BookViewModel

/**
 * Library main activity
 * @author Chloe GUILBAUD
 */
class LibraryActivity : AppCompatActivity(), FragmentBookList.OnBookItemClickListener {

    // View fragments
    var fragmentBookList: FragmentBookList = FragmentBookList()
    var fragmentBookDetail: FragmentBookDetail = FragmentBookDetail()
    var landscape : Boolean = false

    // Shared view model
    private var model: BookViewModel =
        BookViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        // View model initialisation
        this.let {
            model = ViewModelProviders.of(it).get(BookViewModel::class.java)
        }

        // Activity initialisation
        initLandscapeMode()

    }

    private fun initLandscapeMode() {

        landscape = resources.getBoolean(R.bool.landscape)

        // Setting fragment in view in first containerFrameLayout1
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerFrameLayout1, fragmentBookList)
            .commit()
        findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.GONE

        if(landscape) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout2, fragmentBookDetail)
                .commit()
            findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.VISIBLE
        }

    }

    /**
     * Called on book list item in first fragment
     * Updates the view and displays the selected book details
     */
    override fun onClick() {

        if(!landscape) {
            findViewById<FrameLayout>(R.id.containerFrameLayout1).visibility = View.GONE
            findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.VISIBLE
        } else {
            findViewById<FrameLayout>(R.id.containerFrameLayout1).visibility = View.VISIBLE
            findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.VISIBLE
        }

        // Detail view update
        supportFragmentManager.beginTransaction()
            .addToBackStack(FragmentBookDetail::class.java.name) // For phone return button
            .replace(R.id.containerFrameLayout2, fragmentBookDetail)
            .commit()

    }

    override fun onBackPressed() {
        // Getting BookView (right part)
        var element: FrameLayout = findViewById(R.id.containerFrameLayout2)
        // If orientation is portrait and bookview is visible
        if(!resources.getBoolean(R.bool.landscape) &&
            element.visibility == View.VISIBLE) {
            // Hide BookView and show only List
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout1, fragmentBookList)
                .commit()
            findViewById<FrameLayout>(R.id.containerFrameLayout1).visibility = View.VISIBLE
            findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.GONE

        } else {
            // Else normal behaviour
            super.onBackPressed()
        }
    }

    fun displayBookList() {

    }

}
