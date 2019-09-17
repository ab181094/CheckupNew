package com.example.checkup.helpers

import android.content.Context
import android.graphics.Bitmap
import android.text.TextUtils
import android.util.LruCache
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyLog.TAG
import com.android.volley.toolbox.*
import java.io.File

class APISingleton constructor(context: Context) {
    companion object {
        val file = File("")
        val cache = DiskBasedCache(file, 1024 * 1024)
        val network = BasicNetwork(HurlStack())

        @Volatile
        private var INSTANCE: APISingleton? = null

        fun getInstance(context: Context) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: APISingleton(context).also {
                    INSTANCE = it
                }
            }
    }

    val imageLoader: ImageLoader by lazy {
        ImageLoader(requestQueue,
            object : ImageLoader.ImageCache {
                private val cache = LruCache<String, Bitmap>(20)
                override fun getBitmap(url: String): Bitmap {
                    return cache.get(url)
                }

                override fun putBitmap(url: String, bitmap: Bitmap) {
                    cache.put(url, bitmap)
                }
            })
    }

    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        req.setShouldCache(true)
        requestQueue.add(req)
    }

    fun <T> addToRequestQueue(request: Request<T>, tag: String) {
        request.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        request.setShouldCache(true)
        requestQueue.add(request)
    }

    fun cancelPendingRequests(tag: Any) {
        requestQueue.cancelAll(tag)
    }
}