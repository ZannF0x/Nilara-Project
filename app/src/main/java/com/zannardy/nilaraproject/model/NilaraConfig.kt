package com.zannardy.nilaraproject.model

import com.google.gson.annotations.SerializedName

data class NilaraConfig(
    @SerializedName("device_id")
    val deviceId: Int = 202,
    @SerializedName("src")
    val src: String = "83994069703",
    @SerializedName("dst")
    val dst: String = "83991218491"
)