package io.github.freewulkanowy.ui.modules.login.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import io.github.freewulkanowy.R
import io.github.freewulkanowy.databinding.FragmentOnboardingWelcomeBinding
import io.github.freewulkanowy.ui.base.BaseFragment
import io.github.freewulkanowy.ui.modules.login.LoginActivity
import io.github.freewulkanowy.ui.modules.login.form.LoginFormFragment

class LoginOnboardingWelcomeFragment : BaseFragment<FragmentOnboardingWelcomeBinding>(R.layout.fragment_onboarding_welcome), LoginOnboardingView {

    companion object {
        fun newInstance() = LoginOnboardingWelcomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as LoginActivity).showActionBar(show = false)
        binding = FragmentOnboardingWelcomeBinding.bind(view)

        binding.onboardingNextBtn.setOnClickListener {
            val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
            prefs.edit().putBoolean("completedOnboarding", true).apply()

            (requireActivity() as LoginActivity).navigateToLoginForm()
        }
    }

    override fun initView() {
        (requireActivity() as LoginActivity)
    }
}
