package com.example.cluedapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val topics = resources.getStringArray(R.array.quiz_topics)
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, topics)
        val topicSelector = findViewById<AutoCompleteTextView>(R.id.topicSelector)
        topicSelector.setAdapter(adapter)

        topicSelector.setText(topics[0], false)

        val btnStart = findViewById<Button>(R.id.btnstart)
        btnStart.setOnClickListener {
            val selectedTopic = topicSelector.text.toString()
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra("SELECTED_TOPIC", selectedTopic)
            startActivity(intent)
        }
    }
}
