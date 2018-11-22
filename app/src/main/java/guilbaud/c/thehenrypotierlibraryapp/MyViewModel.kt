package guilbaud.c.thehenrypotierlibraryapp

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import guilbaud.c.thehenrypotierlibraryapp.model.Book
import guilbaud.c.thehenrypotierlibraryapp.service.BookService
import timber.log.Timber

class MyViewModel : ViewModel() {

    private lateinit var books: MutableLiveData<Array<Book>>

    val selected = MutableLiveData<Book>()

    fun getBooks(): LiveData<Array<Book>> {
        if (!::books.isInitialized) {
            books = MutableLiveData()
            loadBooks()
        }
        return books
    }

    private fun loadBooks() {
        BookService.fetchBooks { bookList : Array<Book> -> updateData(bookList) }
    }

    fun updateData(bookList : Array<Book>) {
        books.value = bookList
    }

    fun select(book: Book) {
        Timber.plant(Timber.DebugTree())
        Timber.i("Voew model not set " + selected.value)
        selected.value = book
        Timber.i("Voew model setted " + selected.value)
    }

    fun getBookList(): LiveData<Array<Book>> {
        return books
    }

}
