package uz.yxdev.famouspersons.data.repsitory

import android.content.Context
import uz.yxdev.famouspersons.R
import uz.yxdev.famouspersons.data.model.QuestionData

class QuestionRepository(private val context: Context) {
    private val questions = ArrayList<QuestionData>()

    init {
        loadList()
    }

    private fun loadList() {
        addQuestion(
            QuestionData(
                id = questions.size,
                famousID = questions.size,
                questionText = context.getString(R.string.alisher_question_1),
                variantA = "1441-yilda Hirotda",
                variantB = "1440-yilda Samarqandda",
                variantC = "1501-yilda Hirotda",
                variantD = "1401-yilda Xurosonda",
                correctAnswer = "1441-yilda Hirotda"
            )
        )
        addQuestion(
            QuestionData(
                id = questions.size,
                famousID = questions.size,
                questionText = context.getString(R.string.alisher_question_2),
                variantA = "Lutfiy",
                variantB = "Buxoriy",
                variantC = "Bobur",
                variantD = "Ahmad Yassaviy",
                correctAnswer = "Lutfiy"
            )
        )
        addQuestion(
            QuestionData(
                id = questions.size,
                famousID = questions.size,
                questionText = context.getString(R.string.alisher_question_2),
                variantA = "10-12 yoshlaridan",
                variantB = "8 yoshidan",
                variantC = "16 yoshidan",
                variantD = "19 yoshidan",
                correctAnswer = "10-12 yoshlaridan"
            )
        )

    }

    fun getList(famousID: Int): List<QuestionData> {
        val newLs = questions.filter { item ->
            item.famousID == famousID
        }
        return newLs.shuffled()
    }

    private fun addQuestion(data: QuestionData) {
        questions.add(data)
    }
}