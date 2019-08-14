package rubenquadros.com.imageloader.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import rubenquadros.com.imageloader.R
import rubenquadros.com.imageloader.custom.RecViewAdapter
import rubenquadros.com.imageloader.viewmodel.ImagesActivityViewModel

class ImagesActivity : AppCompatActivity() {

    private lateinit var imagesActivityViewModel: ImagesActivityViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mRecViewAdapter: RecViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imagesActivityViewModel = ViewModelProviders.of(this).get(ImagesActivityViewModel::class.java)
        imagesActivityViewModel.init()
//        imagesActivityViewModel.getImages().observe(this, Observer {
//            mRecViewAdapter.notifyDataSetChanged()
//        })
        initRecyclerView()
    }

    private fun initRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView)
        val layoutManager = GridLayoutManager(this, 2)
        mRecyclerView.layoutManager = layoutManager
        mRecViewAdapter = RecViewAdapter(imagesActivityViewModel.getImages().value!!)
        mRecyclerView.adapter = mRecViewAdapter
    }
}
