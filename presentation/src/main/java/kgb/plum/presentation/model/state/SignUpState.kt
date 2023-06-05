package kgb.plum.presentation.model.state

sealed class SignUpState {
    object Loading: SignUpState()
    class Main(
        val code: Int
    ): SignUpState()
    class Failed(
        val reason: String
    ): SignUpState()
}