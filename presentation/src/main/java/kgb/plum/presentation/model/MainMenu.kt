package kgb.plum.presentation.model

import androidx.annotation.DrawableRes
import kgb.plum.presentation.R

sealed class MainMenu(val name: String, @DrawableRes val res: Int) {
    object Home: MainMenu(name = "home", res = R.drawable.home)
    object Domain: MainMenu(name = "domain", res = R.drawable.domain)
    object Recommend: MainMenu(name = "recommend", res = R.drawable.thumb_up)
    object WishList: MainMenu(name = "wishList", res = R.drawable.clober)
    object MyPage: MainMenu(name = "myPage", res = R.drawable.person)
}