package kgb.plum.presentation.model

enum class SortType {
  NEWEST {
    override fun toString(): String = "최신순"
  };

  companion object {
    fun fromString(string: String): SortType = when (string) {
      "최신순" -> NEWEST
      else -> NEWEST
    }
  }

  abstract override fun toString(): String
}