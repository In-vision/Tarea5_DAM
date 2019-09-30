package iteso.mx.tarea05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import iteso.mx.tarea05.R
import iteso.mx.tarea05.adapters.OnClick
import iteso.mx.tarea05.fragments.FragmentTutorialOne
import iteso.mx.tarea05.fragments.FragmentTutorialThree
import iteso.mx.tarea05.fragments.FragmentTutorialTwo
import org.jetbrains.anko.startActivity

class ActivityTutorial : AppCompatActivity(), OnClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        /* TODO Create three fragments for the tutorial and place them in activity_tutorial_fl_content
        *   First Fragment has a background image and a next button
        *   Second Fragment has a background image a next and previous button
        *   Third Fragment has a background image a finish and a previous button
        *  */

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_tutorial_fl_content,
                FragmentTutorialOne()
            )
            .commit()
    }

    override fun onNext(activityNumber : Int){
        when(activityNumber){
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_tutorial_fl_content,
                        FragmentTutorialTwo()
                    )
                    .addToBackStack(null)
                    .commit()
            }
            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_tutorial_fl_content,
                        FragmentTutorialThree()
                    ).addToBackStack(null)
                    .commit()
            }
            3 -> {
                startActivity<ActivityMain>()
            }
        }
    }

    override fun onPrevious(activityNumber: Int) {
        when(activityNumber){
            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_tutorial_fl_content,
                        FragmentTutorialOne()
                    ).addToBackStack(null)
                    .commit()
            }
            3 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_tutorial_fl_content,
                        FragmentTutorialTwo()
                    ).addToBackStack(null)
                    .commit()
            }
        }
    }
}
