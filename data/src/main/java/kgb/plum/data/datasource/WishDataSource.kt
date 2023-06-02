package kgb.plum.data.datasource

import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.WishItemData
import javax.inject.Inject

class WishDataSource @Inject constructor() {

    val wishList = listOf(CompanyModel(id = 2,
        applicationDate =  "2023-01-31 00:00:00",
    deadLine =  "2023-02-28",
    companyName= "(주)서한",
    recruitmentType = "총무 및 일반 사무원",
    typeOfEmployment= "계약직",
    formOfWages= "월급",
    wage =  "2100000",
    entryForm =  "무관",
    requiredExperience= "무관",
    requiredEducation= "고졸",
    majorField = "",
    requiredCredentials= "",
    businessAddress= "대구광역시 수성구 명덕로 415 (수성동2가)",
    companyType= "중소",
    responsibleAgency = "대구지역본부",
    contactNumber= "1588-1519",
    countOfMemberWish= 1,
    addedWishlist =true))
    fun getWishList() : List<CompanyModel> {
        return wishList
    }
}