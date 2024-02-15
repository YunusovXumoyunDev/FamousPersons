package uz.yxdev.famouspersons.presenter

import uz.yxdev.famouspersons.data.repsitory.FamousRepository
import uz.yxdev.famouspersons.screen.MainScreen


class MainPresenter(
    private val view: MainScreen,
    private val repository: FamousRepository
) {
    init {
        loadUi()
    }

    private fun loadUi() {
        val ls = repository.getFamous()
        view.setFirstItemDetail(ls[0])
        view.setSecondItemDetail(ls[1])
        view.setThirdItemDetail(ls[2])
        view.setFourthItemDetail(ls[3])
    }

    fun clickFirstItem() {
        view.openDetailScreen(repository.getFamousById(0))
    }

    fun clickSecondItem() {
        view.openDetailScreen(repository.getFamousById(1))
    }

    fun clickThirdItem() {
        view.openDetailScreen(repository.getFamousById(2))
    }

    fun clickFourthItem() {
        view.openDetailScreen(repository.getFamousById(3))
    }
}