package rubenquadros.com.imageloader.callbacks

import android.graphics.Bitmap

interface Callback {

    fun TaskOnComplete(bitmap: Bitmap?)
}