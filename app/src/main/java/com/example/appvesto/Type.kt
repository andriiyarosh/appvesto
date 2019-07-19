package com.example.appvesto

enum class Type {
    FIREBASE, APPLE;
    fun toInt() = this.ordinal
}