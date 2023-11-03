package com.atilsamancioglu.koinretrofit.domain.repository

import com.atilsamancioglu.koinretrofit.domain.model.CryptoModel
import com.atilsamancioglu.koinretrofit.util.Resource
import retrofit2.Response

interface CryptoDownload {
    suspend fun downloadCryptos() : Response<List<CryptoModel>>
}