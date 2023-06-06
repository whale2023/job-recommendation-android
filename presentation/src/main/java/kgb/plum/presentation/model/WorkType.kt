package kgb.plum.presentation.model

enum class WorkType {
  NEWEST {
    override fun toString(): String = "최신순"
  };

  companion object {
    fun fromString(string: String): WorkType? =
      WorkType.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}