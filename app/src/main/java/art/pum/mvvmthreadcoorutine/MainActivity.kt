package art.pum.mvvmthreadcoorutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import art.pum.mvvmthreadcoorutine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var myViewModel: MyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]

        binding.viewModel = myViewModel
        binding.lifecycleOwner = this
    }
}