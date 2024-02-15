package uz.yxdev.famouspersons.presenter

import uz.yxdev.famouspersons.data.repsitory.FamousRepository
import uz.yxdev.famouspersons.screen.DetailScreen
import uz.yxdev.famouspersons.screen.MainScreen


class DetailPresenter(
    private val view: DetailScreen,
    private val repository: FamousRepository
) {


    fun loadUi(index: Int) {
        val data = repository.getFamousById(index)
        view.loadUiFamous(data)
    }

    fun clickableBack() {
        view.clickBack()
    }
    fun openScreen(){
        view.openTestScreen()
    }


}