package rubenquadros.com.imageloader.custom

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.ImageView
import rubenquadros.com.imageloader.R
import rubenquadros.com.imageloader.callbacks.Callback
import rubenquadros.com.imageloader.services.BackgroundTask

class ImageLoader(context: Context?, attrs: AttributeSet?, defStyle: Int) : ImageView(context, attrs, defStyle), Callback {

    init {
        init(attrs)
    }

    private var mImageURL: String? = null
    private var mPlaceholder: String? = "applogo"
    private lateinit var mDrawable: Drawable
    private var mBitmap: Bitmap? = null
    private val bitmapResource: Bitmap?
        get() {
            if (mBitmap == null) {
                val drawable = drawable ?: return null

                return if (width == 0 || height == 0) {
                    null
                } else (drawable as BitmapDrawable).bitmap

            } else {
                return mBitmap
            }
        }
    private lateinit var backgroundTask: BackgroundTask

    constructor(context: Context?): this(context, null, 0) {
        ImageView(context)
    }

    constructor(context: Context?, attrs: AttributeSet?): this(context, attrs, 0) {
        ImageView(context, attrs)
    }

    private fun init(set: AttributeSet?) {
        if(set == null){
            return
        }
        val typedArray = context.obtainStyledAttributes(set, R.styleable.ImageLoader)
        mPlaceholder = typedArray.getString(R.styleable.ImageLoader_placeholder)
        mImageURL = typedArray.getString(R.styleable.ImageLoader_imageURL)
        typedArray.recycle()

        try {
            mDrawable = ContextCompat.getDrawable(context, android.R.drawable.progress_indeterminate_horizontal)!!
            setImageDrawable(mDrawable)
        }catch (e: Exception) {
            e.printStackTrace()
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

    override fun taskOnComplete(bitmap: Bitmap?) {
        mBitmap = bitmap
        setupBitmap(mBitmap)
    }

}