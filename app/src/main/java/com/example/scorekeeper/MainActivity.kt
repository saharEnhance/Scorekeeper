package com.example.scorekeeper


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


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

    /**
     * Handles the onClick of both the decrement buttons.
     *
     * @param view The button view that was clicked
     */
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

    /**
     * Handles the onClick of both the increment buttons.
     *
     * @param view The button view that was clicked
     */
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        // Change the label of the menu based on the state of the app.
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            if (menu != null) {
                menu.findItem(R.id.night_mode).setTitle(R.string.day_mode)
            }
        } else {
            if (menu != null) {
                menu.findItem(R.id.night_mode).setTitle(R.string.night_mode)
            }
        }
        return true
    }



    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Check if the correct item was clicked.
        if (item!!.getItemId() == R.id.night_mode) {
            // Get the night mode state of the app.
            val nightMode = AppCompatDelegate.getDefaultNightMode()
            // Set the theme mode for the restarted activity.
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            // Recreate the activity for the theme change to take effect.
            recreate()
        }
        return true
    }

    /**
     * Method that is called when the configuration changes,
     * used to preserve the state of the app.
     *
     * @param outState The bundle that will be passed in to the Activity when it is restored.
     */
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