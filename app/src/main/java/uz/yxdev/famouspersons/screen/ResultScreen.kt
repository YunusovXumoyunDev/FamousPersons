package uz.yxdev.famouspersons.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import uz.yxdev.famouspersons.R
import uz.yxdev.famouspersons.databinding.ScreenResultBinding
import uz.yxdev.famouspersons.presenter.QuizPresenter
import uz.yxdev.famouspersons.presenter.ResultPresenter

class ResultScreen : Fragment(R.layout.screen_result) {
    private var _binding: ScreenResultBinding? = null
    private val binding: ScreenResultBinding get() = _binding!!
    private lateinit var presenter: ResultPresenter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ScreenResultBinding.bind(view)
        presenter= ResultPresenter(this)
        loadUi()
    }
    private fun loadUi(){
        presenter.loadUiResult()
    }
    fun setCorrectCount(){
        requireArguments().apply {
            val correctCount = getInt("correctCount")
            binding.correctCountEt.text=correctCount.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}