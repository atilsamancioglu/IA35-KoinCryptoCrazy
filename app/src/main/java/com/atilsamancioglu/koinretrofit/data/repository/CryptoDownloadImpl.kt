package com.atilsamancioglu.koinretrofit.data.repository

import com.atilsamancioglu.koinretrofit.domain.model.CryptoModel
import com.atilsamancioglu.koinretrofit.data.service.CryptoAPI
import com.atilsamancioglu.koinretrofit.domain.repository.CryptoDownload
import com.atilsamancioglu.koinretrofit.domain.use_case.download_cryptos.DownloadCryptosUseCase
import com.atilsamancioglu.koinretrofit.util.Resource
import retrofit2.Response
import javax.inject.Inject

class CryptoDownloadImpl @Inject constructor(
     val downloadCryptosUseCase: DownloadCryptosUseCase
) : CryptoDownload {

    override suspend fun downloadCryptos() : Resource<List<CryptoModel>> {
        return downloadCryptosUseCase.executeDownloadCryptos()
    }
}