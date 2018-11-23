package guilbaud.c.thehenrypotierlibraryapp.view.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import guilbaud.c.thehenrypotierlibraryapp.model.Book
import guilbaud.c.thehenrypotierlibraryapp.service.BookService
import timber.log.Timber

/**
 * Shared view model enabling book access and model updates
 * @author Chloe GUILBAUD
 */
class BookViewModel : ViewModel() {

    private lateinit var books: MutableLiveData<Array<Book>>

    val selected = MutableLiveData<Book>()

    /**
     * Gets books from API
     */
    fun getBooks(): LiveData<Array<Book>> {
        if (!::books.isInitialized) {
            books = MutableLiveData()
            loadBooks()
        }
        return books
    }

    /**
     * Requests the book API and receives the list
     */
    private fun loadBooks() {
        BookService.fetchBooks { bookList : Array<Book> -> updateData(bookList) }
    }

    /**
     * Updating the model view content
     */
    fun updateData(bookList : Array<Book>) {
        books.value = bookList
    }

    fun select(book: Book) {
        Timber.plant(Timber.DebugTree())
        Timber.i("Voew model not set " + selected.value)
        selected.value = book
        Timber.i("Voew model setted " + selected.value)
    }

}
