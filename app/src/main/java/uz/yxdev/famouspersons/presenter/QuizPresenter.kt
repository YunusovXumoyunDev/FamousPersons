package uz.yxdev.famouspersons.presenter

import uz.yxdev.famouspersons.data.repsitory.QuestionRepository
import uz.yxdev.famouspersons.screen.QuizScreen

class QuizPresenter(
    private val view: QuizScreen,
    private val repository: QuestionRepository
) {
    init {
        loadUi()
    }

    fun clickableBack() {
        view.clickBack()
    }

    private fun loadUi() {
        val ls=repository.getList(view.getFamousID())
        view.setQuestion(ls[0])
        view.setQuestion(ls[1])
        view.setQuestion(ls[2])
        view.setQuestion(ls[3])
    }
}