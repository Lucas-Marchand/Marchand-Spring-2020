package com.google.firebase.quickstart.auth.kotlin

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(
        var username: String? = "",
        var email: String? = "",
        var friend: ArrayList<String> = ArrayList<String>()
)