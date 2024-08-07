package io.github.freewulkanowy.ui.modules.auth

import io.github.freewulkanowy.ui.base.BaseView

interface AuthView : BaseView {

    fun enableAuthButton(isEnabled: Boolean)

    fun showProgress(show: Boolean)

    fun showPeselError(show: Boolean)

    fun showInvalidPeselError(show: Boolean)

    fun showSuccess(show: Boolean)

    fun showContent(show: Boolean)

    fun showDescriptionWithName(name: String)
}
