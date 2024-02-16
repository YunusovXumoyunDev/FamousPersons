package uz.yxdev.famouspersons.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import uz.yxdev.famouspersons.R
import uz.yxdev.famouspersons.data.model.QuestionData
import uz.yxdev.famouspersons.data.repsitory.QuestionRepository
import uz.yxdev.famouspersons.databinding.ScreenQuizBinding
import uz.yxdev.famouspersons.presenter.QuizPresenter

class QuizScreen : Fragment(R.layout.screen_quiz) {
    private var _binding: ScreenQuizBinding? = null
    private val binding: ScreenQuizBinding get() = _binding!!
    private lateinit var presenter: QuizPresenter
    private lateinit var repository: QuestionRepository
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ScreenQuizBinding.bind(view)
        repository = QuestionRepository(requireContext())
        presenter = QuizPresenter(this, repository)
        loadUiClickable()

    }

    fun clickBack() {
        parentFragmentManager.popBackStack()
    }

    private fun loadUiClickable() {
        binding.backScreen.setOnClickListener {
            presenter.clickableBack()
        }
    }

    fun setQuestion(data: QuestionData) {
        binding.quizText.text=data.questionText
    }
}