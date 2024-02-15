package uz.yxdev.famouspersons.data.model

import androidx.annotation.DrawableRes


data class FamousPersonData(
    val id: Int,
    val name: String,
    @DrawableRes
    val image: Int,
    val description: String
)
