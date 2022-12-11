package com.atilsamancioglu.koinretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atilsamancioglu.koinretrofit.model.CryptoModel
import com.atilsamancioglu.koinretrofit.repository.CryptoDownload
import com.atilsamancioglu.koinretrofit.service.CryptoAPI
import com.atilsamancioglu.koinretrofit.util.Resource
import com.atilsamancioglu.koinretrofit.view.RecyclerViewAdapter
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CryptoViewModel(
    private val cryptoDownloadRepository : CryptoDownload
) : ViewModel() {

    val cryptoList = MutableLiveData<Resource<List<CryptoModel>>>()
    val cryptoError = MutableLiveData<Resource<Boolean>>()
    val cryptoLoading = MutableLiveData<Resource<Boolean>>()
    private var job : Job? = null

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Error: ${throwable.localizedMessage}")
        cryptoError.value = Resource.error(throwable.localizedMessage ?: "error!",data = true)
    }




    fun getDataFromAPI() {
        cryptoLoading.value = Resource.loading(true)

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val resource = cryptoDownloadRepository.downloadCryptos()
            withContext(Dispatchers.Main) {
                resource.data?.let {
                    cryptoLoading.value = Resource.loading(false)
                    cryptoError.value = Resource.error("",data = false)
                    cryptoList.value = resource
                }
            }
        }

        /*
       val BASE_URL = "https://raw.githubusercontent.com/"

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoAPI::class.java)



        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = retrofit.getData()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    cryptoError.value = false
                    cryptoLoading.value = false
                    response.body()?.let {
                        cryptoList.value = it
                        }
                    }
                }
            }
        }

        */
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}



