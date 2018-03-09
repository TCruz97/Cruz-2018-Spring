package com.example.turnercruz.project1

import android.graphics.Bitmap


/**
 * Created by turnercruz on 3/8/18.
 */
data class ImageDetail(var ImageID:Int = 0,
                       var image:Bitmap?= null,
                       var imageTitle:String?= null,
//                       var imageDate:Date? = null,
                       var imageDescription: String?=null){

}