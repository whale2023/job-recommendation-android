package kgb.plum.domain.model.state

sealed class UserState {
    object Loading : UserState()
    object Main : UserState()
    object Fail : UserState()
}