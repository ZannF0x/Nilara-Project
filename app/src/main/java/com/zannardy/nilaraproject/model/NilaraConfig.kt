package com.zannardy.nilaraproject.model

import com.google.gson.annotations.SerializedName

data class NilaraConfig(
    @SerializedName("device_id")
    val deviceId: String,
    @SerializedName("src")
    val src: String,
    @SerializedName("dst")
    val dst: String
)