package me.mirkojovanovic.ui.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import me.mirkojovanovic.R
import me.mirkojovanovic.ui.intro.button_fragment.IntroButtonFragment
import me.mirkojovanovic.ui.intro.text_fragment.IntroTextFragment

private const val TAB_COUNT = 4

class IntroActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        viewPager = findViewById(R.id.intro_pager)
        tabLayout = findViewById(R.id.intro_tabs)

        init()
        setTabIndicatorMargins()
    }

    private fun init() {
        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when(position) {
                    0 -> {
                        IntroTextFragment.newInstance(
                            getString(R.string.step_one_fragment_headline),
                            getString(R.string.step_one_fragment_description)
                        )
                    }
                    1 -> {
                        IntroTextFragment.newInstance(
                            getString(R.string.step_two_fragment_headline),
                            getString(R.string.step_two_fragment_description)
                        )
                    }
                    2 -> {
                        IntroTextFragment.newInstance(
                            getString(R.string.step_three_fragment_headline),
                            getString(R.string.step_three_fragment_description)
                        )
                    }
                    3 -> {
                        IntroButtonFragment.newInstance(
                            getString(R.string.email_signup_button_text),
                            getString(R.string.facebook_signup_button_text)
                        )
                    }
                    else -> Fragment()
                }
            }

            override fun getItemCount(): Int {
                return TAB_COUNT
            }
        }

        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()
    }

    private fun setTabIndicatorMargins() {
        for (i in 0 until tabLayout.tabCount) {
            val tab = (tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(10, 0, 10, 0)
            tab.requestLayout()
        }
    }
}
