package kgb.plum.domain.model.state

enum class LoginState {
    ID_PW_EMPTY { override fun state() : String = "아이디 혹은 비밀번호를 채워주세요." },
    NOT_EMAIL{ override fun state() : String = "아이디 양식이 잘못되었습니다." },
    SUCCESS{ override fun state() : String = "로그인 성공" },
    WRONG_PW_ID{ override fun state() : String = "아이디 혹은 비밀번호가 옳지 않습니다." };

    abstract fun state() : String
}