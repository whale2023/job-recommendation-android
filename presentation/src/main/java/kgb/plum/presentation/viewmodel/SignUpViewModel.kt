package kgb.plum.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.usecase.SignUpUseCase
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val signUpUseCase: SignUpUseCase): ViewModel() {
    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email

    private val _certificationNumber = MutableLiveData("")
    val certificationNumber : LiveData<String> = _certificationNumber

    private val _pw = MutableLiveData("")
    val pw: LiveData<String> = _pw

    private val _pwCheck = MutableLiveData("")
    val pwCheck : LiveData<String>  = _pwCheck

    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _age = MutableLiveData("")
    val age: LiveData<String> = _age

    private val _addressInfo = MutableLiveData("")
    val addressInfo: LiveData<String> = _addressInfo

    private val _addressDetail = MutableLiveData("")
    val addressDetail: LiveData<String> = _addressDetail

    private val _disabilityType = MutableLiveData("")
    val disabilityType: LiveData<String> = _disabilityType

    private val _disabilityLevel = MutableLiveData("")
    val disabilityLevel: LiveData<String> = _disabilityLevel

    fun setEmail(text : String){
        _email.value = text
    }

    fun setName(text : String){
        _name.value = text
    }

    fun setAge(text: String) {
        _age.value = text
    }

    fun setCertificationNumber(text: String) {
        _certificationNumber.value = text
    }

    fun setPw(text: String) {
        _pw.value = text
    }

    fun setPwCheck(text: String) {
        _pwCheck.value = text
    }

    fun setDisabilityType(text: String) {
        _disabilityType.value = text
    }

    fun setDisabilityLevel(text: String) {
        _disabilityLevel.value = text
    }

    fun setAddressInfo(text: String) {
        _addressInfo.value = text
    }

    fun setAddressDetail(text: String) {
        _addressDetail.value = text
    }

    fun checkUserInfoValid() : Boolean {
        return (_name.value.isNullOrEmpty() || _age.value.isNullOrEmpty() || _addressInfo.value.isNullOrEmpty() || _addressDetail.value.isNullOrEmpty()).not()
    }

    fun emailValid() : Boolean {
        return signUpUseCase.checkEmailFormat(_email.value?:"") && _email.value.isNullOrEmpty().not()
    }

    fun certificationNumberValid() : Boolean {
        return _certificationNumber.value.isNullOrEmpty().not()
    }

    fun checkEmailFormat() : String {
        return if(signUpUseCase.checkEmailFormat(_email.value?:"")) "" else "이메일 양식이 잘못되었습니다."
    }

    fun requestCertificationNumber() {
        signUpUseCase.requestCertificationNumber(_email.value?: "")
    }
}