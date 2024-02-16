package uz.yxdev.famouspersons.data.repsitory

import android.content.Context
import uz.yxdev.famouspersons.R
import uz.yxdev.famouspersons.data.model.FamousPersonData

class FamousRepository(private val context: Context) {
    private var ls = ArrayList<FamousPersonData>()
    fun getFamous(): List<FamousPersonData> {
        return ls
    }

    fun getFamousById(id: Int): FamousPersonData? {
        val data = ls.find { item ->
            item.id == id
        }
        return data
    }

    init {
        loadList()
    }

    fun loadList() {
        addPerson(
            FamousPersonData(
                id = ls.size,
                name = context.getString(R.string.alisher_navoiy_title),
                image = R.drawable.alisher_navoiy,
                description = context.getString(R.string.alisher_navoiy_description)
            )
        )
        addPerson(
            FamousPersonData(
                id = ls.size,
                name = context.getString(R.string.lutfiy_title),
                image = R.drawable.lutfiy,
                description = context.getString(R.string.lutfiy)
            )
        )
        addPerson(
            FamousPersonData(
                id = ls.size,
                name = context.getString(R.string.buxoriy_title),
                image = R.drawable.imom_buxoriy,
                description = context.getString(R.string.buxoriy)
            )
        )
        addPerson(
            FamousPersonData(
                id = ls.size,
                name = context.getString(R.string.behbudiy_title),
                image = R.drawable.behbudiy,
                description = context.getString(R.string.behbudiy)
            )
        )
        ls.shuffle()
    }

    private fun addPerson(data: FamousPersonData) {
        ls.add(data)
    }
}