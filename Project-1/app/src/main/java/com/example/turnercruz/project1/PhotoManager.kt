package com.example.turnercruz.project1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_photo_manager.*
//import android.support.test.espresso.core.internal.deps.guava.io.ByteStreams.toByteArray




class PhotoManager : AppCompatActivity() {
    private var imageData:Bitmap?=null
   // private  var imageDetails:ImageDetail?=null

    companion object {
        const val EXTRA_IMAGE_INDEX_KEY:String="EXTRA_IMAGE-INDEX_KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_manager)


        val image:ImageView = findViewById(R.id.image)
        val edit: Button = findViewById(R.id.editButton)

        val imageIndex:Int = intent.getIntExtra(EXTRA_IMAGE_INDEX_KEY, -1)





        edit.setOnClickListener {

            val cameraCheckPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)

            if (cameraCheckPermission != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
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
            } else {

                launchCamera(R.id.image)


            }


        }

    }
    private fun createImageDetail(){

    }
    private fun requestPermission(){
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 765)

    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        for ((index, permission) in permissions.withIndex()){
            if( permission == Manifest.permission.CAMERA){
                if( grantResults[index] == PackageManager.PERMISSION_GRANTED){
                  MediaStore.ACTION_IMAGE_CAPTURE
                }
            }
        }


    }

    private fun launchCamera(id: Int){

        if (id==R.id.image){
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent , 9090)
        }


    }

  public  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if( requestCode == 9090){

            if( data != null ) {
                val imageView = findViewById<ImageView>(R.id.image)
                val imageData: Bitmap = data.extras.get("data") as Bitmap

                imageView.setImageBitmap(imageData)
                  intent = Intent(this, MainActivity::class.java)

                intent.putExtra("data", imageData)
                startActivity(intent)

            }
        }

    }
}


