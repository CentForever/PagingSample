package paging.android.example.com.pagingsample


class DataRepository(){

    private val data = ArrayList<Cheese2>()

    init {
        /*CHEESE_DATA.map {
            var cheese2 = Cheese2()
            cheese2.id=Guid.generateId()
            cheese2.id=it
            data.add(cheese2)
        }*/
        for (i in 0..1000) {
            val bean = Cheese2(Guid.generateId(), "name $i")
            data.add(bean)
        }
    }

    fun loadData(size: Int): List<Cheese2> {
        return data.subList(0, size)
    }

    fun loadData(index: Int, size: Int): List<Cheese2>? {

        if (index >= data.size - 1 || index < 1) {
            return null
        }

        if (index + size > data.size) {
            return data.subList(index + 1, data.size)
        }
        return data.subList(index + 1, index + size)
    }

    fun loadPageData(page: Int, size: Int): List<Cheese2>? {
        val totalPage = if (data.size % size == 0) {
            data.size / size
        } else {
            data.size / size + 1
        }

        if (page > totalPage || page < 1) {
            return null
        }

        if (page == totalPage) {
            return data.subList((page - 1) * size, data.size)
        }
        return data.subList((page - 1) * size, page * size)
    }
}