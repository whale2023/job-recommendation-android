package kgb.plum.presentation.model

import kgb.plum.presentation.model.careerMiddleType.AgricultureForestryFishery
import kgb.plum.presentation.model.careerMiddleType.ArtDesignBroadcast
import kgb.plum.presentation.model.careerMiddleType.BeautyWeddingService
import kgb.plum.presentation.model.careerMiddleType.BusinessAdministrationClerical
import kgb.plum.presentation.model.careerMiddleType.CareServiceCaregivingChildcare
import kgb.plum.presentation.model.careerMiddleType.CareerMiddleType
import kgb.plum.presentation.model.careerMiddleType.ChemicalEnvironmentalInstallationMaintenanceProduction
import kgb.plum.presentation.model.careerMiddleType.CleaningAndOtherPersonalServices
import kgb.plum.presentation.model.careerMiddleType.ConstructionMining
import kgb.plum.presentation.model.careerMiddleType.ConstructionMiningResearchDevelopmentEngineering
import kgb.plum.presentation.model.careerMiddleType.DrivingTransportation
import kgb.plum.presentation.model.careerMiddleType.Education
import kgb.plum.presentation.model.careerMiddleType.ElectricalElectronicInstallationMaintenanceProduction
import kgb.plum.presentation.model.careerMiddleType.FinanceInsurance
import kgb.plum.presentation.model.careerMiddleType.FoodProcessingProduction
import kgb.plum.presentation.model.careerMiddleType.FoodService
import kgb.plum.presentation.model.careerMiddleType.HealthcareMedicalServices
import kgb.plum.presentation.model.careerMiddleType.HumanitiesSocialSciencesResearch
import kgb.plum.presentation.model.careerMiddleType.InformationCommunicationInstallationMaintenance
import kgb.plum.presentation.model.careerMiddleType.InformationCommunicationResearchDevelopmentEngineering
import kgb.plum.presentation.model.careerMiddleType.Legal
import kgb.plum.presentation.model.careerMiddleType.ManagementExecutiveDepartmentHead
import kgb.plum.presentation.model.careerMiddleType.ManufacturingResearchDevelopmentEngineering
import kgb.plum.presentation.model.careerMiddleType.ManufacturingUnskilled
import kgb.plum.presentation.model.careerMiddleType.MechanicalInstallationMaintenanceProduction
import kgb.plum.presentation.model.careerMiddleType.MetalMaterialInstallationMaintenanceProduction
import kgb.plum.presentation.model.careerMiddleType.NaturalLifeScienceResearch
import kgb.plum.presentation.model.careerMiddleType.PrintingWoodCraftAndOtherInstallationMaintenanceProduction
import kgb.plum.presentation.model.careerMiddleType.SalesAndRetail
import kgb.plum.presentation.model.careerMiddleType.SecurityGuard
import kgb.plum.presentation.model.careerMiddleType.SocialWelfareReligiousWork
import kgb.plum.presentation.model.careerMiddleType.SportsRecreation
import kgb.plum.presentation.model.careerMiddleType.TextileApparelProduction
import kgb.plum.presentation.model.careerMiddleType.TravelAccommodationEntertainmentServices

