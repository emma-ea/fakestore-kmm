package com.emma_ea.fakestore

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}