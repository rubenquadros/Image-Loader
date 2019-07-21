package rubenquadros.com.imageloader.custom

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import rubenquadros.com.imageloader.callbacks.Callback
import rubenquadros.com.imageloader.R
import rubenquadros.com.imageloader.services.BackgroundTask

class ImageLoader(context: Context?) : ImageView(context), Callback {

    private var mImageURL: String? = null
    private var mPlaceholder: String? = null
    private lateinit var mDrawable: Drawable
    private var mBitmap: Bitmap? = null
    private lateinit var backgroundTask: BackgroundTask

    constructor(context: Context?, attrs: AttributeSet?): this(context) {
        init(attrs)
    }

    private fun init(set: AttributeSet?) {
        if(set == null){
            return
        }
        val typedArray = context.obtainStyledAttributes(set, R.styleable.ImageLoader)
        mPlaceholder = typedArray.getString(R.styleable.ImageLoader_placeholder)
        mImageURL = typedArray.getString(R.styleable.ImageLoader_imageURL)
        typedArray.recycle()
        if(mPlaceholder != null) {
            try {
                mDrawable = context.resources.getDrawable(
                    resources.getIdentifier(
                        this.mPlaceholder,
                        "drawable",
                        context.packageName
                    )
                )
                setImageDrawable(mDrawable)
            }catch (e: Exception) {

            }
        }
        if(mImageURL != null) {
            getBitmap(mImageURL!!)
        }
    }


    private fun setupBitmap(bitmap: Bitmap?) {
        if(bitmap != null) {
            setImageBitmap(bitmap)
        }
    }

    private fun getBitmap(imgUrl: String) {
        backgroundTask = BackgroundTask()
        backgroundTask.setListener(this)
        backgroundTask.execute(imgUrl)
    }

    fun imageURL(mImgUrl: String?) {
        if(mImgUrl != null) {
            getBitmap(mImgUrl)
        }
    }

    override fun TaskOnComplete(bitmap: Bitmap?) {
        mBitmap = bitmap
        setupBitmap(mBitmap)
    }

}