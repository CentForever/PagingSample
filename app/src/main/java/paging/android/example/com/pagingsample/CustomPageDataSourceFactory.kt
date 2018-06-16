package paging.android.example.com.pagingsample

import android.arch.paging.DataSource

class CustomPageDataSourceFactory(val repository: DataRepository) : DataSource.Factory<Int, Cheese2>() {
    override fun create(): DataSource<Int, Cheese2> {
        return CustomPageDataSource(repository)
    }
}