package kgb.plum.data.mapper

import kgb.plum.data.model.CompanyResponse
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.RankItem

fun CompanyResponse.toRankItem(): RankItem = RankItem(
    company = this.companyName,
    occupation = this.recruitmentType
)

fun CompanyResponse.toCompanyModel(): CompanyModel = CompanyModel(
    id = id,
    applicationDate = applicationDate,
    recruitmentPeriod = recruitmentPeriod,
    companyName = companyName,
    recruitmentType = recruitmentType,
    typeOfEmployment = typeOfEmployment,
    formOfWages = formOfWages,
    wage = wage,
    entryForm = entryForm,
    requiredExperience = requiredExperience,
    requiredEducation = requiredEducation,
    majorField = majorField,
    requiredCredentials = requiredCredentials,
    businessAddress = businessAddress,
    companyType = companyType,
    responsibleAgency = responsibleAgency,
    registrationDate = registrationDate,
    contactNumber = contactNumber,
    countOfMemberWish = countOfMemberWish,
    addedWishlist = addedWishlist
)