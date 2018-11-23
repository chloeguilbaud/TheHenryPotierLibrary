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

        val landscape = resources.getBoolean(R.bool.landscape)

        // Setting fragment in view in first containerFrameLayout1
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerFrameLayout1, fragmentBookList)
            .commit()
        findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.INVISIBLE

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
        supportFragmentManager.beginTransaction()
            .addToBackStack(FragmentBookDetail::class.java.name) // For phone return button
            .replace(R.id.containerFrameLayout1, fragmentBookDetail)
            .commit()
    }

}
