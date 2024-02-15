package uz.yxdev.famouspersons.presenter

import uz.yxdev.famouspersons.data.repsitory.FamousRepository
import uz.yxdev.famouspersons.screen.DetailScreen
import uz.yxdev.famouspersons.screen.MainScreen


class DetailPresenter(
    private val view: DetailScreen,
    private val repository: FamousRepository,
    private val mainClick: MainScreen
) {
    init {

    }
    fun loadUi(){

    }



}