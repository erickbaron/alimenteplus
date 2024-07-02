package com.example.doevida

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class FeedAdapter(private val feedList: List<FeedItem>, private val context: Context) :
    RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_feed_item, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val (username, description) = feedList[position]
        holder.feedItemUsername.text = username
        holder.feedItemText.text = description
        holder.buttonChat.setOnClickListener {
            val intent = Intent(context, ChatActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return feedList.size
    }

    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var feedItemUsername: TextView
        var feedItemText: TextView
        var buttonChat: ImageButton

        init {
            feedItemUsername = itemView.findViewById<TextView>(R.id.textViewUsername)
            feedItemText = itemView.findViewById<TextView>(R.id.textViewDescription)
            buttonChat = itemView.findViewById(R.id.buttonChat)
        }
    }
}

