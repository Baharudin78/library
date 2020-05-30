package com.baharudin.library.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.baharudin.library.Adapter.IntroSliderAdapter
import com.baharudin.library.Model.IntroSlider
import com.baharudin.library.R
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {

    private val introSliderAdapter =
        IntroSliderAdapter(
            listOf(
                IntroSlider(
                    "Membaca",
                    "Luaskan pengetahuanmu dengan membaca",
                    R.drawable.ic_undraw_reading_time_gvg0
                ),
                IntroSlider(
                    "Mobile",
                    "Kini telah bisa diakses di smartphone",
                    R.drawable.ic_undraw_nature_on_screen_xkli
                ),
                IntroSlider(
                    "At Home",
                    "membuatmu produktif di rumah",
                    R.drawable.ic_undraw_at_home_octe
                )
            )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        view_pager.adapter = introSliderAdapter
        setupIndicators()
        setCurrentIndicator(0)
        view_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
    button_pager.setOnClickListener {
        if (view_pager.currentItem + 1 < introSliderAdapter.itemCount){
            view_pager.currentItem += 1
        }
        else{
            Intent(applicationContext, GetStartedActivity::class.java).also {
                startActivity(it)
            }
        }
    }
    }
    private fun setupIndicators(){
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParam : LinearLayout.LayoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParam.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.shape_indicator_inactive
                    )
                )
                this?.layoutParams = layoutParam
            }
            indicatorSlider.addView(indicators[i])
        }
    }
    private fun setCurrentIndicator(index :Int){
        val childCount = indicatorSlider.childCount
        for (i in 0 until childCount){
            val imageView = indicatorSlider[i] as ImageView
            if (i == index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.shape_indicator_active
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.shape_indicator_inactive
                    )
                )
            }
        }

    }

}
