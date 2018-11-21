package guilbaud.c.thehenrypotierlibraryapp.model

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
