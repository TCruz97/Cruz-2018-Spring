package com.example.turnercruz.project1

/**
 * Created by turnercruz on 3/8/18.
 */
object ImageManager{
    private var imagesArray:ArrayList<ImageDetail?> = ArrayList(4)
            fun resetImages(){
                imagesArray= ArrayList(4)
                imagesArray.add(null)
                imagesArray.add(null)
                imagesArray.add(null)
                imagesArray.add(null)
            }
        fun imageAtIndex(indexOfImage:Int):ImageDetail?{
            if(imagesArray.size > indexOfImage)
            {
                return imagesArray[indexOfImage]
            }
            return null
        }

    fun saveImage(newImageDetail: ImageDetail,indexOfImage: Int){
        imagesArray.add(newImageDetail)
    }
}