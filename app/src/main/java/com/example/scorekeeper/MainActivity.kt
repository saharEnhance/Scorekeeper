package com.example.scorekeeper


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    // Member variables for holding the score
    private var mScore1 = 0
    private var mScore2 = 0

    // Member variables for the two score TextView elements
    private var mScoreText1: TextView? = null
    private var mScoreText2: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Find the TextViews by ID
        mScoreText1 = findViewById(R.id.score_1)
        mScoreText2 = findViewById(R.id.score_2)

        // Restores the scores if there is savedInstanceState.
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1)
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2)

            //Set the score text views
            mScoreText1!!.text = mScore1.toString()
            mScoreText2!!.text = mScore2.toString()
        }
    }

    fun decreaseScore(view: View) {
        // Get the ID of the button that was clicked.
        val viewID = view.id
        when (viewID) {
            R.id.decreaseTeam1 -> {
                // Decrement the score and update the TextView.
                mScore1--
                mScoreText1!!.text = mScore1.toString()
            }
            R.id.decreaseTeam2 -> {
                // Decrement the score and update the TextView.
                mScore2--
                mScoreText2!!.text = mScore2.toString()
            }
        }
    }

    fun increaseScore(view: View) {
        // Get the ID of the button that was clicked.
        val viewID = view.id
        when (viewID) {
            R.id.increaseTeam1 -> {
                // Increment the score and update the TextView.
                mScore1++
                mScoreText1!!.text = mScore1.toString()
            }
            R.id.increaseTeam2 -> {
                // Increment the score and update the TextView.
                mScore2++
                mScoreText2!!.text = mScore2.toString()
            }
        }
    }
    protected override fun onSaveInstanceState(outState: Bundle) {
        // Save the scores.
        outState.putInt(MainActivity.Companion.STATE_SCORE_1, mScore1)
        outState.putInt(MainActivity.Companion.STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState)
    }


    companion object {
        // Tags to be used as the keys in OnSavedInstanceState
        val STATE_SCORE_1: String? = "Team 1 Score"
        val STATE_SCORE_2: String? = "Team 2 Score"
    }
}