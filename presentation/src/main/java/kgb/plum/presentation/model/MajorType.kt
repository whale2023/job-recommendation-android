package kgb.plum.presentation.model

enum class MajorType {
  NEWEST {
    override fun toString(): String = "최신순"
  };

  companion object {
    fun fromString(string: String): MajorType? =
      MajorType.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}