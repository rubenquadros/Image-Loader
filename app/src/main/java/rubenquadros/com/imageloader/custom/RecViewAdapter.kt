package rubenquadros.com.imageloader.custom

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.image_layout.view.*
import rubenquadros.com.imageloader.R
import rubenquadros.com.imageloader.model.Images

class RecViewAdapter(private val imagesList: ArrayList<Images>) : RecyclerView.Adapter<RecViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.image_layout, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.mImageView?.imageURL(imagesList[p1].toString())
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImageView: ImageLoader? = itemView.findViewById(R.id.my_image_view)
    }
}
