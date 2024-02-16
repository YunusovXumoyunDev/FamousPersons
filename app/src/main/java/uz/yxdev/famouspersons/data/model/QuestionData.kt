package uz.yxdev.famouspersons.data.model

data class QuestionData(
    val id: Int,
    val famousID: Int,
    val questionText: String,
    val variantA: String,
    val variantB: String,
    val variantC: String,
    val variantD: String,
    val correctAnswer: String
)
