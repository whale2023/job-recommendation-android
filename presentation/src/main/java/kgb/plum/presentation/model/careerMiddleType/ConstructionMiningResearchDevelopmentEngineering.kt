package kgb.plum.presentation.model.careerMiddleType

enum class ConstructionMiningResearchDevelopmentEngineering : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  };

  companion object {
    fun fromString(string: String): ConstructionMiningResearchDevelopmentEngineering? =
      ConstructionMiningResearchDevelopmentEngineering.values().find { it.toString() == string }
  }

  override fun toString(): String = when (this) {
    ETC -> "해당 없음"
  }
}
