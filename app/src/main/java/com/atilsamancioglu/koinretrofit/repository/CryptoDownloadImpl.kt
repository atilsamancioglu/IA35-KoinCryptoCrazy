package com.atilsamancioglu.koinretrofit.repository

import com.atilsamancioglu.koinretrofit.model.CryptoModel
import com.atilsamancioglu.koinretrofit.service.CryptoAPI
import com.atilsamancioglu.koinretrofit.util.Resource
import kotlinx.coroutines.*
import javax.inject.Inject

class CryptoDownloadImpl @Inject constructor(
     val api : CryptoAPI) : CryptoDownload {

    override suspend fun downloadCryptos() : Resource<List<CryptoModel>> {

        return try {
            val response = api.getData()
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