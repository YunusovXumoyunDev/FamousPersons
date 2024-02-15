package uz.yxdev.famouspersons.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import uz.yxdev.famouspersons.R
import uz.yxdev.famouspersons.data.model.FamousPersonData
import uz.yxdev.famouspersons.data.repsitory.FamousRepository
import uz.yxdev.famouspersons.databinding.ScreenMainBinding
import uz.yxdev.famouspersons.presenter.MainPresenter


class MainScreen : Fragment(R.layout.screen_main) {
    private var _binding: ScreenMainBinding? = null
    private val binding: ScreenMainBinding get() = _binding!!
    private lateinit var repository: FamousRepository
    private lateinit var presenter: MainPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /**
         * binding creating
         */
        _binding = ScreenMainBinding.bind(view)
        /**
         * mvp details creating
         */
        repository = FamousRepository(requireContext())
        presenter = MainPresenter(view = this, repository = repository)
        /**
         * ui logic
         */
        loadUiClickable()
    }

    fun setFirstItemDetail(data: FamousPersonData) {
        binding.firstItem.image.setImageResource(data.image)
        binding.firstItem.name.text = data.name
    }

    fun setSecondItemDetail(data: FamousPersonData) {
        binding.secondItem.image.setImageResource(data.image)
        binding.secondItem.name.text = data.name
    }

    fun setThirdItemDetail(data: FamousPersonData) {
        binding.thirdItem.image.setImageResource(data.image)
        binding.thirdItem.name.text = data.name
    }

    fun setFourthItemDetail(data: FamousPersonData) {
        binding.fourthItem.image.setImageResource(data.image)
        binding.fourthItem.name.text = data.name
    }


    fun openDetailScreen(data: FamousPersonData) {
        parentFragmentManager.commit {
            replace(
                R.id.fragment_container,
                DetailScreen::class.java,
                bundleOf("id" to data.id),
                "Details Screen"
            )
            addToBackStack(null)
        }
    }

     fun loadUiClickable() {
        binding.firstItem.root.setOnClickListener {
            presenter.clickFirstItem()
        }
        binding.secondItem.root.setOnClickListener {
            presenter.clickSecondItem()
        }
        binding.thirdItem.root.setOnClickListener {
            presenter.clickThirdItem()
        }
        binding.fourthItem.root.setOnClickListener {
            presenter.clickFourthItem()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}