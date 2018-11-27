package guilbaud.c.thehenrypotierlibraryapp.service

import guilbaud.c.thehenrypotierlibraryapp.model.Book
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

    companion object {

        /**
         * Fetches books and returns the list from http://henri-potier.xebia.fr/
         */
        fun fetchBooks(callback: (Array<Book>) -> Unit){

            // Plant Timber logger
            Timber.plant(Timber.DebugTree())

            // Build Retrofit
            val retrofit = Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            // Create a service
            val api = retrofit.create(BookApi::class.java)

            Timber.i("Book service : Getting book list...")

            // Calling book API
            api.listBooks().enqueue(object : Callback<Array<Book>> {

                override fun onResponse(call: Call<Array<Book>>?, response: Response<Array<Book>>?) {
                    callback(response!!.body()!!)
                }

                override fun onFailure(call: Call<Array<Book>>?, t: Throwable?) {
                    Timber.e("FAILLURE \n%s\ncall: %s", t.toString(), call)
                }

            })

        }
    }
}