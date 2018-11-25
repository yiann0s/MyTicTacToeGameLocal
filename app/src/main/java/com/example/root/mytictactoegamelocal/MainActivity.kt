package com.example.root.mytictactoegamelocal

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun butClick(view: View){
        val butSelected = view as Button
        var cellId = 0
        when (butSelected.id){
            R.id.but1->cellId=1;
            R.id.but2->cellId=2;
            R.id.but3->cellId=3;
            R.id.but4->cellId=4;
            R.id.but5->cellId=5;
            R.id.but6->cellId=6;
            R.id.but7->cellId=7;
            R.id.but8->cellId=8;
            R.id.but9->cellId=9;
        }
        Toast.makeText(this,"ID:"+cellId,Toast.LENGTH_SHORT).show()
        playGame(cellId,butSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer=1

    fun playGame(cellId:Int, butSelected:Button){

        if (activePlayer==1){
            butSelected.text="X"
            butSelected.setBackgroundResource(R.color.anotherBlue)
            player1.add(cellId)
            activePlayer=2
            autoPlay()
        }else{
            butSelected.text="O"
            butSelected.setBackgroundResource(R.color.golden)
            player2.add(cellId)
            activePlayer=1
        }


        butSelected.isEnabled=false
        checkForAWinner(butSelected)
    }

    fun checkForAWinner(but:Button){
        var winner=-1
        //row 1
        if (player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winner = 1
        }
        if (player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner = 2
        }
        //row 2
        if (player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winner = 1
        }
        if (player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winner = 2
        }
        //row 3
        if (player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winner = 1
        }
        if (player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner = 2
        }
        //column 1
        if (player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winner = 1
        }
        if (player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner = 2
        }
        //column 2
        if (player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winner = 1
        }
        if (player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner = 2
        }
        //column 3
        if (player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winner = 1
        }
        if (player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner = 2
        }
        if (winner !=-1){
            if (winner == 1) {
                Toast.makeText(this,"Player " + winner + " is the winner!",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Player " + winner + " is the winner!",Toast.LENGTH_SHORT).show()
            }
            but.isClickable = false
        }

    }

    fun autoPlay(){
        var emptyCells=ArrayList<Int>()
        for (cellId in 1..9){
            if (!(player1.contains(cellId)||(player2.contains(cellId)))){
                emptyCells.add(cellId)
            }
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCells.size-0)+0

        val cellId = emptyCells[randIndex]

        var butSelect:Button?
        when(cellId){
            1->butSelect=but1
            2->butSelect=but2
            3->butSelect=but3
            4->butSelect=but4
            5->butSelect=but5
            6->butSelect=but6
            7->butSelect=but7
            8->butSelect=but8
            9->butSelect=but9
            else->{
                butSelect=but1
            }
        }

        playGame(cellId,butSelect)
    }
}
