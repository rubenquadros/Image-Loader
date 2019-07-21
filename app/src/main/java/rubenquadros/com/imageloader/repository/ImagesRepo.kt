package rubenquadros.com.imageloader.repository

import android.arch.lifecycle.MutableLiveData
import rubenquadros.com.imageloader.model.Images

class ImagesRepo {

    private lateinit var instance: ImagesRepo
    private var dataSet: ArrayList<Images> = ArrayList()

    fun getInstance(): ImagesRepo {
        synchronized(this) {
            instance = ImagesRepo()
        }
        return instance
    }

    fun getImages(): MutableLiveData<ArrayList<Images>> {
        setImages()
        val data: MutableLiveData<ArrayList<Images>> = MutableLiveData()
        data.value = dataSet
        return data
    }

    private fun setImages() {
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
        dataSet.add(Images("https://www.gstatic.com/webp/gallery/4.sm.jpg"))
    }

}