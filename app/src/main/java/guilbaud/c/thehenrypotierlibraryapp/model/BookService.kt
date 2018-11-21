package guilbaud.c.thehenrypotierlibraryapp.model

import guilbaud.c.thehenrypotierlibraryapp.LibraryActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

/**
 * Book service in charge of the interaction with the online API
 * @author Chloe GUILBAUD
 */
class BookService {

    /**
     * Fetches books and returns the list from http://henri-potier.xebia.fr/
     */
    fun fetchBooks(act : LibraryActivity) : MutableList<Book> {

        var bookList : MutableList<Book> = mutableListOf()

        // Plant logger cf. Android Timber
        // Indique comment on va logger
        Timber.plant(Timber.DebugTree());

        // TODO build Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("http://henri-potier.xebia.fr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // TODO create a service
        val api = retrofit.create(BookApi::class.java)

        // TODO listBooks()

        Timber.i("BEFORE GETTING BOOKS")

        // TODO enqueue call and display book title
        api.listBooks().enqueue(object : Callback<Array<Book>> {

            override fun onResponse(call: Call<Array<Book>>?, response: Response<Array<Book>>?) {
                act.processBookLib(response!!.body()!!)
               /* response!!.body()!!.forEach {
                    // TODO log books
                    Timber.i("Book: %s", it.toString())
                    act.processBookLib(it)
                    // it : itérateur disponible dans l'itération
                }*/
                // !! : check not null
                //Timber.i(book.getTitle())
            }

            override fun onFailure(call: Call<Array<Book>>?, t: Throwable?) {
                Timber.e("FAILLURE \n%s\ncall: %s", t.toString(), call)
            }

        })

        return bookList
    }

}