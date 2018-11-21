package guilbaud.c.thehenrypotierlibraryapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import guilbaud.c.thehenrypotierlibraryapp.R

class FragmentBookList : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_booklist, container, false)

        return view
    }

}
