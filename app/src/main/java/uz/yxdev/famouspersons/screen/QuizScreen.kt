package uz.yxdev.famouspersons.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.children
import androidx.core.view.isVisible
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
        loadUi()
        loadUiClickable()

    }

    private fun loadUi() {
        val id = requireArguments().getInt("famousID", 0)
        presenter.loadUi(id)
    }

    fun setQuestion(data: QuestionData) {
        binding.quizText.text = data.questionText
        binding.firstAnswer.text = data.variantA
        binding.secondAnswer.text = data.variantB
        binding.thirdAnswer.text = data.variantC
        binding.fourthAnswer.text = data.variantD
    }

    fun changeNextIcon(isLast: Boolean) {
        if (isLast) {
            binding.quizNextImage.setImageResource(R.drawable.done_icon)
        } else {
            binding.quizNextImage.setImageResource(R.drawable.next_icon)
        }

    }

    fun changePrevVisibility(isFirst: Boolean) {
        binding.quizBackBtn.isVisible = !isFirst
    }

    fun clickBack() {
        parentFragmentManager.popBackStack()
    }

    private fun loadUiClickable() {
        binding.backScreen.setOnClickListener {
            presenter.clickableBack()
        }
        binding.quizNextBtn.setOnClickListener {
            var checkedIndex = 0
            binding.radioGr.children.forEachIndexed { index, view ->
                if (view.id == binding.radioGr.checkedRadioButtonId)
                    checkedIndex == index
            }
            presenter.next(checkedIndex)
            binding.quizBackBtn.setOnClickListener {
                presenter.previous()
            }
        }
    }

    fun openResult(count: Int) {
        parentFragmentManager.commit {
            replace(
                R.id.fragment_container,
                ResultScreen::class.java,
                bundleOf("correctCount" to count),
                "Result Screen"
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}