package kgb.plum.data.mapper

import kgb.plum.data.model.CompanyResponse
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import javax.inject.Inject

class CompanyMapper @Inject constructor(

) :BaseMapper<List<CompanyResponse>, List<CompanyModel>>(){
    override fun getSuccess(
        model: List<CompanyResponse>?,
        extra: Any?
    ): EntityWrapper.Success<List<CompanyModel>> {
        return model?.let {
            EntityWrapper.Success(
                entity = mutableListOf<CompanyModel>()
                    .apply {
                        addAll(model.map { it.toCompanyModel() })
                    }
            )
        } ?: EntityWrapper.Success(
            entity = listOf()
        )
    }

    override fun getFailure(error: Throwable): EntityWrapper.Fail<List<CompanyModel>> {
        return EntityWrapper.Fail(error)
    }



}