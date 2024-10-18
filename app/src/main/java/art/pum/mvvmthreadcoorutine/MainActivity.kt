package art.pum.mvvmthreadcoorutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import art.pum.mvvmthreadcoorutine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var myViewModel: MyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //tak
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //albo tak:
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]

        binding.viewModel = myViewModel
        binding.lifecycleOwner = this
    }
}