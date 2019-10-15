package demo.wj.praticedraw6

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import demo.wj.practicedraw6.PageModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 作者 ：wangJiang
 * 时间 ：2019/10/15
 * 描述 ：
 */
class MainActivity : AppCompatActivity() {

    var pageModels: MutableList<PageModel> = arrayListOf(
        PageModel(
            R.layout.sample_translation,
            R.string.title_translation,
            R.layout.practice_translation
        ),
        PageModel(R.layout.sample_rotation, R.string.title_rotation, R.layout.practice_rotation),
        PageModel(R.layout.sample_scale, R.string.title_scale, R.layout.practice_scale),
        PageModel(R.layout.sample_alpha, R.string.title_alpha, R.layout.practice_alpha),
        PageModel(
            R.layout.sample_multi_properties,
            R.string.title_multi_properties,
            R.layout.practice_multi_properties
        ),
        PageModel(R.layout.sample_duration, R.string.title_duration, R.layout.practice_duration),
        PageModel(
            R.layout.sample_interpolator,
            R.string.title_interpolator,
            R.layout.practice_interpolator
        ),
        PageModel(
            R.layout.sample_object_anomator,
            R.string.title_object_animator,
            R.layout.practice_object_animator
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewpager.setAdapter(object : FragmentPagerAdapter(supportFragmentManager) {

            override fun getItem(position: Int): Fragment {
                val pageModel = pageModels.get(position)
                return PageFragment.newInstance(
                    pageModel.sampleLayoutRes,
                    pageModel.practiceLayoutRes
                )
            }

            override fun getCount(): Int {
                return pageModels.size
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return getString(pageModels[position].titleRea)
            }
        })
        tablayout.setupWithViewPager(viewpager)
    }

}