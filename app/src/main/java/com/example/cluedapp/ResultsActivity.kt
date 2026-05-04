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
        val questionIds = intent.getIntArrayExtra("QUESTION_IDS")
        val userAnswers = intent.getBooleanArrayExtra("USER_ANSWERS")

        val tvScore = findViewById<TextView>(R.id.tvScore)
        tvScore.text = getString(R.string.results_score_format, score / 10, total)

        val tvCorrectCount = findViewById<TextView>(R.id.tvCorrectCount)
        val tvIncorrectCount = findViewById<TextView>(R.id.tvIncorrectCount)
        tvCorrectCount.text = (score / 10).toString()
        tvIncorrectCount.text = (total - (score / 10)).toString()

        val btnReview = findViewById<Button>(R.id.btnReview)
        btnReview.setOnClickListener {
            val reviewIntent = Intent(this, ReviewActivity::class.java)
            reviewIntent.putExtra("QUESTION_IDS", questionIds)
            reviewIntent.putExtra("USER_ANSWERS", userAnswers)
            startActivity(reviewIntent)
        }

        val btnHome = findViewById<Button>(R.id.btnHome)
        btnHome.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        val btnTryAgain = findViewById<Button>(R.id.btnTryAgain)
        btnTryAgain.setOnClickListener {
            finish()
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}
