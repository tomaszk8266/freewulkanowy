package io.github.freewulkanowy.ui.modules.login.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.freewulkanowy.R
import io.github.freewulkanowy.databinding.FragmentOnboardingWarningBinding
import io.github.freewulkanowy.ui.base.BaseFragment
import io.github.freewulkanowy.ui.modules.login.LoginActivity

class LoginOnboardingWarningFragment : BaseFragment<FragmentOnboardingWarningBinding>(R.layout.fragment_onboarding_warning), LoginOnboardingView {

    companion object {
        fun newInstance() = LoginOnboardingWarningFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding_warning, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as LoginActivity).showActionBar(show = false)
        binding = FragmentOnboardingWarningBinding.bind(view)

        binding.onboardingNextBtn.setOnClickListener {
            (requireActivity() as LoginActivity).navigateToOnboardingWelcomeFragment()
        }
    }

    override fun initView() {
        (requireActivity() as LoginActivity)
    }
}
