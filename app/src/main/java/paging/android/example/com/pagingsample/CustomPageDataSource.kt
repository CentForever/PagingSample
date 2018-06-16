package paging.android.example.com.pagingsample

import android.arch.paging.PageKeyedDataSource

class CustomPageDataSource(val repository: DataRepository) : PageKeyedDataSource<Int, Cheese2>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Cheese2>) {
        val data = repository.loadData(params.requestedLoadSize)
        callback.onResult(data, null, 2)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Cheese2>) {
        val data = repository.loadPageData(params.key,params.requestedLoadSize)
        data?.let {
            callback.onResult(data, params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Cheese2>) {
        val data = repository.loadPageData(params.key,params.requestedLoadSize)
        data?.let {
            callback.onResult(data, params.key - 1)
        }
    }
}