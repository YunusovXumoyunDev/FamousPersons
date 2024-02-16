package uz.yxdev.famouspersons.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import uz.yxdev.famouspersons.R
import uz.yxdev.famouspersons.databinding.ScreenQuizBinding
import uz.yxdev.famouspersons.presenter.QuizPresenter

class QuizScreen : Fragment(R.layout.screen_quiz) {
    private var _binding: ScreenQuizBinding? = null
    private val binding: ScreenQuizBinding get() = _binding!!
    private lateinit var presenter: QuizPresenter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding= ScreenQuizBinding.bind(view)
        loadUiClickable()
    }
    fun clickBack(){
        parentFragmentManager.commit {
            replace(
                R.id.fragment_container,
                DetailScreen(),
                "Details Screen"
            )
            addToBackStack(null)
        }
    }
    private fun loadUiClickable(){
        binding.backScreen.setOnClickListener {
            presenter.clickableBack()
        }
    }
}