package com.example.wordle

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val word = findViewById<EditText>(R.id.word)
        val button = findViewById<Button>(R.id.button)

        // First try to guess the word
        val displayWord1 = findViewById<TextView>(R.id.word1)
        val displayResult1 = findViewById<TextView>(R.id.word1Result)

        val guess1 = findViewById<TextView>(R.id.guess1)
        val guess1Check = findViewById<TextView>(R.id.guess1Check)

        // Second try to guess the word
        val displayWord2 = findViewById<TextView>(R.id.word2)
        val displayResult2 = findViewById<TextView>(R.id.word2Result)

        val guess2 = findViewById<TextView>(R.id.guess2)
        val guess2Check = findViewById<TextView>(R.id.guess2Check)

        // Third try to guess the word
        val displayWord3 = findViewById<TextView>(R.id.word3)
        val displayResult3 = findViewById<TextView>(R.id.word3Result)

        val guess3 = findViewById<TextView>(R.id.guess3)
        val guess3Check = findViewById<TextView>(R.id.guess3Check)



        val mainResult = findViewById<TextView>(R.id.mainResult)


        var turn = 1
        val word_guess = FourLetterWordList()
        val randomWord = word_guess.getRandomFourLetterWord()
        var isGameFinished = false

        button.setOnClickListener() {
            val guess = word.text.toString().lowercase()
            val result = checkGuess(guess, randomWord)
            val inputmm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputmm.hideSoftInputFromWindow(word.windowToken, 0)

            if(!isGameFinished){
                if (turn == 1) {
                    guess1.visibility = View.VISIBLE
                    guess1Check.visibility = View.VISIBLE

                    displayWord1.text = guess
                    displayResult1.text = result
                    word.text.clear() // Clear the EditText field

                    turn++
                } else if (turn == 2) {
                    guess2.visibility = View.VISIBLE
                    guess2Check.visibility = View.VISIBLE

                    displayWord2.text = guess
                    displayResult2.text = result
                    word.text.clear() // Clear the EditText field

                    turn++

                } else if (turn == 3) {

                    guess3.visibility = View.VISIBLE
                    guess3Check.visibility = View.VISIBLE

                    displayWord3.text = guess
                    displayResult3.text = result
                    word.text.clear() // Clear the EditText field

                    turn++
                } else if (turn == 4){
                    mainResult.text = randomWord
                    button.text = "Start Over"
                    isGameFinished = true // Mark the game as finished
                }
            }
            else{
                // Reset the game state
                turn = 1
                isGameFinished = false
                button.text = "Submit"
                mainResult.text = ""
                guess1.visibility = View.INVISIBLE
                guess1Check.visibility = View.INVISIBLE
                guess2.visibility = View.INVISIBLE
                guess2Check.visibility = View.INVISIBLE
                guess3.visibility = View.INVISIBLE
                guess3Check.visibility = View.INVISIBLE
                displayWord1.text = ""
                displayWord2.text = ""
                displayWord3.text = ""
                displayResult1.text = ""
                displayResult2.text = ""
                displayResult3.text = ""
                word.text.clear()
            }
        }
    }

    private fun checkGuess(guess: String, wordToGuess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}





