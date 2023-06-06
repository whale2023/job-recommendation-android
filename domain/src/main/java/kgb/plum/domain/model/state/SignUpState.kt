package kgb.plum.domain.model.state

sealed class SignUpState {
    object Loading: SignUpState()
    object None: SignUpState()
    class Main(
        val code: Int
    ): SignUpState()
    class Failed(
        val reason: String
    ): SignUpState()
}