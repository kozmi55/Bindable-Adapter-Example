package hu.tamaskozmer.bindableadapterexample

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Handler
import java.util.*

class UserViewModel : BaseObservable() {

    @get:Bindable
    var userIds: List<Long> = emptyList()
        private set(value) {
            field = value
            notifyPropertyChanged(BR.userIds)
        }

    private val updateInterval = 1000L
    private val updateHandler = Handler()
    private val random = Random()

    private var updateRunnable: Runnable = object : Runnable {
        override fun run() {
            updateList()
            updateHandler.postDelayed(this, updateInterval)
        }
    }

    private fun updateList() {
        userIds = List(30) {
            random.nextLong()
        }
    }

    fun startUpdates() {
        updateHandler.postDelayed(updateRunnable, updateInterval)
    }

    fun stopUpdates() {
        updateHandler.removeCallbacks(updateRunnable)
    }
}