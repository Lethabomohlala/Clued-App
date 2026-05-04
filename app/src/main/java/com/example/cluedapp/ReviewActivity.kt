package com.example.cluedapp

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val questionIds = intent.getIntArrayExtra("QUESTION_IDS") ?: intArrayOf()
        val userAnswers = intent.getBooleanArrayExtra("USER_ANSWERS") ?: booleanArrayOf()

        val questionsContainer = findViewById<LinearLayout>(R.id.questionsContainer)
        questionsContainer.removeAllViews()

        val allQuestions = QuizRepository.getQuestions()

        for (i in questionIds.indices) {
            val qId = questionIds[i]
            val userAnswer = userAnswers[i]
            val question = allQuestions.find { it.id == qId }

            if (question != null) {
                addQuestionToReview(questionsContainer, i + 1, question, userAnswer)
            }
        }

        findViewById<Button>(R.id.btnBackToResults).setOnClickListener {
            finish()
        }
    }

    private fun addQuestionToReview(container: LinearLayout, index: Int, question: Question, userAnswer: Boolean) {
        val view = LayoutInflater.from(this).inflate(R.layout.item_review_question, container, false)

        val tvQuestionNum = view.findViewById<TextView>(R.id.tvQuestionNum)
        val tvUserAnswer = view.findViewById<TextView>(R.id.tvUserAnswer)
        val tvCorrectAnswer = view.findViewById<TextView>(R.id.tvCorrectAnswer)
        val tvExplanation = view.findViewById<TextView>(R.id.tvExplanation)

        tvQuestionNum.text = getString(R.string.question_number_format, index)
        tvUserAnswer.text = if (userAnswer) getString(R.string.txt_true) else getString(R.string.txt_false)
        tvCorrectAnswer.text = if (question.isTrue) getString(R.string.txt_true) else getString(R.string.txt_false)
        tvExplanation.text = getString(R.string.explanation_prefix) + question.explanation

        container.addView(view)
    }
}
