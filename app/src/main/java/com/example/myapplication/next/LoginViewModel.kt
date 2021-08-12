package com.example.myapplication.next

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    private val _cpf = MutableLiveData<String>()
    val cpf: LiveData<String>
        get() = _cpf

    private var _password = MutableLiveData<String?>()
    val password: LiveData<String?>
        get() = _password

    private val _result = MutableLiveData<String>()
    val result: LiveData<String>
        get() = _result



    init {
        _cpf.value = ""
        _password.value = ""
    }

    /** Methods for updating the UI **/
    fun onLogin() {
        setTextResult()
        _password.value = ""
        _cpf.value = ""

    }
    private fun setTextResult(){
        _result.value = _cpf.value.plus(" ===== ").plus(_password.value)
    }


    fun setTextPassword(s: Editable){
        _password.value = s.toString()
    }

    fun setTextCpf(s: Editable){
        _cpf.value = s.toString()
    }
}