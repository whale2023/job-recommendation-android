package kgb.plum.domain.model

data class LoginToken (
    var atk: String = "none",
    var rtk: String = "none",
    var code: Int = 0)