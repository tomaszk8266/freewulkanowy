package io.github.freewulkanowy.ui.modules.debug

import io.github.freewulkanowy.R
import io.github.freewulkanowy.data.repositories.StudentRepository
import io.github.freewulkanowy.ui.base.BasePresenter
import io.github.freewulkanowy.ui.base.ErrorHandler
import timber.log.Timber
import javax.inject.Inject

class DebugPresenter @Inject constructor(
    errorHandler: ErrorHandler,
    studentRepository: StudentRepository,
) : BasePresenter<DebugView>(errorHandler, studentRepository) {

    val items = listOf(
        DebugItem(R.string.logviewer_title),
        DebugItem(R.string.notification_debug_title),
        DebugItem(R.string.debug_cookies_clear),
    )

    override fun onAttachView(view: DebugView) {
        super.onAttachView(view)
        Timber.i("Debug view was initialized")

        with(view) {
            initView()
            setItems(items)
        }
    }

    fun onItemSelect(item: DebugItem) {
        when (item.title) {
            R.string.logviewer_title -> view?.openLogViewer()
            R.string.notification_debug_title -> view?.openNotificationsDebug()
            R.string.debug_cookies_clear -> view?.clearWebkitCookies()
            else -> Timber.d("Unknown debug item: $item")
        }
    }
}
