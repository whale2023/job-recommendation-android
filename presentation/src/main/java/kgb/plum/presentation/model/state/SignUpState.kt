package kgb.plum.presentation.model.state

sealed class SignUpState {
    object Loading: SignUpState()
    object Main: SignUpState()
    class Failed(
        val reason: String
    ): SignUpState()
}