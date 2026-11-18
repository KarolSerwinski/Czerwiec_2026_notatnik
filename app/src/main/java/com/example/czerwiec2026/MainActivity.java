package com.example.czerwiec2026;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> notes = new ArrayList<>() {{
        add("Tytuł notatki \nJakaś treść");
    }};

    ArrayAdapter<String> adapter;
    Button btn;
    ListView listView;
    EditText title, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.list);
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        btn = findViewById(R.id.btn);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(adapter);

        btn.setOnClickListener(v -> {
            String note = title.getText().toString() + "\n" + content.getText().toString();
            notes.add(note);
            adapter.notifyDataSetChanged();
        });
    }
}