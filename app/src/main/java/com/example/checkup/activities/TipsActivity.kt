package com.example.checkup.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.checkup.R
import com.example.checkup.fragments.TipsDetailsFragment
import com.example.checkup.fragments.TipsListFragment
import com.example.checkup.helpers.TIPS_TAG
import com.example.checkup.helpers.showFragment
import com.example.checkup.models.Twin

class TipsActivity : AppCompatActivity() {
    lateinit var tipsList: MutableList<Twin>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips)

        tipsList = mutableListOf()

        createTips(
            resources.getString(R.string.tips_head_6),
            resources.getString(R.string.tips_news_6)
        )
        createTips(
            resources.getString(R.string.tips_head_7),
            resources.getString(R.string.tips_news_7)
        )
        createTips(
            resources.getString(R.string.tips_head_8),
            resources.getString(R.string.tips_news_8)
        )
        createTips(
            resources.getString(R.string.tips_head_1),
            resources.getString(R.string.tips_news_1)
        )
        createTips(
            resources.getString(R.string.tips_head_2),
            resources.getString(R.string.tips_news_2)
        )
        createTips(
            resources.getString(R.string.tips_head_3),
            resources.getString(R.string.tips_news_3)
        )
        createTips(
            resources.getString(R.string.tips_head_4),
            resources.getString(R.string.tips_news_4)
        )
        createTips(
            resources.getString(R.string.tips_head_5),
            resources.getString(R.string.tips_news_5)
        )

        val fragment = TipsListFragment()
        showFragment(this, fragment, R.id.tipsContainer, TIPS_TAG)
    }

    private fun createTips(headline: String, news: String) {
        val twin = Twin()
        twin.propertyString = headline
        twin.valueObject = news
        tipsList.add(twin)
    }

    fun showTips(position: Int) {
        val twin = tipsList[position]

        val fragment = TipsDetailsFragment()
        val bundle = Bundle()
        bundle.putParcelable("twin", twin)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.tipsContainer, fragment, TIPS_TAG)
            .addToBackStack(null).commit()
    }
}
