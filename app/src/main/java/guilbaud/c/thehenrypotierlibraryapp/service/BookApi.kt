package guilbaud.c.thehenrypotierlibraryapp.service

import guilbaud.c.thehenrypotierlibraryapp.model.Book
import retrofit2.Call
import retrofit2.http.GET

/**
 * Book API model.
 * @author Chloe GUILBAUD
 */
interface BookApi {

    @GET("books")
    fun listBooks() : Call<Array<Book>>

}
