package com.annisa.latihan13sept_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.annisa.latihan13sept_kotlin.adapter.PhotoGridAdapter

class GalleryPhotoActivity : AppCompatActivity() {

    // Sample image resource array
    private val imageList = arrayOf(
        R.drawable.pnp,
        R.drawable.pnp3,
        R.drawable.pnp2,
        R.drawable.pnp4,
        R.drawable.pnp6,
        R.drawable.pnp7
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_photo)

        // Set up the GridView for photos
        val gridView = findViewById<GridView>(R.id.gridView)
        val adapter = PhotoGridAdapter(this, imageList)
        gridView.adapter = adapter

        // Set up onClickListener for grid items
        gridView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, PhotoDetailActivity::class.java)
            intent.putExtra("imageResId", imageList[position]) // Pass the selected image ID to detail activity
            startActivity(intent)
        }
    }
}