package kgb.plum.presentation.model

enum class CertificationType {
  NEWEST {
    override fun toString(): String = "최신순"
  };

  companion object {
    fun fromString(string: String): CertificationType = when (string) {
      "최신순" -> NEWEST
      else -> NEWEST
    }
  }

  abstract override fun toString(): String
}