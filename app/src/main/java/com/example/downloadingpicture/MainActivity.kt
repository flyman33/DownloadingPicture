package com.example.downloadingpicture

import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import java.net.URLConnection

class MainActivity : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var urlEdit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.picture)
        urlEdit = findViewById(R.id.url)
    }

    fun onDownloadImageClicked(view: View) {
        Glide
            .with(this)
            .load(urlEdit.text.toString())
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Toast.makeText(
                        applicationContext,
                        "There is a problem with downloading image",
                        Toast.LENGTH_SHORT
                    ).show()
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: com.bumptech.glide.load.DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    Toast.makeText(
                        applicationContext,
                        "The image successfully downloaded",
                        Toast.LENGTH_SHORT
                    ).show()
                    return false
                }
            })
            .centerInside()
            .into(image)

        image.visibility = View.VISIBLE
    }
}