package art.pum.mvvmthreadcoorutine

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MyViewModel : ViewModel() {

    private var _zmiennaC: MutableLiveData<Int> = MutableLiveData<Int>()
    val zmiennaC: LiveData<Int>
        get() = _zmiennaC

    private var _zmiennaT = MutableLiveData<Int>()
    val zmiennaT: LiveData<Int>
        get() = _zmiennaT

   init {
        _zmiennaC.value = 0
        _zmiennaT.value = 0
    }

    fun goC() {
        Log.i("C1", "jest")
        _zmiennaC.value = 10
        viewModelScope.launch {
            repeat(100) {
                _zmiennaC.value = _zmiennaC.value?.inc()
                delay(500)
            }
        }
    }

    fun goT() {
        Log.i("T1", "jest")
        object : Thread() {
            override fun run() {
                repeat(100) {
                    _zmiennaT.postValue(_zmiennaT.value?.inc())
                    sleep(500)
                }
            }
        }.start()
    }

}