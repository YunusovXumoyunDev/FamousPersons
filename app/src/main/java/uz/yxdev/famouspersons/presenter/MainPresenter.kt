package uz.yxdev.famouspersons.presenter

import uz.yxdev.famouspersons.data.model.FamousPersonData
import uz.yxdev.famouspersons.data.repsitory.FamousRepository
import uz.yxdev.famouspersons.screen.MainScreen


class MainPresenter(
    private val view: MainScreen,
    private val repository: FamousRepository
) {
    private val ls: List<FamousPersonData> = repository.getFamous()
    init {
        loadUi()
    }

    private fun loadUi() {
        view.setFirstItemDetail(ls[0])
        view.setSecondItemDetail(ls[1])
        view.setThirdItemDetail(ls[2])
        view.setFourthItemDetail(ls[3])
    }

    fun clickFirstItem() {
        view.openDetailScreen(ls[0])
    }

    fun clickSecondItem() {
        view.openDetailScreen(ls[1])
    }

    fun clickThirdItem() {
        view.openDetailScreen(ls[2])

    }

    fun clickFourthItem() {
        view.openDetailScreen(ls[3])
    }
}