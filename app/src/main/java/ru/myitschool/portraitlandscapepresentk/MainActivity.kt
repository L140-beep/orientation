package ru.myitschool.portraitlandscapepresentk

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    var curPicture : Int = -1
    lateinit var pictures : List<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var iv = findViewById<ImageView>(R.id.picture)
        pictures = listOf(R.drawable.car1, R.drawable.car2, R.drawable.car3)

    }

    override fun onSaveInstanceState(outState: Bundle ) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", curPicture)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        var iv = findViewById<ImageView>(R.id.picture)
        curPicture = savedInstanceState.getInt("counter")
        iv.setImageResource(pictures[curPicture % pictures.size])
    }

    fun onChangePictureClick(v: View) {
        var iv = findViewById<ImageView>(R.id.picture)
        curPicture += 1
        iv.setImageResource(pictures[curPicture % pictures.size])
    }
}