package io.github.freewulkanowy.ui.modules.onboarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import io.github.freewulkanowy.R
import io.github.freewulkanowy.databinding.ActivityOnboardingBinding
import io.github.freewulkanowy.ui.base.BaseActivity
import io.github.freewulkanowy.utils.AppInfo
import io.github.freewulkanowy.utils.InAppUpdateHelper
import javax.inject.Inject

@AndroidEntryPoint
class OnboardingActivity : BaseActivity<OnboardingPresenter, ActivityOnboardingBinding>(), OnboardingView {

    @Inject
    override lateinit var presenter: OnboardingPresenter

    @Inject
    lateinit var inAppUpdateHelper: InAppUpdateHelper

    @Inject
    lateinit var appInfo: AppInfo

    companion object {
        fun getStartIntent(context: Context) = Intent(context, OnboardingActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        setContentView(ActivityOnboardingBinding.inflate(layoutInflater).apply { binding = this }.root)

        presenter.onAttachView(this)
        inAppUpdateHelper.checkAndInstallUpdates()

        if (savedInstanceState == null) {
            openFragment(Onboarding1Fragment.newInstance(), clearBackStack = true)
        }
    }

    override fun initView() {}

    private fun openFragment(fragment: Fragment, clearBackStack: Boolean = false) {
        supportFragmentManager.popBackStack(fragment::class.java.name, POP_BACK_STACK_INCLUSIVE)

        supportFragmentManager.commit {
            replace(R.id.onboardingContainer, fragment)
            setReorderingAllowed(true)
            if (!clearBackStack) addToBackStack(fragment::class.java.name)
        }
    }

    override fun onResume() {
        super.onResume()
        inAppUpdateHelper.onResume()
    }
}
