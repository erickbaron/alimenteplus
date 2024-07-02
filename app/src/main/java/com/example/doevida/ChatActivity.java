package com.example.doevida;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private List<Message> messageList;
    private ChatAdapter chatAdapter;
    private RecyclerView recyclerView;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerView = findViewById(R.id.recyclerViewChat);
        editTextMessage = findViewById(R.id.editTextMessage);
        ImageButton buttonSend = findViewById(R.id.buttonSend);

        // Configuração inicial da RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializa a lista de mensagens
        messageList = new ArrayList<>();
        messageList.add(new Message("Olá! Ainda está disponível?", true)); // Mensagem enviada
        messageList.add(new Message("Ola! Sim?", false)); // Mensagem recebida
        messageList.add(new Message("Posso passar buscar as 14h?", true)); // Mensagem enviada
        messageList.add(new Message("Agendado!", false)); // Mensagem enviada

        // Inicializa e configura o adapter
        chatAdapter = new ChatAdapter(messageList, this);
        recyclerView.setAdapter(chatAdapter);

        // Configuração do botão de enviar mensagem
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    // Método para enviar uma mensagem
    private void sendMessage() {
        String messageText = editTextMessage.getText().toString().trim();
        if (!messageText.isEmpty()) {
            // Adiciona a mensagem enviada à lista
            messageList.add(new Message(messageText, true));
            // Notifica o adapter sobre a adição da mensagem
            chatAdapter.notifyItemInserted(messageList.size() - 1);
            // Limpa o campo de texto após enviar a mensagem
            editTextMessage.setText("");
            // Role a RecyclerView para mostrar a nova mensagem
            recyclerView.smoothScrollToPosition(messageList.size() - 1);
        }
    }
}

