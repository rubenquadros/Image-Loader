package rubenquadros.com.imageloader.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import rubenquadros.com.imageloader.model.Images
import rubenquadros.com.imageloader.repository.ImagesRepo

class ImagesActivityViewModel: ViewModel() {

    private lateinit var mImages: MutableLiveData<ArrayList<Images>>
    private lateinit var mRepo: ImagesRepo

    fun getImages() : LiveData<ArrayList<Images>> {
        return mImages
    }

    fun init() {
        mRepo = ImagesRepo().getInstance()
        mImages = mRepo.getImages()
    }

}