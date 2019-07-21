package rubenquadros.com.imageloader.services

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import rubenquadros.com.imageloader.callbacks.Callback
import java.io.InputStream
import java.lang.Exception
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class BackgroundTask: AsyncTask<String, Void, Bitmap>() {

    private var bitmap: Bitmap? = null
    private lateinit var mListener: Callback
    private lateinit var connection: HttpsURLConnection

    override fun doInBackground(vararg params: String?): Bitmap? {

        val url = URL(params[0])
        return try {
            connection = url.openConnection() as HttpsURLConnection
            connection.doInput = true
            connection.doOutput = false
            connection.connect()
            val inputStream = connection.inputStream
            bitmap = BitmapFactory.decodeStream(inputStream)
            bitmap
        }catch (e: Exception) {
            null
        }
    }

    override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)
        mListener.TaskOnComplete(bitmap)
    }

    fun setListener(listener: Callback) {
        mListener = listener
    }

    fun closeConnection (url: String) {
        val mURL = URL(url)
        //connection =

    }
}