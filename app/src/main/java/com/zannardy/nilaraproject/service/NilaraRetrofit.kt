package com.zannardy.nilaraproject.service

import com.zannardy.nilaraproject.model.NilaraConfig
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

interface NilaraRetrofit {

    @POST("d593c618-8525-5ba1-9a72-3510ce120634-7466/51ef7e62-aa2f-54b3-856f-f2874ebb4488-9750")
    suspend fun initCall(@Body config: NilaraConfig): ResponseBody
}