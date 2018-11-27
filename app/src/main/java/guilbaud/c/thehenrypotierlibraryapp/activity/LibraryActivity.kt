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
    private var fragmentBookList: FragmentBookList = FragmentBookList()
    private var fragmentBookDetail: FragmentBookDetail = FragmentBookDetail()
    var landscape : Boolean = false
    private lateinit var layout1 : FrameLayout
    private lateinit var layout2 : FrameLayout

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

        // Global variable initialisation
        landscape = resources.getBoolean(R.bool.landscape)
        layout1 = findViewById(R.id.containerFrameLayout1)
        layout2 = findViewById(R.id.containerFrameLayout2)

        // Setting fragment in view in first containerFrameLayout1
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerFrameLayout1, fragmentBookList)
            .commit()
        layout2.visibility = View.GONE

        if(landscape) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout2, fragmentBookDetail)
                .commit()
            layout2.visibility = View.VISIBLE
        }

    }

    /**
     * Called on book list item in first fragment
     * Updates the view and displays the selected book details
     */
    override fun onClick() {

        if(!landscape) {
            layout1.visibility = View.GONE
            layout2.visibility = View.VISIBLE
        } else {
            layout1.visibility = View.VISIBLE
            layout2.visibility = View.VISIBLE
        }

        // Detail view update
        supportFragmentManager.beginTransaction()
            .addToBackStack(FragmentBookDetail::class.java.name) // For phone return button
            .replace(R.id.containerFrameLayout2, fragmentBookDetail)
            .commit()

    }

    /**
     * Back button management
     */
    override fun onBackPressed() {

        // If orientation is portrait and book detail view is visible
        if(!landscape && layout2.visibility == View.VISIBLE) {
            // Hide BookView and show only List
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout1, fragmentBookList)
                .commit()
            layout1.visibility = View.VISIBLE
            layout2.visibility = View.GONE

        } else {
            // Normal behaviour
            super.onBackPressed()
        }
    }

}
