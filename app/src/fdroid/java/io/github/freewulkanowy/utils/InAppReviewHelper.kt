package io.github.freewulkanowy.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import io.github.freewulkanowy.ui.modules.main.MainActivity
import javax.inject.Singleton
import javax.inject.Inject

@Suppress("UNUSED_PARAMETER", "unused")
@Singleton
class InAppReviewHelper @Inject constructor(
    @ApplicationContext private val context: Context
)  {

    fun showInAppReview(activity: MainActivity) {
        // do nothing
    }
}
