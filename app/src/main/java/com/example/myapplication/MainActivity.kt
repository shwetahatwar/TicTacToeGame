package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View) {

        val buSelected: Button = view as Button
        var cellId = 0
        when (buSelected.id) {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }
        Log.d("buClick:", buSelected.id.toString())
        Log.d("buClick:cellId", cellId.toString())
        playGame(cellId, buSelected)

    }

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    @SuppressLint("ResourceAsColor")
    fun playGame(cellId: Int, buSelected: Button) {

        if (activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundResource(R.color.parrot)
            player1.add(cellId)
            activePlayer = 2
        } else {
            buSelected.text = "O"
            buSelected.setBackgroundResource(R.color.red)
            player2.add(cellId)
            activePlayer = 1
        }

        buSelected.isEnabled = false
        checkWinner()

    }

    fun checkWinner() {
        var winner = -1

        //row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 1
        }
        //row2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 1
        }
        //row3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 1
        }
        //col1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 1
        }
        //col2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 1
        }
        //col3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 1
        }
        if (winner == 1) {
            player1WinsCount += 1
            Toast.makeText(this, "player 1 win the game", Toast.LENGTH_LONG).show()
            restartGame()
        } else if (winner == 2) {
            player2WinsCount += 1
            Toast.makeText(this, "player 2 win the game", Toast.LENGTH_LONG).show()
            restartGame()
        }

//        fun autoPlay(){
//            var emptyCells = ArrayList<Int>()
//            for (cellId:Int in 1..9){
//                if (player1.contains(cellId) || player2.contains(cellId))
//                    emptyCells.add(cellId)
//            }
//        }
//        if (emptyCells.size == 0){
//            restartGame()
//        }
//        var emptyCells = ArrayList<Int>()
//        val r = Random()
//        val randIndex = r.nextInt(emptyCells.size)
//        val cellId = emptyCells[randIndex]
//
//        var buSelected:Button?
//        buSelected = when(cellId){
//
//            1-> button1
//            2-> button2
//            3-> button3
//            4-> button4
//            5-> button5
//            6-> button6
//            7-> button7
//            8-> button8
//            9-> button9
//            else -> {button1}
//        }
//        playGame(cellId,buSelected)
    }

    var player1WinsCount = 0
    var player2WinsCount = 0

    fun restartGame() {
        activePlayer = 1
        player1.clear()
        player2.clear()

        for (cellId in 1..9) {
            var buSelected: Button? = when (cellId) {

                1 -> button1
                2 -> button2
                3 -> button3
                4 -> button4
                5 -> button5
                6 -> button6
                7 -> button7
                8 -> button8
                9 -> button9
                else -> {
                    button1
                }
            }
            buSelected!!.text = ""
            buSelected!!.setBackgroundResource(R.color.yellow)
            buSelected!!.isEnabled = true
        }
        Toast.makeText(this,"player1: $player1WinsCount, player2:$player2WinsCount",Toast.LENGTH_LONG).show()
    }
}
