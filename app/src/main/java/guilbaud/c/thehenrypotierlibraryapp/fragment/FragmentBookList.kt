package guilbaud.c.thehenrypotierlibraryapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import guilbaud.c.thehenrypotierlibraryapp.MyAdapter
import guilbaud.c.thehenrypotierlibraryapp.R

class FragmentBookList : Fragment() {

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_booklist, container, false)

        viewManager = LinearLayoutManager(activity)
        viewAdapter = MyAdapter(prenoms)

        recyclerView = view.findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

        return view
    }

}
