package com.example.cluedapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {

    private lateinit var txtQuestion: TextView
    private lateinit var txtProgress: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var btnHack: Button
    private lateinit var btnMyth: Button

    private var questions = listOf<Question>()
    private var currentIndex = 0
    private var score = 0
    private var currentCategory = "Health"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        txtQuestion = findViewById(R.id.txtQuestion)
        txtProgress = findViewById(R.id.txtProgress)
        progressBar = findViewById(R.id.progressBar)
        btnHack = findViewById(R.id.btnHack)
        btnMyth = findViewById(R.id.btnMyth)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.quiz)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val selectedTopic = intent.getStringExtra("SELECTED_TOPIC") ?: ""
        currentCategory = when (selectedTopic) {
            "HOUSEHOLD & CLEANING" -> "Cleaning"
            "HEALTH & WELLNESS" -> "Health"
            "PRODUCTIVITY" -> "Productivity"
            else -> "Health"
        }

        questions = QuizRepository.getQuestions()
            .filter { it.category == currentCategory }
            .shuffled()
            .take(10)

        progressBar.max = questions.size

        loadQuestion()

        btnHack.setOnClickListener {
            checkAnswer(true)
        }

        btnMyth.setOnClickListener {
            checkAnswer(false)
        }
    }

    private fun loadQuestion() {
        if (currentIndex < questions.size) {
            val question = questions[currentIndex]
            txtQuestion.text = question.text
            txtProgress.text = getString(R.string.question_progress_format, currentIndex + 1, questions.size)
            progressBar.progress = currentIndex + 1
        } else {
            showResult()
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (currentIndex >= questions.size) return

        val correctAnswer = questions[currentIndex].isTrue

        if (userAnswer == correctAnswer) {
            score += 10
            Toast.makeText(this, "Correct! You're clued in.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Wrong! Missed some clues.", Toast.LENGTH_SHORT).show()
        }

        currentIndex++
        loadQuestion()
    }

    private fun showResult() {
        val intent = Intent(this, ResultsActivity::class.java)
        intent.putExtra("SCORE", score)
        intent.putExtra("TOTAL", questions.size)
        startActivity(intent)
        finish() // Finish QuizActivity so the user can't go back to the quiz
    }
}