enum class CareerMajorType {
  BUSINESS_ADMINISTRATION_CLERICAL {
    override fun toString(): String = "경영_행정_사무직"
    override fun getMiddleType(): List<CareerMiddleType> = BusinessAdministrationClerical.values().toList()
  },
  DRIVING_TRANSPORTATION {
    override fun toString(): String = "운전_운송직"
    override fun getMiddleType(): List<CareerMiddleType> = DrivingTransportation.values().toList()
  },
  MECHANICAL_INSTALLATION_MAINTENANCE_PRODUCTION {
    override fun toString(): String = "기계_설치정비_생산직"
    override fun getMiddleType(): List<CareerMiddleType> = MechanicalInstallationMaintenanceProduction.values().toList()
  },
  METAL_MATERIAL_INSTALLATION_MAINTENANCE_PRODUCTION {
    override fun toString(): String = "금속_재료_설치_정비_생산직"
    override fun getMiddleType(): List<CareerMiddleType> = MetalMaterialInstallationMaintenanceProduction.values().toList()
  },
  CHEMICAL_ENVIRONMENTAL_INSTALLATION_MAINTENANCE_PRODUCTION {
    override fun toString(): String = "화학_환경_설치_정비_생산직"
    override fun getMiddleType(): List<CareerMiddleType> = ChemicalEnvironmentalInstallationMaintenanceProduction.values().toList()
  },
  ELECTRICAL_ELECTRONIC_INSTALLATION_MAINTENANCE_PRODUCTION {
    override fun toString(): String = "전기_전자_설치_정비_생산직"
    override fun getMiddleType(): List<CareerMiddleType> = ElectricalElectronicInstallationMaintenanceProduction.values().toList()
  },
  MANUFACTURING_RESEARCH_DEVELOPMENT_ENGINEERING {
    override fun getMiddleType(): List<CareerMiddleType> = ManufacturingResearchDevelopmentEngineering.values().toList()
    override fun toString(): String = "제조_연구개발직_및_공학기술직"
  },
  TEXTILE_APPAREL_PRODUCTION {
    override fun toString(): String = "섬유_의복_생산직"
    override fun getMiddleType(): List<CareerMiddleType> = TextileApparelProduction.values().toList()
  },
  MANUFACTURING_UNSKILLED {
    override fun toString(): String = "제조_단순직"
    override fun getMiddleType(): List<CareerMiddleType> = ManufacturingUnskilled.values().toList()
  },
  INFORMATION_COMMUNICATION_INSTALLATION_MAINTENANCE {
    override fun toString(): String = "정보통신_설치_정비직"
    override fun getMiddleType(): List<CareerMiddleType> = InformationCommunicationInstallationMaintenance.values().toList()
  },
  PRINTING_WOOD_CRAFT_AND_OTHER_INSTALLATION_MAINTENANCE_PRODUCTION {
    override fun toString(): String = "인쇄_목재_공예_및_기타_설치_정비_생산직"
    override fun getMiddleType(): List<CareerMiddleType> = PrintingWoodCraftAndOtherInstallationMaintenanceProduction.values().toList()
  },
  FOOD_PROCESSING_PRODUCTION {
    override fun toString(): String = "식품_가공_생산직"
    override fun getMiddleType(): List<CareerMiddleType> = FoodProcessingProduction.values().toList()
  },
  EDUCATION {
    override fun toString(): String = "교육직"
    override fun getMiddleType(): List<CareerMiddleType> = Education.values().toList()
  },
  FINANCE_INSURANCE {
    override fun toString(): String = "금융_보험직"
    override fun getMiddleType(): List<CareerMiddleType> = FinanceInsurance.values().toList()
  },
  ART_DESIGN_BROADCASTING {
    override fun toString(): String = "예술_디자인_방송직"
    override fun getMiddleType(): List<CareerMiddleType> = ArtDesignBroadcast.values().toList()
  },
  FOOD_SERVICE {
    override fun toString(): String = "음식_서비스직"
    override fun getMiddleType(): List<CareerMiddleType> = FoodService.values().toList()
  },
  CLEANING_AND_OTHER_PERSONAL_SERVICES {
    override fun toString(): String = "청소_및_기타_개인서비스직"
    override fun getMiddleType(): List<CareerMiddleType> = CleaningAndOtherPersonalServices.values().toList()
  },
  HEALTH_MEDICAL {
    override fun toString(): String = "보건_의료직"
    override fun getMiddleType(): List<CareerMiddleType> = HealthcareMedicalServices.values().toList()
  },
  SOCIAL_WELFARE_RELIGION {
    override fun toString(): String = "사회복지_종교직"
    override fun getMiddleType(): List<CareerMiddleType> = SocialWelfareReligiousWork.values().toList()
  },
  CARE_SERVICE_CAREGIVING_CHILDCARE {
    override fun toString(): String = "돌봄_서비스직_간병_육아"
    override fun getMiddleType(): List<CareerMiddleType> = CareServiceCaregivingChildcare.values().toList()
  },
  MANAGEMENT_EXECUTIVE_DEPARTMENT_HEAD {
    override fun toString(): String = "관리직_임원_부서장"
    override fun getMiddleType(): List<CareerMiddleType> = ManagementExecutiveDepartmentHead.values().toList()
  },
  SECURITY_GUARD {
    override fun toString(): String = "경호_경비직"
    override fun getMiddleType(): List<CareerMiddleType> = SecurityGuard.values().toList()
  },
  SALES {
    override fun toString(): String = "영업_판매직"
    override fun getMiddleType(): List<CareerMiddleType> = SalesAndRetail.values().toList()
  },
  AGRICULTURE_FORESTRY_FISHERY {
    override fun toString(): String = "농림어업직"
    override fun getMiddleType(): List<CareerMiddleType> = AgricultureForestryFishery.values().toList()
  },
  INFORMATION_COMMUNICATION_RESEARCH_DEVELOPMENT_ENGINEERING_TECHNICAL {
    override fun toString(): String = "정보통신_연구개발직_및_공학기술직"
    override fun getMiddleType(): List<CareerMiddleType> = InformationCommunicationResearchDevelopmentEngineering.values().toList()
  },
  SPORTS_RECREATION {
    override fun toString(): String = "스포츠_레크리에이션직"
    override fun getMiddleType(): List<CareerMiddleType> = SportsRecreation.values().toList()
  },
  BEAUTY_WEDDING_SERVICE {
    override fun toString(): String = "미용_예식_서비스직"
    override fun getMiddleType(): List<CareerMiddleType> = BeautyWeddingService.values().toList()
  },
  NATURAL_LIFE_SCIENCE_RESEARCH {
    override fun toString(): String = "자연_생명과학_연구직"
    override fun getMiddleType(): List<CareerMiddleType> = NaturalLifeScienceResearch.values().toList()
  },
  CONSTRUCTION_MINING_RESEARCH_DEVELOPMENT_ENGINEERING_TECHNICAL {
    override fun toString(): String = "건설_채굴_연구개발직_및_공학기술직"
    override fun getMiddleType(): List<CareerMiddleType> = ConstructionMiningResearchDevelopmentEngineering.values().toList()
  },
  CONSTRUCTION_MINING {
    override fun toString(): String = "건설_채굴직"
    override fun getMiddleType(): List<CareerMiddleType> = ConstructionMining.values().toList()
  },
  LEGAL {
    override fun toString(): String = "법률직"
    override fun getMiddleType(): List<CareerMiddleType> = Legal.values().toList()
  },
  HUMANITIES_SOCIAL_SCIENCE_RESEARCH {
    override fun toString(): String = "인문_사회과학_연구직"
    override fun getMiddleType(): List<CareerMiddleType> = HumanitiesSocialSciencesResearch.values().toList()
  },
  TRAVEL_ACCOMMODATION_ENTERTAINMENT_SERVICE {
    override fun toString(): String = "여행_숙박_오락_서비스직"
    override fun getMiddleType(): List<CareerMiddleType> = TravelAccommodationEntertainmentServices.values().toList()
  };

  companion object {
    fun fromString(string: String): CareerMajorType? =
      CareerMajorType.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
  abstract fun getMiddleType(): List<CareerMiddleType>
}