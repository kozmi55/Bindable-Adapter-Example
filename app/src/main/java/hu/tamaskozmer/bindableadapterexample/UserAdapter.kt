package hu.tamaskozmer.bindableadapterexample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserHolder>() {

    var userIds = emptyList<Long>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserHolder(inflater.inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount() = userIds.size

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(userIds[position])
    }

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(userId: Long) {
            itemView.userText.text = "User id: $userId"
        }
    }

}