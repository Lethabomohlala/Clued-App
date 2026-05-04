package com.example.cluedapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 10)

        val tvScore = findViewById<TextView>(R.id.tvScore)
        tvScore.text = getString(R.string.results_score_format, score / 10, total)

        val btnHome = findViewById<Button>(R.id.btnHome)
        btnHome.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        val btnTryAgain = findViewById<Button>(R.id.btnTryAgain)
        btnTryAgain.setOnClickListener {
            finish() // This will take them back to the quiz if it wasn't finished, 
            // but since we called finish() in QuizActivity, we should ideally go back to Welcome
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}
