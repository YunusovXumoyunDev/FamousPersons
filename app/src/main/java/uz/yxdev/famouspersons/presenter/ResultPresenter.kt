package uz.yxdev.famouspersons.presenter

import uz.yxdev.famouspersons.screen.ResultScreen

class ResultPresenter(
    private val view: ResultScreen
) {
    fun loadUiResult(){
        view.setCorrectCount()
    }
}