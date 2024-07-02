package com.example.doevida;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_SENT = 1;
    private static final int VIEW_TYPE_RECEIVED = 2;

    private List<Message> messageList;
    private Context context;

    public ChatAdapter(List<Message> messageList, Context context) {
        this.messageList = messageList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        if (viewType == VIEW_TYPE_SENT) {
            view = inflater.inflate(R.layout.message_sent, parent, false);
            return new SentMessageViewHolder(view);
        } else { // VIEW_TYPE_RECEIVED
            view = inflater.inflate(R.layout.message_received, parent, false);
            return new ReceivedMessageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = messageList.get(position);

        if (holder.getItemViewType() == VIEW_TYPE_SENT) {
            SentMessageViewHolder sentHolder = (SentMessageViewHolder) holder;
            sentHolder.textMessageSent.setText(message.getMessage());
        } else { // VIEW_TYPE_RECEIVED
            ReceivedMessageViewHolder receivedHolder = (ReceivedMessageViewHolder) holder;
            receivedHolder.textMessageReceived.setText(message.getMessage());
        }
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messageList.get(position);
        if (message.isSentByMe()) {
            return VIEW_TYPE_SENT;
        } else {
            return VIEW_TYPE_RECEIVED;
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    private static class SentMessageViewHolder extends RecyclerView.ViewHolder {
        TextView textMessageSent;

        SentMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textMessageSent = itemView.findViewById(R.id.textMessageSent);
        }
    }

    private static class ReceivedMessageViewHolder extends RecyclerView.ViewHolder {
        TextView textMessageReceived;

        ReceivedMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textMessageReceived = itemView.findViewById(R.id.textMessageReceived);
        }
    }
}

