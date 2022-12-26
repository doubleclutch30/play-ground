package com.todak.playground.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private var score = 0
    private var currentWordCount = 0
    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord
    private var wordList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()
        Log.d("test33", "tempword: $tempWord")
        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
    }

}