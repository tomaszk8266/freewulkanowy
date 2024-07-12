package io.github.freewulkanowy.ui.modules.onboarding

import io.github.freewulkanowy.data.repositories.StudentRepository
import io.github.freewulkanowy.ui.base.BasePresenter
import io.github.freewulkanowy.ui.base.ErrorHandler
import timber.log.Timber
import javax.inject.Inject

class OnboardingPresenter @Inject constructor(
    errorHandler: ErrorHandler,
    studentRepository: StudentRepository,
) : BasePresenter<OnboardingView>(errorHandler, studentRepository) {

    override fun onAttachView(view: OnboardingView) {
        super.onAttachView(view)
        view.initView()
        Timber.i("Onboarding view was initialized")
    }
}
