package com.example.grades

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grades.data.ComputeCie
import com.example.grades.data.MarksViewModel
import com.example.grades.data.getGPoint
import com.example.grades.data.test2Adapter
import com.example.grades.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var mMarksViewModel: MarksViewModel

    private lateinit var binding: ActivityMainBinding
    private var getCieMarks = emptyList<ComputeCie>()
    private var getGpaMarks = emptyList<getGPoint>()
    private var nightYes: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adjustFontScale(getResources().getConfiguration())
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val isFirstRun: Boolean = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true)

        if(isFirstRun) {
            val intent = Intent(this, GetStarted::class.java)
            startActivity(intent)
            finish()
        }

        val cal = Calendar.getInstance()
        val hours = cal.get(Calendar.HOUR_OF_DAY)
        val window: Window = getWindow()
        val view = getWindow().decorView
        var firstClick: Boolean = true
        //var getCieMarks = emptyList<ComputeCie>()

        val quotes = listOf<String>(
            "\"Knowledge leads to unity, ignorance leads to diversity\" - Debraj Roy",
            "\"You need x more marks to clear this subject. Do your best!\" - Hemanth",
            "\"Belief creates the actual fact.\" - Ankith B Shetty",
            "“Keep your face to the sunshine and you cannot see a shadow.” – Helen Keller",
            "“You must be the change you wish to see in the world.” – Mahatma Gandhi",
            "“Stay hungry. Stay foolish.” – Steve Jobs",
            "“Life is like riding a bicycle. To keep your balance, you must keep moving.” – Albert Einstein",
            "“Turn your wounds into wisdom.” – Oprah Winfrey",
            "\"Curiosity is the pillar of humankind\" - Chiranth",
            "\"There's nothing more beautiful than being kind, Dogs before dudes\" - Bhagyashree N M",
            "“If I cannot do great things, I can do small things in a great way.” – Martin Luther King Jr.",
            "“No one is useless in this world who lightens the burdens of others.” – Charles Dickens",
            "“No greater gift there is, than a generous heart.” – Yoda",
            "“You can’t cross the sea merely by standing and staring at the water.” – Rabindranath Tagore",
            "\"people with whom u interact  are the reflection of your(self) personality\" - Anagha Mohan"
        )

        when (this.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {nightYes=true}
            Configuration.UI_MODE_NIGHT_NO -> {nightYes=false}
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {}
        }


        binding.greeting.setOnClickListener {
            Toast.makeText(this, quotes.shuffled().random().toString(), Toast.LENGTH_SHORT).show()
        }

        if(nightYes){
            binding.test1RelativeLayout.setBackgroundResource(R.drawable.round_corner)
            binding.test2RelativeLayout.setBackgroundResource(R.drawable.round_corner)
            binding.assignmentRelativeLayout.setBackgroundResource(R.drawable.round_corner)
            binding.labRelativeLayout.setBackgroundResource(R.drawable.round_corner)
            binding.seeRelativeLayout.setBackgroundResource(R.drawable.round_corner)
        }else{
            binding.test1RelativeLayout.setBackgroundResource(R.drawable.round_corner_black)
            binding.test2RelativeLayout.setBackgroundResource(R.drawable.round_corner_black)
            binding.assignmentRelativeLayout.setBackgroundResource(R.drawable.round_corner_black)
            binding.labRelativeLayout.setBackgroundResource(R.drawable.round_corner_black)
            binding.seeRelativeLayout.setBackgroundResource(R.drawable.round_corner_black)
        }

        if(hours in 5..11){
            binding.greeting.text = "Good Morning"
            binding.greeting.setTextColor(Color.parseColor("#f19f21"))
            binding.test1.setTextColor(Color.parseColor("#f19f21"))
            binding.subjectsShow.setTextColor(Color.parseColor("#f19f21"))
            binding.subjectsShowTest2.setTextColor(Color.parseColor("#f19f21"))
            binding.subjectsShowLab.setTextColor(Color.parseColor("#f19f21"))
            binding.marksShowLab.setTextColor(Color.parseColor("#f19f21"))
            binding.marksShowTest1.setTextColor(Color.parseColor("#f19f21"))
            binding.marksShowTest2.setTextColor(Color.parseColor("#f19f21"))
            binding.test2.setTextColor(Color.parseColor("#f19f21"))
            binding.lab.setTextColor(Color.parseColor("#f19f21"))
            binding.computeCie.background.setTint(Color.parseColor("#944c4c"))
            binding.computeGpa.background.setTint(Color.parseColor("#944c4c"))
            binding.assignment.setTextColor(Color.parseColor("#f19f21"))
            binding.subjectsShowAss.setTextColor(Color.parseColor("#f19f21"))
            binding.marksShowAss.setTextColor(Color.parseColor("#f19f21"))
            binding.see.setTextColor(Color.parseColor("#f19f21"))
            binding.subjectsShowSee.setTextColor(Color.parseColor("#f19f21"))
            binding.marksShowSee.setTextColor(Color.parseColor("#f19f21"))
            //WindowInsetsControllerCompat(window, view).isAppearanceLightStatusBars = false
            binding.grettingImgLayout.setBackgroundResource(R.drawable.morning_photo)

        }else if(hours in 12..15){
            binding.greeting.text = "Good Afternoon"
            binding.greeting.setTextColor(Color.parseColor("#edad84"))
            binding.test1.setTextColor(Color.parseColor("#edad84"))
            binding.subjectsShow.setTextColor(Color.parseColor("#edad84"))
            binding.subjectsShowTest2.setTextColor(Color.parseColor("#edad84"))
            binding.subjectsShowLab.setTextColor(Color.parseColor("#edad84"))
            binding.marksShowLab.setTextColor(Color.parseColor("#edad84"))
            binding.marksShowTest1.setTextColor(Color.parseColor("#edad84"))
            binding.marksShowTest2.setTextColor(Color.parseColor("#edad84"))
            binding.test2.setTextColor(Color.parseColor("#edad84"))
            binding.lab.setTextColor(Color.parseColor("#edad84"))
            binding.computeCie.background.setTint(Color.parseColor("#e06d36"))
            binding.computeGpa.background.setTint(Color.parseColor("#e06d36"))
            binding.assignment.setTextColor(Color.parseColor("#edad84"))
            binding.subjectsShowAss.setTextColor(Color.parseColor("#edad84"))
            binding.marksShowAss.setTextColor(Color.parseColor("#edad84"))
            binding.see.setTextColor(Color.parseColor("#edad84"))
            binding.subjectsShowSee.setTextColor(Color.parseColor("#edad84"))
            binding.marksShowSee.setTextColor(Color.parseColor("#edad84"))
            binding.grettingImgLayout.setBackgroundResource(R.drawable.afternoon_photo)

        }else if(hours in 16..19){
            binding.greeting.text = "Good Evening"
            binding.greeting.setTextColor(Color.parseColor("#fa8280"))
            binding.test1.setTextColor(Color.parseColor("#fa8280"))
            binding.subjectsShow.setTextColor(Color.parseColor("#fa8280"))
            binding.subjectsShowTest2.setTextColor(Color.parseColor("#fa8280"))
            binding.subjectsShowLab.setTextColor(Color.parseColor("#fa8280"))
            binding.marksShowLab.setTextColor(Color.parseColor("#fa8280"))
            binding.marksShowTest1.setTextColor(Color.parseColor("#fa8280"))
            binding.marksShowTest2.setTextColor(Color.parseColor("#fa8280"))
            binding.test2.setTextColor(Color.parseColor("#fa8280"))
            binding.lab.setTextColor(Color.parseColor("#fa8280"))
            binding.computeCie.background.setTint(Color.parseColor("#dc423d"))
            binding.computeGpa.background.setTint(Color.parseColor("#dc423d"))
            binding.assignment.setTextColor(Color.parseColor("#fa8280"))
            binding.subjectsShowAss.setTextColor(Color.parseColor("#fa8280"))
            binding.marksShowAss.setTextColor(Color.parseColor("#fa8280"))
            binding.see.setTextColor(Color.parseColor("#fa8280"))
            binding.subjectsShowSee.setTextColor(Color.parseColor("#fa8280"))
            binding.marksShowSee.setTextColor(Color.parseColor("#fa8280"))
            binding.grettingImgLayout.setBackgroundResource(R.drawable.evening_photo)

        }else if(hours in 20..23 || hours in 0..4){
            binding.greeting.text = "Good Night"
            binding.greeting.setTextColor(Color.parseColor("#f3dff4"))
            binding.test1.setTextColor(Color.parseColor("#f3dff4"))
            binding.subjectsShow.setTextColor(Color.parseColor("#f3dff4"))
            binding.subjectsShowTest2.setTextColor(Color.parseColor("#f3dff4"))
            binding.subjectsShowLab.setTextColor(Color.parseColor("#f3dff4"))
            binding.marksShowLab.setTextColor(Color.parseColor("#f3dff4"))
            binding.marksShowTest1.setTextColor(Color.parseColor("#f3dff4"))
            binding.marksShowTest2.setTextColor(Color.parseColor("#f3dff4"))
            binding.test2.setTextColor(Color.parseColor("#f3dff4"))
            binding.lab.setTextColor(Color.parseColor("#f3dff4"))
            binding.computeCie.background.setTint(Color.parseColor("#433254"))
            binding.computeGpa.background.setTint(Color.parseColor("#433254"))
            binding.assignment.setTextColor(Color.parseColor("#f3dff4"))
            binding.subjectsShowAss.setTextColor(Color.parseColor("#f3dff4"))
            binding.marksShowAss.setTextColor(Color.parseColor("#f3dff4"))
            binding.see.setTextColor(Color.parseColor("#f3dff4"))
            binding.subjectsShowSee.setTextColor(Color.parseColor("#f3dff4"))
            binding.marksShowSee.setTextColor(Color.parseColor("#f3dff4"))
            WindowInsetsControllerCompat(window, view).isAppearanceLightStatusBars = false
            binding.grettingImgLayout.setBackgroundResource(R.drawable.night_photo)
        }

        val adapter = MarksAdapter()

        val recycler = binding.test1Recycler
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        val adaptertest2 = test2Adapter()
        val test2recycler = binding.test2Recycler
        test2recycler.adapter = adaptertest2
        test2recycler.layoutManager = LinearLayoutManager(this)

        val assgnRecycler = binding.assgnRecycler
        assgnRecycler.adapter = adapter
        assgnRecycler.layoutManager = LinearLayoutManager(this)

        mMarksViewModel = ViewModelProvider(this).get(MarksViewModel::class.java)
        mMarksViewModel.getFirstTestMarks.observe(this) { marks ->
            adapter.setData(marks, this, binding.cieViewMain, binding.gpaShowView)
        }

        mMarksViewModel.getSecondTestMarks.observe(this) { marks ->
            adaptertest2.setData(marks, this, binding.cieViewMain, binding.gpaShowView)
        }

        val labAdapter = LabAdapter()

        val labRecycler = binding.labRecycler
        labRecycler.adapter = labAdapter
        labRecycler.layoutManager = LinearLayoutManager(this)

        mMarksViewModel = ViewModelProvider(this).get(MarksViewModel::class.java)
        mMarksViewModel.getLabMarks.observe(this) { marks ->
            labAdapter.setData(marks, this, binding.cieViewMain, binding.gpaShowView)
        }

        val AssgnAdapter = AssignmentAdapter()

        val AssgnRecycler = binding.assgnRecycler
        AssgnRecycler.adapter = AssgnAdapter
        AssgnRecycler.layoutManager = LinearLayoutManager(this)

        mMarksViewModel.getAssgnMarks.observe(this){ marks ->
            AssgnAdapter.setData(marks, this, binding.cieViewMain, binding.gpaShowView)
        }

        mMarksViewModel.getCieData.observe(this) { marks ->
            getCieMarks = marks
        }

        mMarksViewModel.getGPoint.observe(this){marks ->
            getGpaMarks = marks
        }


        val cieAdapter = CieAdapter()
        val cieRecycler = binding.cieRecycler

        cieRecycler.adapter = cieAdapter
        cieRecycler.layoutManager = GridLayoutManager(this, 3)

        mMarksViewModel.showCieData.observe(this) { marks ->
            if(marks.isNotEmpty()){
                val size = marks.size
                val current = marks[size-1]
                if(current.cie != -1) {
                    cieAdapter.setData(marks)

                    binding.cieViewMain.visibility = View.VISIBLE
                    binding.cieRecycler.visibility = View.VISIBLE
                }
            }
        }

        val FinalAdapter = finalAdapter()
        val finalRecycler = binding.seeRecycler

        finalRecycler.adapter = FinalAdapter
        finalRecycler.layoutManager = LinearLayoutManager(this)

        mMarksViewModel.getFinalMarks.observe(this){ marks ->
            FinalAdapter.setData(marks, this, binding.gpaShowView)
        }

        binding.computeCie.setOnClickListener {
            binding.computeCie.animate().scaleX(0.97f).scaleY(0.97f)//scale to quarter(half x,half y)
                .alpha(0.5f)
                .setDuration(300)
                .withEndAction{
                    binding.computeCie.animate().scaleX(1f).scaleY(1f)//scale to quarter(half x,half y)
                        .alpha(1f)
                        .setDuration(300)
                }

            binding.gpaShowView.visibility = View.GONE
            var test1M = true
            var test2M = true
            var labM = true
            var assgnM = true

            if(getCieMarks.isNotEmpty()) {
                for (entry in getCieMarks) {

                    if (entry.isSub == 1) {
                        if (entry.MTest1 != -1) {
                            if(entry.MTest2 != -1) {
                                if(entry.MAssgn != -1) {
                                            mMarksViewModel.updateCie(
                                                ComputeCie(
                                                    entry.id,
                                                    entry.Subject,
                                                    entry.MTest1,
                                                    entry.MTest2,
                                                    entry.MAssgn,
                                                    1,
                                                    entry.MLab,
                                                    entry.MTest1 + entry.MTest2 + entry.MAssgn
                                                )
                                            )
                                }else{
                                    assgnM = false
                                }
                            }else{
                                test2M = false
                            }
                        }else{
                            test1M = false
                        }
                    } else {
                        if (entry.MLab != -1) {
                            mMarksViewModel.updateCie(
                                ComputeCie(
                                    entry.id,
                                    entry.Subject,
                                    entry.MTest1,
                                    entry.MTest2,
                                    entry.MAssgn,
                                    0,
                                    entry.MLab,
                                    entry.MLab
                                )
                            )
                        }else{
                            labM = false
                        }
                    }
                }

                if(!test1M){
                    Toast.makeText(this, "Please enter Test 1 marks", Toast.LENGTH_SHORT).show()
                }else if(!test2M){
                    Toast.makeText(this, "Please enter Test 2 marks", Toast.LENGTH_SHORT).show()
                }else if(!assgnM){
                    Toast.makeText(this, "Please enter Assignment marks", Toast.LENGTH_SHORT).show()
                }
                else{
                    if (binding.cieViewMain.visibility == View.GONE) {

                        cieRecycler.adapter = cieAdapter
                        cieRecycler.layoutManager = GridLayoutManager(this, 3)

                        mMarksViewModel.showCieData.observe(this) { marks ->
                            cieAdapter.setData(marks)
                        }

                        binding.cieViewMain.visibility = View.VISIBLE
                        binding.cieRecycler.visibility = View.VISIBLE
                    }
                }
            }else{
                Toast.makeText(this, "One or more marks fields not filled", Toast.LENGTH_SHORT).show()
            }
        }

        var flag = 0

        binding.computeGpa.setOnClickListener {
            binding.computeGpa.animate().scaleX(0.97f).scaleY(0.97f)//scale to quarter(half x,half y)
                .alpha(0.5f)
                .setDuration(300)
                .withEndAction{
                    binding.computeGpa.animate().scaleX(1f).scaleY(1f)//scale to quarter(half x,half y)
                        .alpha(1f)
                        .setDuration(300)
                }
            //binding.computeGpa.performClick()
            var grade: String = ""
            var gPoint = 0
            var credits: Float = 0.0F
            var calcGrade: Float = 0.0F
            val single = 0.34
            var Finalflag = 0
            var Cieflag = 0
            var Labflag = 0

            if (getGpaMarks.isNotEmpty()) {
                for (entry in getGpaMarks) {
                    //Log.d("credit", entry.cie.toString())
                    if (entry.isSub == 1) {
                        val cie = entry.cie
                        val finalMarks = entry.MFinal
                        if(cie != -1) {
                            Cieflag = 1
                            if(finalMarks != -1) {
                                credits += entry.credits.toFloat()
                                calcGrade += (entry.gPoint * entry.credits.toFloat())
                                Finalflag = 1
                                when ((finalMarks / 2 + cie)) {
                                    in 90..100 -> {
                                        grade = "S"
                                        gPoint = 10
                                    }
                                    in 80..89 -> {
                                        grade = "A"
                                        gPoint = 9
                                    }
                                    in 70..79 -> {
                                        grade = "B"
                                        gPoint = 8
                                    }
                                    in 60..69 -> {
                                        grade = "C"
                                        gPoint = 7
                                    }
                                    in 50..59 -> {
                                        grade = "D"
                                        gPoint = 6
                                    }
                                    in 40..49 -> {
                                        grade = "E"
                                        gPoint = 4
                                    }
                                    in 0..39 -> {
                                        grade = "F"
                                        gPoint = 0
                                    }
                                }

                                mMarksViewModel.updateGpa(
                                    getGPoint(
                                        entry.id,
                                        entry.credits,
                                        1,
                                        entry.cie,
                                        entry.MFinal,
                                        gPoint,
                                        grade
                                    )
                                )
                            }else{
                                Finalflag = 0
                                //Toast.makeText(this, "Final marks not filled", Toast.LENGTH_SHORT).show()
                            }
                        }else{
                            Cieflag = 0
                            //Toast.makeText(this, "CIE not computed", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        if(entry.cie != -1) {
                            credits += entry.credits.toFloat()
                            calcGrade += (entry.gPoint * entry.credits.toFloat())
                            Labflag = 1
                            Cieflag = 1
                            when (entry.cie * 2) {
                                in 90..100 -> {
                                    grade = "S"
                                    gPoint = 10
                                }
                                in 80..89 -> {
                                    grade = "A"
                                    gPoint = 9
                                }
                                in 70..79 -> {
                                    grade = "B"
                                    gPoint = 8
                                }
                                in 60..69 -> {
                                    grade = "C"
                                    gPoint = 7
                                }
                                in 50..59 -> {
                                    grade = "D"
                                    gPoint = 6
                                }
                                in 40..49 -> {
                                    grade = "E"
                                    gPoint = 4
                                }
                                in 0..39 -> {
                                    grade = "F"
                                    gPoint = 0
                                }
                            }
                            mMarksViewModel.updateGpa(
                                getGPoint(
                                    entry.id,
                                    entry.credits,
                                    0,
                                    entry.cie,
                                    entry.MFinal,
                                    gPoint,
                                    grade
                                )
                            )
                        }else{
                            Cieflag = 0
                            //Toast.makeText(this, "CIE not computed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                //binding.gpaShowText.text = String.format("%.2f", calcGrade / credits)

                binding.gpaShowText.setOnClickListener {
                    Toast.makeText(this, "$calcGrade/$credits", Toast.LENGTH_SHORT).show()
                }

                if(binding.gpaShowView.visibility == View.GONE && Finalflag == 1 && calcGrade > 0 && Labflag == 1 && Cieflag == 1) {
                    flag++
                }

                if(calcGrade > 0 && Labflag == 1 && Cieflag == 1 && Finalflag == 1) {
                    if(flag%2 != 0){
                        firstClick = false
                        Toast.makeText(this, "Done computing! Click me again", Toast.LENGTH_SHORT)
                            .show()
                    }else{
                        binding.gpaShowView.visibility = View.VISIBLE
                        binding.gpaShowText.text = String.format("%.2f", calcGrade / credits)
                    }
                    //binding.gpaShowText.text = String.format("%.2f", calcGrade/credits)
                }else{
                    if(Finalflag == 0){
                        Toast.makeText(this, "Final marks not filled", Toast.LENGTH_SHORT).show()
                    }else if(Cieflag == 0){
                        Toast.makeText(this, "CIE not computed", Toast.LENGTH_SHORT).show()
                    }else if(Labflag == 0){
                        Toast.makeText(this, "Lab marks not filled", Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(this, "Done computing! Click me again", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }else{
                Toast.makeText(this, "One or more marks fields not filled", Toast.LENGTH_SHORT).show()
            }
        }

        binding.nextSemView.setOnClickListener{
            binding.nextSemView.animate().scaleX(0.97f).scaleY(0.97f)//scale to quarter(half x,half y)
                .alpha(0.5f)
                .setDuration(300)
                .withEndAction{
                    binding.nextSemView.animate().scaleX(1f).scaleY(1f)//scale to quarter(half x,half y)
                        .alpha(1f)
                        .setDuration(300)
                }

            val builder = AlertDialog.Builder(this)

            builder.setMessage("Go to next sem?")
            builder.setMessage("All current data would be lost and cannot be retrieved back")
            builder.setIcon(android.R.drawable.stat_sys_warning)

            builder.setPositiveButton("Oki") { _, _ ->
                val intentToActivity = Intent(this, GetStarted::class.java)
                startActivity(intentToActivity)
                getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", true).apply()
                mMarksViewModel.deleteAllData()
                Toast.makeText(this, "Yay " + ("\ud83d\ude00"), Toast.LENGTH_SHORT).show()
                finish()
            }

            builder.create()
            builder.show()

        }

    }

    fun adjustFontScale(configuration: Configuration) {
        configuration.fontScale = 1.2.toFloat()
        val metrics = resources.displayMetrics
        val wm = getSystemService(WINDOW_SERVICE) as WindowManager
        wm.defaultDisplay.getMetrics(metrics)
        metrics.scaledDensity = configuration.fontScale * metrics.density
        baseContext.resources.updateConfiguration(configuration, metrics)
    }

}
