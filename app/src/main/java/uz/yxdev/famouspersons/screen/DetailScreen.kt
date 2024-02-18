package uz.yxdev.famouspersons.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import uz.yxdev.famouspersons.R
import uz.yxdev.famouspersons.data.model.FamousPersonData
import uz.yxdev.famouspersons.data.repsitory.FamousRepository
import uz.yxdev.famouspersons.databinding.ScreenDetailsBinding
import uz.yxdev.famouspersons.presenter.DetailPresenter


class DetailScreen : Fragment(R.layout.screen_details) {
    private var _binding: ScreenDetailsBinding? = null
    private val binding: ScreenDetailsBinding get() = _binding!!
    private lateinit var repository: FamousRepository
    private lateinit var presenter: DetailPresenter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ScreenDetailsBinding.bind(view)
        repository = FamousRepository(requireContext())
        presenter = DetailPresenter(this, repository)
        loadUiClickable()
        initialize()

    }

    fun loadUiFamous(data: FamousPersonData) {
        binding.image.setImageResource(data.image)
        binding.name.text = data.name
        binding.description.text = data.description
    }

    private fun initialize() {
        val famousId = requireArguments().getInt("id", 0)
        presenter.loadUi(famousId)
    }

    private fun loadUiClickable() {
        binding.back.setOnClickListener {
            presenter.clickableBack()
        }
        binding.startTest.setOnClickListener {
            presenter.openQuizScreen()
        }
    }

    fun clickBack() {
        parentFragmentManager.popBackStack()
    }

    fun openTestScreen(id: Int) {
        parentFragmentManager.commit {
            replace(
                R.id.fragment_container,
                QuizScreen::class.java,
                bundleOf("famousID" to id),
                "Quiz Screen"
            )
            addToBackStack(null)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}