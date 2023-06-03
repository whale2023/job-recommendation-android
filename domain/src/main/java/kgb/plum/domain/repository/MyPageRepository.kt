package kgb.plum.domain.repository

import kgb.plum.domain.model.ResumeModel

interface MyPageRepository {
  fun getResume() : ResumeModel
  fun saveResume(resumeModel: ResumeModel) : ResumeModel
}