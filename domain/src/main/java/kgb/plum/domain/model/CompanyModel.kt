package kgb.plum.domain.model

data class CompanyModel(
    val id: Int,
    val applicationDate: String,
    val deadLine: String,
    val companyName: String,
    val recruitmentType: String,
    val typeOfEmployment: String,
    val formOfWages: String,
    val wage: String,
    val entryForm: String,
    val requiredExperience: String,
    val requiredEducation: String,
    val majorField: String? = null,
    val requiredCredentials: String? = null,
    val businessAddress: String,
    val companyType: String,
    val responsibleAgency:  String,
    val contactNumber: String,
    val countOfMemberWish: Int = 0,
    val addedWishlist: Boolean = false
)
