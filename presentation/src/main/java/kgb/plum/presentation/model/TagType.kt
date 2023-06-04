package kgb.plum.presentation.model

enum class TagType {
  NEWEST {
    override fun toString(): String = "최신순"
  };

  companion object {
    fun fromString(string: String): TagType = when (string) {
      "최신순" -> NEWEST
      else -> NEWEST
    }
  }

  abstract override fun toString(): String
}