package com.example.turnercruz.project1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.data
import android.graphics.BitmapFactory
import android.media.Image
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_photo_manager.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val image1:ImageView = findViewById(R.id.image1)
        val image2: ImageView = findViewById(R.id.image2)
        val image3: ImageView = findViewById(R.id.image3)
        val image4: ImageView = findViewById(R.id.image4)
        val cameraCheckPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)

        if (cameraCheckPermission != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA) == true) {
                val builder = AlertDialog.Builder(this)

                builder.setMessage("I need to see you to work properly!!")
                        .setTitle("Permission required")
                        .setPositiveButton("OK") { dialog, id ->
                            requestPermission()
                        }
                val dialog = builder.create()
                dialog.show()

            } else {
                requestPermission()

            }

        }


        image1.setOnClickListener {

            launchPhotoManager()

        }

        image2.setOnClickListener {

            launchPhotoManager()
        }
        image3.setOnClickListener {

            launchPhotoManager()
        }
        image4.setOnClickListener {

            launchPhotoManager()
        }
    }


    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 765)

    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        for ((index, permission) in permissions.withIndex()) {
            if (permission == Manifest.permission.CAMERA) {
                if (grantResults[index] == PackageManager.PERMISSION_GRANTED) {
                    launchPhotoManager()
                }
            }
        }


    }


    private fun launchPhotoManager() {
        val photoManagerIntent = Intent(this, PhotoManager::class.java)
        startActivityForResult(
                photoManagerIntent, 9090)

        onPause()

    }


    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 9090) {

            if (data != null) {
                onResume()

//               intent.getBundleExtra("data")
//                val bitmap = intent.getParcelableExtra<Bitmap>("data")
                val imageView1:ImageView =findViewById(R.id.image)






                val bitmap1 = intent.getParcelableExtra("data") as Bitmap
                imageView1.setImageBitmap(bitmap1)
//                val imageData: Bitmap = data.extras.get("data") as Bitmap
//
//                val imageView: ImageButton = findViewById(R.id.image1)
//                imageView.setImageBitmap(imageData)
//                val bitmap = intent.getParcelableExtra("data") as Bitmap
//                image1.setImageBitmap(bitmap)


            }
        }
    }
}

       



