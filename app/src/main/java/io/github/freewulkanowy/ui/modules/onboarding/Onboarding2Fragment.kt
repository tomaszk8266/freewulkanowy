package io.github.freewulkanowy.ui.modules.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import io.github.freewulkanowy.R
import io.github.freewulkanowy.databinding.FragmentOnboarding2Binding
import io.github.freewulkanowy.ui.base.BaseFragment
import io.github.freewulkanowy.ui.modules.main.MainActivity

class Onboarding2Fragment : BaseFragment<FragmentOnboarding2Binding>(R.layout.fragment_onboarding_2),
    OnboardingView {

    companion object {
        fun newInstance() = Onboarding2Fragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOnboarding2Binding.bind(view)

        binding.onboardingCloseBtn.setOnClickListener {
            val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
            prefs.edit().putBoolean("completedOnboarding", true).apply()
            startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
        }
    }

    override fun initView() {
        (requireActivity() as OnboardingActivity)
    }
}
