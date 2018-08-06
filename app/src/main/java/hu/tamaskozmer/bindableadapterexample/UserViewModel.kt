package hu.tamaskozmer.bindableadapterexample

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Handler
import java.util.*

class UserViewModel : BaseObservable() {

    @get:Bindable
    var userIds: MutableList<Long> = mutableListOf()
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
        val pos = random.nextInt(10)
        userIds[pos] = random.nextLong()
        notifyPropertyChanged(BR.userIds)
    }

    fun startUpdates() {
        initList()
        updateHandler.postDelayed(updateRunnable, updateInterval)
    }

    private fun initList() {
        userIds = MutableList(10) {
            random.nextLong()
        }
    }

    fun stopUpdates() {
        updateHandler.removeCallbacks(updateRunnable)
    }
}