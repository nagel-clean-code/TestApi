package com.example.testapi

import com.example.testapi.model.LoginStep1Model
import com.example.testapi.model.LoginStep2Model


interface RestRequest {
    fun loginPhoneStep1(numberPhone: String): LoginStep1Model
    fun confirmCode(numberPhone: String, code: String): LoginStep2Model
}