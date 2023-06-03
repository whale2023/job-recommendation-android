package kgb.plum.data.datasource

import kgb.plum.domain.model.CareerModel
import kgb.plum.domain.model.ResumeModel
import javax.inject.Inject

class MyPageDataSource @Inject constructor() {
  fun saveResume(resumeModel: ResumeModel): ResumeModel {
    return resumeModel
  }

  fun getResume(): ResumeModel {
    return ResumeModel(
      "Computer Science",
      "BACHELOR",
      50000,
      "FULL_TIME",
      listOf<String>("JAVA", "AWS"),
      listOf<CareerModel>(
        CareerModel(
          3,
          "SOFTWARE_ENGINEER"
        ),
        CareerModel(
          2,
          "FINANCIAL_ANALYST"
        )
      )
    )
  }
}