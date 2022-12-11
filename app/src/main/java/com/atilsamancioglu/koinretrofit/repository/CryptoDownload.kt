package com.atilsamancioglu.koinretrofit.repository

import com.atilsamancioglu.koinretrofit.model.CryptoModel
import com.atilsamancioglu.koinretrofit.util.Resource

interface CryptoDownload {
    suspend fun downloadCryptos() : Resource<List<CryptoModel>>
}