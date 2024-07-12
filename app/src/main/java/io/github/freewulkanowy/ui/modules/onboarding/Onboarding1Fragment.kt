package io.github.freewulkanowy.ui.modules.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.freewulkanowy.R
import io.github.freewulkanowy.databinding.FragmentOnboarding1Binding
import io.github.freewulkanowy.ui.base.BaseFragment

class Onboarding1Fragment : BaseFragment<FragmentOnboarding1Binding>(R.layout.fragment_onboarding_1),
    OnboardingView {

    companion object {
        fun newInstance() = Onboarding1Fragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    return inflater.inflate(R.layout.fragment_onboarding_1, container, false)
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOnboarding1Binding.bind(view)

        binding.onboardingNextBtn.setOnClickListener {
            val newFragment = Onboarding2Fragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.onboardingContainer, newFragment)
            transaction.commit()
        }
    }

    override fun initView() {
        (requireActivity() as OnboardingActivity)
    }
}
