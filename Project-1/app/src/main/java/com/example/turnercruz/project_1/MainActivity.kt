package com.example.turnercruz.project_1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.widget.ImageButton
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val cameraButton1: ImageView = findViewById(R.id.image1)
        val cameraButton2: ImageView = findViewById(R.id.image2)
        val cameraButton3: ImageView = findViewById(R.id.image3)
        val cameraButton4: ImageView = findViewById(R.id.image4)
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
        cameraButton1.setOnClickListener {

            launchPhotoManager()
        }

        cameraButton2.setOnClickListener {

            launchPhotoManager()
        }
        cameraButton3.setOnClickListener {

            launchPhotoManager()
        }
        cameraButton4.setOnClickListener {

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
        val intent = Intent(this, PhotoManager::class.java)
        startActivityForResult(
                intent,
                9090
        )

    }


    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 9090) {

            if (data != null) {

//                val imageData: Bitmap = data.extras.get("data") as Bitmap
//
//                val imageView: ImageButton = findViewById(R.id.image1)
//                imageView.setImageBitmap(imageData)
                val bitmap = intent.getParcelableExtra("data") as Bitmap
                image1.setImageBitmap(bitmap)
            }
        }
    }
}
//
//        if( requestCode == 9091){
//
//            if( data != null ) {
//                val imageData: Bitmap = data.extras.get("data") as Bitmap
//
//                val imageView2 = findViewById<ImageView>(R.id.image)
//                imageView2.setImageBitmap(imageData)
//
//            }
//        }
//        if( requestCode == 9092){
//
//            if( data != null ) {
//                val imageData: Bitmap = data.extras.get("data") as Bitmap
//
//                val imageView3 = findViewById<ImageView>(R.id.image)
//                imageView3.setImageBitmap(imageData)
//
//            }
//        }
//        if( requestCode == 9093){
//
//            if( data != null ) {
//                val imageData: Bitmap = data.extras.get("data") as Bitmap
//
//                val imageView4 = findViewById<ImageView>(R.id.image)
//                imageView4.setImageBitmap(imageData)
//
//            }
//  }
       



