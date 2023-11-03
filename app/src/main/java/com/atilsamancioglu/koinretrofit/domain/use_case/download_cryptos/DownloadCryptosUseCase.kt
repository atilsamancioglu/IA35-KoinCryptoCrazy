package com.atilsamancioglu.koinretrofit.domain.use_case.download_cryptos

import com.atilsamancioglu.koinretrofit.domain.model.CryptoModel
import com.atilsamancioglu.koinretrofit.domain.repository.CryptoDownload
import com.atilsamancioglu.koinretrofit.util.Resource
import javax.inject.Inject

class DownloadCryptosUseCase @Inject constructor(private val repository: CryptoDownload) {

    //Use case -> only one major public function, one feature, single responsibility
    suspend fun executeDownloadCryptos() : Resource<List<CryptoModel>> {
        val response = repository.downloadCryptos()
        return try {
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error",null)
            } else {
                Resource.error("Error",null)
            }
        } catch (e: Exception) {
            Resource.error("No data!",null)
        }
    }

}