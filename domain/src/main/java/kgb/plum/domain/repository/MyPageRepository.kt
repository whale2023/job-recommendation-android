package kgb.plum.domain.repository

import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.ResumeModel

interface MyPageRepository {
  suspend fun getResume() : EntityWrapper<ResumeModel>
  suspend fun saveResume(resumeModel: ResumeModel) : EntityWrapper<ResumeModel>
  suspend fun deleteResume() : EntityWrapper<ResumeModel>
}