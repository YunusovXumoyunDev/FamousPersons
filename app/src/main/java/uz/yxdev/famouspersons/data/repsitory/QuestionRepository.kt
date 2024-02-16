package uz.yxdev.famouspersons.data.repsitory

import android.content.Context
import uz.yxdev.famouspersons.data.model.QuestionData

class QuestionRepository (val context: Context) {
    private val question = ArrayList<QuestionData>()

    init {
        loadList()
    }

    private fun loadList() {


    }

    fun getList(famousId: Int): List<QuestionData> {
        val newLs = question.filter { item ->
            item.famousID == famousId

        }
        return newLs.shuffled()
    }

    private fun addQuestion(data: QuestionData) {
        question.add(data)
    }
}