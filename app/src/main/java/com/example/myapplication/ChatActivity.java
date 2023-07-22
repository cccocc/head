package com.example.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ChatActivity extends AppCompatActivity {

    private TextView tvChatHistory;
    private EditText etMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        tvChatHistory = findViewById(R.id.tv_chat_history);
        etMessage = findViewById(R.id.et_message);
        btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userMessage = etMessage.getText().toString();
                tvChatHistory.append("\nUser: " + userMessage);
                etMessage.setText("");

                new SendMessage().execute(userMessage);
            }
        });
    }

    private class SendMessage extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL("https://api.openai.com/v1/completions");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Authorization", "Bearer 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");
                conn.setDoOutput(true);

                JSONObject root = new JSONObject();
                root.put("model", "text-davinci-003");
                root.put("prompt", params[0]);
                root.put("max_tokens", 7);
                root.put("temperature", 0);

                String jsonString = root.toString();

                OutputStream os = conn.getOutputStream();
                os.write(jsonString.getBytes());
                os.flush();
                os.close();

                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    Scanner sc = new Scanner(url.openStream());
                    StringBuilder result = new StringBuilder();

                    while (sc.hasNext()) {
                        result.append(sc.nextLine());
                    }

                    JSONObject resultJson = new JSONObject(result.toString());
                    JSONArray choices = resultJson.getJSONArray("choices");
                    if (choices.length() > 0) {
                        return choices.getJSONObject(0).getString("text");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (s != null) {
                tvChatHistory.append("\nAI: " + s);
            } else {
                tvChatHistory.append("\nAI: " + "Error!");
            }
        }
    }
}
