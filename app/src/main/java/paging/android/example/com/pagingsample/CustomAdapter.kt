package paging.android.example.com.pagingsample

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

class CustomAdapter : PagedListAdapter<Cheese2, CustomViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder =
            CustomViewHolder(parent)

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Cheese2>() {
            override fun areItemsTheSame(oldConcert: Cheese2,
                                         newConcert: Cheese2): Boolean =
                    oldConcert.id == newConcert.id

            override fun areContentsTheSame(oldConcert: Cheese2,
                                            newConcert: Cheese2): Boolean =
                    oldConcert == newConcert
        }
    }

}


class CustomViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.cheese_item, parent, false)) {
    private val nameView = itemView.findViewById<TextView>(R.id.name)
    var cheese : Cheese2? = null

    /**
     * Items might be null if they are not paged in yet. PagedListAdapter will re-bind the
     * ViewHolder when Item is loaded.
     */
    fun bindTo(cheese : Cheese2?) {
        this.cheese = cheese
        nameView.text = cheese?.name
    }
}