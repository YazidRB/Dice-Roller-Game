package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button2)
        rollButton.setOnClickListener { rollDice() }

        //Do a dice roll when the app Start to initialise the Dices
        rollDice()
    }

    /**
     *Roll the dice and update the screen with the result.
     **/
    private fun rollDice() {
        // Create two new Dice object with 6 sides and roll them
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()

        // Find the ImageViews in the Layout and put them in two variables (1 & 2)
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        //  Determine which drawable resource ID to use based on the dice roll and put the result in the drawableResource variable.
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //  Determine which drawble resource ID to use based on the dice roll and put the result in the drawableResource2 variable.
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageViews with the correct drawable resources ID
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)

        when(diceRoll){
            6 ->{ if(diceRoll2 == 6) { Toast.makeText(this, "You Win man ! and got : ${diceRoll} and ${diceRoll2} ! Good Job :) " , Toast.LENGTH_SHORT).show() }
            else {  Toast.makeText(this, "Damn! you got : ${diceRoll} and ${diceRoll2} ! Try Again :) ?  " , Toast.LENGTH_SHORT).show() }
            }
            else -> Toast.makeText(this, "Damn! you got : ${diceRoll} and ${diceRoll2} ! Try Again :) ?  " , Toast.LENGTH_SHORT).show()
        }

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()
    }
}

// the Dice Class generate an Dice objects with sides based on the numSides.
class Dice(private val numSides: Int) {
    // roll function return a random number
    fun roll(): Int {
        return(1..numSides).random()
    }
}