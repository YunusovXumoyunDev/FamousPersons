package uz.yxdev.famouspersons.presenter

import uz.yxdev.famouspersons.screen.QuizScreen

class QuizPresenter(
    private val view: QuizScreen
) {
 fun clickableBack(){
     view.clickBack()
 }
}