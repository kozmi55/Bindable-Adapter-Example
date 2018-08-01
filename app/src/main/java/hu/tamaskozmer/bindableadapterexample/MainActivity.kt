package hu.tamaskozmer.bindableadapterexample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hu.tamaskozmer.bindableadapterexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel = UserViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adapter = UserAdapter()
        recyclerView.adapter = adapter

        binding.viewModel = viewModel

        viewModel.startUpdates()
    }

    override fun onDestroy() {
        viewModel.stopUpdates()
        super.onDestroy()
    }
}
