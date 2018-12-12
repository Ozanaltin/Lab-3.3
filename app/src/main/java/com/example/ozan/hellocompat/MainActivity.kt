package com.example.ozan.hellocompat

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


class MainActivity : AppCompatActivity() {
    inner class MainActivity : AppCompatActivity() {
        private var mHelloTextView: TextView? = null
        private val mColorArray = arrayOf(
            "red",
            "pink",
            "purple",
            "deep_purple",
            "indigo",
            "blue",
            "light_blue",
            "cyan",
            "teal",
            "green",
            "light_green",
            "lime",
            "yellow",
            "amber",
            "orange",
            "deep_orange",
            "brown",
            "grey",
            "blue_grey",
            "black"
        )


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            mHelloTextView = findViewById(R.id.hello_textview)

            if (savedInstanceState != null) {
                mHelloTextView!!.setTextColor(savedInstanceState.getInt("color"))
            }
        }
        public override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)

            outState.putInt("color", mHelloTextView!!.currentTextColor)
        }

        /**
         * Handles the click of the Change Color button by
         * picking a random color from a color array.
         *
         * @param view The view that was clicked.
         */
        fun changeColor(view: View) {

            val random = Random()
            val colorName = mColorArray[random.nextInt(20)]
            val colorResourceName = resources.getIdentifier(
                colorName,
                "color", applicationContext.packageName
            )
            val colorRes = ContextCompat.getColor(this, colorResourceName)
            mHelloTextView!!.setTextColor(colorRes)
        }
    }
}