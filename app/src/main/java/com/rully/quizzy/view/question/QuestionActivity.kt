package com.rully.quizzy.view.question

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.rully.quizzy.R
import com.rully.quizzy.data.Constants
import com.rully.quizzy.data.Question
import com.rully.quizzy.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityQuestionBinding
    private var mCurrentPosition = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mQuestionList = Constants.getQuestions()
        setQuestions()

        binding.tvOption1.setOnClickListener(this)
        binding.tvOption2.setOnClickListener(this)
        binding.tvOption3.setOnClickListener(this)
        binding.tvOption4.setOnClickListener(this)

    }

    private fun setQuestions() {
        mCurrentPosition = 1
        val question = mQuestionList?.get(mCurrentPosition - 1)

        binding.progressBar.progress = mCurrentPosition
        binding.tvProgressBar.text = "$mCurrentPosition" + "/" + binding.progressBar.max

        binding.tvQuestion.text = question?.question
        question?.image?.let { binding.ivQuestion.setImageResource(it) }
        binding.tvOption1.text = question?.option1
        binding.tvOption2.text = question?.option2
        binding.tvOption3.text = question?.option3
        binding.tvOption4.text = question?.option4

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tvOption1 -> {
                selectedOptions(binding.tvOption1, 1)
            }
            R.id.tvOption2 -> {
                selectedOptions(binding.tvOption2, 2)
            }
            R.id.tvOption3 -> {
                selectedOptions(binding.tvOption3, 3)
            }
            R.id.tvOption4 -> {
                selectedOptions(binding.tvOption4, 4)
            }
        }
    }

    private fun selectedOptions(textView: TextView, selected: Int) {
        defaultOptions()
        mSelectedPosition = selected
        textView.setTextColor(Color.parseColor("#363a43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)

    }

    private fun defaultOptions() {
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOption1)
        options.add(1, binding.tvOption2)
        options.add(2, binding.tvOption3)
        options.add(3, binding.tvOption4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.option_bg)
        }
    }

}