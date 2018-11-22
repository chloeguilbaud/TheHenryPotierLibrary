package guilbaud.c.thehenrypotierlibraryapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import guilbaud.c.thehenrypotierlibraryapp.fragment.FragmentBookDetail
import guilbaud.c.thehenrypotierlibraryapp.fragment.FragmentBookList

class LibraryActivity : AppCompatActivity(), FragmentBookList.OnBookItemClickListener {

    var fragmentBookList: FragmentBookList = FragmentBookList()
    var fragmentBookDetail: FragmentBookDetail = FragmentBookDetail()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

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

    override fun onClick() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(FragmentBookDetail::class.java.name) // Ajout a backtake qui permet retour fragment d'avant a appuis sur bouton retour
            .replace(R.id.containerFrameLayout1, FragmentBookDetail())
            .commit()
    }

}
