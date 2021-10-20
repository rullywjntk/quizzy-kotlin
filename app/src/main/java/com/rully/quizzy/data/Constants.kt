package com.rully.quizzy.data

import com.rully.quizzy.R

object Constants {

    const val USER: String = "user"
    const val TOTAL_QUESTION: String = "total_question"
    const val CORRECT_ANSWER: String = "correct_answer"

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        val question1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.argentina_flag,
            "Argentina",
            "Singapore",
            "Brazil",
            "England",
            1
        )
        questionList.add(question1)

        val question2 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.argentina_flag,
            "Argentina",
            "Singapore",
            "Brazil",
            "England",
            1
        )
        questionList.add(question2)

        return questionList
    }
}