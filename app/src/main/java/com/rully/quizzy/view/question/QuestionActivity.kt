package com.rully.quizzy.view.question

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rully.quizzy.data.Constants
import com.rully.quizzy.data.Question
import com.rully.quizzy.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val questionList = Constants.getQuestions()
        val currentPosition = 1
        val question: Question = questionList[currentPosition - 1]

        binding.progressBar.progress = currentPosition
        binding.tvProgressBar.text = "$currentPosition" + "/" + binding.progressBar.max

        binding.tvQuestion.text = question.question
        binding.ivQuestion.setImageResource(question.image)
        binding.tvOption1.text = question.option1
        binding.tvOption2.text = question.option2
        binding.tvOption3.text = question.option3
        binding.tvOption4.text = question.option4

    }
}