package uz.yxdev.famouspersons.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.view.get
import uz.yxdev.famouspersons.R
import uz.yxdev.famouspersons.data.model.FamousPersonData
import uz.yxdev.famouspersons.data.repsitory.FamousRepository
import uz.yxdev.famouspersons.databinding.ScreenDetailsBinding
import uz.yxdev.famouspersons.presenter.DetailPresenter
import uz.yxdev.famouspersons.presenter.MainPresenter


class DetailScreen : Fragment(R.layout.screen_details) {
    private var _binding: ScreenDetailsBinding? = null
    private val binding: ScreenDetailsBinding get() = _binding!!
    private lateinit var repository: FamousRepository
    private lateinit var presenter: DetailPresenter
    private lateinit var mainScreen: MainScreen
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ScreenDetailsBinding.bind(view)
        repository = FamousRepository(requireContext())
        loadUiClickable()
        loadUi()
    }
    private fun loadUiClickable(){
        binding.back.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.startTest.setOnClickListener {
            Toast.makeText(context,"tez kunda",Toast.LENGTH_SHORT).show()
        }
    }
    private fun loadUi(){
        binding.image.setImageResource(repository.getFamousById(0).image)
        binding.name.text=repository.getFamousById(0).name
        binding.description.text= repository.getFamousById(0).description
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}