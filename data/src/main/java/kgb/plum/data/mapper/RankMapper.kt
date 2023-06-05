package kgb.plum.data.mapper

import kgb.plum.data.model.CompanyResponse
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.RankItem
import java.util.Collections.addAll
import javax.inject.Inject

class RankMapper @Inject constructor(

) : BaseMapper<List<CompanyResponse>, List<RankItem>>() {
    override fun getSuccess(
        model: List<CompanyResponse>?,
        extra: Any?
    ): EntityWrapper.Success<List<RankItem>> {
        return model?.let {
            EntityWrapper.Success(
                entity = mutableListOf<RankItem>()
                    .apply {
                        addAll(model.map { it.toRankItem() })
                    }
            )
        } ?: EntityWrapper.Success(
            entity = listOf()
        )
    }

    override fun getFailure(error: Throwable): EntityWrapper.Fail<List<RankItem>> {
        return EntityWrapper.Fail(error)
    }
}