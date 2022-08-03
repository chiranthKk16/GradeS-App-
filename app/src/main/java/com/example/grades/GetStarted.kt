package com.example.grades

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.grades.data.Marks
import com.example.grades.data.MarksViewModel
import com.example.grades.databinding.ActivityGetStartedBinding
import org.w3c.dom.Text

class GetStarted : AppCompatActivity() {

    private lateinit var binding: ActivityGetStartedBinding
    private lateinit var mMarksViewModel: MarksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mMarksViewModel = ViewModelProvider(this).get(MarksViewModel::class.java)

        binding.enterSubLabBtn.setOnClickListener{
            var flag = 0
            var noFlag = 0
            var subjectList = mutableListOf<String>()
            var labList = mutableListOf<String>()
            var isDuplicate = false
            var isDuplicateLab = false

            if (!TextUtils.isEmpty(binding.subject1.text) && !TextUtils.isEmpty(binding.credit1.text)) {
                if(binding.subject1.text.toString() in subjectList){
                    isDuplicate = true
                }else{
                    subjectList.add(binding.subject1.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.subject1.text) && !TextUtils.isEmpty(binding.credit1.text)) ||
                    (!TextUtils.isEmpty(binding.subject1.text) && TextUtils.isEmpty(binding.credit1.text))) {
                    noFlag++
                }
            }
            if (!TextUtils.isEmpty(binding.subject2.text) && !TextUtils.isEmpty(binding.credit2.text)) {
                if(binding.subject2.text.toString() in subjectList){
                    isDuplicate = true
                }else{
                    subjectList.add(binding.subject2.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.subject2.text) && !TextUtils.isEmpty(binding.credit2.text)) ||
                    (!TextUtils.isEmpty(binding.subject2.text) && TextUtils.isEmpty(binding.credit2.text))) {
                    noFlag++
                }
            }
            if (!TextUtils.isEmpty(binding.subject3.text) && !TextUtils.isEmpty(binding.credit3.text)) {
                if(binding.subject3.text.toString() in subjectList){
                    isDuplicate = true
                }else{
                    subjectList.add(binding.subject3.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.subject3.text) && !TextUtils.isEmpty(binding.credit3.text)) ||
                    (!TextUtils.isEmpty(binding.subject3.text) && TextUtils.isEmpty(binding.credit3.text))) {
                    noFlag++
                }
            }
            if (!TextUtils.isEmpty(binding.subject4.text) && !TextUtils.isEmpty(binding.credit4.text)) {
                if(binding.subject4.text.toString() in subjectList){
                    isDuplicate = true
                }else{
                    subjectList.add(binding.subject4.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.subject4.text) && !TextUtils.isEmpty(binding.credit4.text)) ||
                    (!TextUtils.isEmpty(binding.subject4.text) && TextUtils.isEmpty(binding.credit4.text))) {
                    noFlag++
                }
            }
            if (!TextUtils.isEmpty(binding.subject5.text) && !TextUtils.isEmpty(binding.credit5.text)) {
                if(binding.subject5.text.toString() in subjectList){
                    isDuplicate = true
                }else{
                    subjectList.add(binding.subject5.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.subject5.text) && !TextUtils.isEmpty(binding.credit5.text)) ||
                    (!TextUtils.isEmpty(binding.subject5.text) && TextUtils.isEmpty(binding.credit5.text))) {
                    noFlag++
                }
            }
            if (!TextUtils.isEmpty(binding.subject6.text) && !TextUtils.isEmpty(binding.credit6.text)) {
                if(binding.subject6.text.toString() in subjectList){
                    isDuplicate = true
                }else{
                    subjectList.add(binding.subject6.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.subject6.text) && !TextUtils.isEmpty(binding.credit6.text)) ||
                    (!TextUtils.isEmpty(binding.subject6.text) && TextUtils.isEmpty(binding.credit6.text))) {
                    noFlag++
                }
            }
            if (!TextUtils.isEmpty(binding.subject7.text) && !TextUtils.isEmpty(binding.credit7.text)) {
                if(binding.subject7.text.toString() in subjectList){
                    isDuplicate = true
                }else{
                    subjectList.add(binding.subject7.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.subject7.text) && !TextUtils.isEmpty(binding.credit7.text)) ||
                    (!TextUtils.isEmpty(binding.subject7.text) && TextUtils.isEmpty(binding.credit7.text))) {
                    noFlag++
                }
            }
            if (!TextUtils.isEmpty(binding.subject8.text) && !TextUtils.isEmpty(binding.credit8.text)) {
                if(binding.subject8.text.toString() in subjectList){
                    isDuplicate = true
                }else{
                    subjectList.add(binding.subject8.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.subject8.text) && !TextUtils.isEmpty(binding.credit8.text)) ||
                    (!TextUtils.isEmpty(binding.subject8.text) && TextUtils.isEmpty(binding.credit8.text))) {
                    noFlag++
                }
            }
            if (!TextUtils.isEmpty(binding.subject9.text) && !TextUtils.isEmpty(binding.credit9.text)) {
                if(binding.subject9.text.toString() in subjectList){
                    isDuplicate = true
                }else{
                    subjectList.add(binding.subject9.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.subject9.text) && !TextUtils.isEmpty(binding.credit9.text)) ||
                    (!TextUtils.isEmpty(binding.subject9.text) && TextUtils.isEmpty(binding.credit9.text))) {
                    noFlag++
                }
            }
            if (!TextUtils.isEmpty(binding.subject10.text) && !TextUtils.isEmpty(binding.credit10.text)) {
                if(binding.subject10.text.toString() in subjectList){
                    isDuplicate = true
                }else{
                    subjectList.add(binding.subject10.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.subject10.text) && !TextUtils.isEmpty(binding.credit10.text)) ||
                    (!TextUtils.isEmpty(binding.subject10.text) && TextUtils.isEmpty(binding.credit10.text))) {
                    noFlag++
                }
            }
            if (!TextUtils.isEmpty(binding.lab1.text) && !TextUtils.isEmpty(binding.labCredit1.text)) {
                if(binding.lab1.text.toString() in labList){
                    isDuplicateLab = true
                }else{
                    labList.add(binding.lab1.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.lab1.text) && !TextUtils.isEmpty(binding.labCredit1.text)) ||
                    (!TextUtils.isEmpty(binding.lab1.text) && TextUtils.isEmpty(binding.labCredit1.text))) {
                    noFlag++
                }
            }
            if (!TextUtils.isEmpty(binding.lab2.text) && !TextUtils.isEmpty(binding.labCredit2.text)) {
                if(binding.lab2.text.toString() in labList){
                    isDuplicateLab = true
                }else{
                    labList.add(binding.lab2.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.lab2.text) && !TextUtils.isEmpty(binding.labCredit2.text)) ||
                    (!TextUtils.isEmpty(binding.lab2.text) && TextUtils.isEmpty(binding.labCredit2.text))) {
                    noFlag++
                }
            }
            if (!TextUtils.isEmpty(binding.lab3.text) && !TextUtils.isEmpty(binding.labCredit3.text)) {
                if(binding.lab3.text.toString() in labList){
                    isDuplicateLab = true
                }else{
                    labList.add(binding.lab3.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.lab3.text) && !TextUtils.isEmpty(binding.labCredit3.text)) ||
                    (!TextUtils.isEmpty(binding.lab3.text) && TextUtils.isEmpty(binding.labCredit3.text))) {
                    noFlag++
                }
            }
            if (!TextUtils.isEmpty(binding.lab4.text) && !TextUtils.isEmpty(binding.labCredit4.text)) {
                if(binding.lab4.text.toString() in labList){
                    isDuplicateLab = true
                }else{
                    labList.add(binding.lab4.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.lab4.text) && !TextUtils.isEmpty(binding.labCredit4.text)) ||
                    (!TextUtils.isEmpty(binding.lab4.text) && TextUtils.isEmpty(binding.labCredit4.text))) {
                    noFlag++
                }
            }
            if (!TextUtils.isEmpty(binding.lab5.text) && !TextUtils.isEmpty(binding.labCredit5.text)) {
                if(binding.lab5.text.toString() in labList){
                    isDuplicateLab = true
                }else{
                    labList.add(binding.lab5.text.toString())
                }
                flag++
            }else{
                if((TextUtils.isEmpty(binding.lab5.text) && !TextUtils.isEmpty(binding.labCredit5.text)) ||
                    (!TextUtils.isEmpty(binding.lab5.text) && TextUtils.isEmpty(binding.labCredit5.text))) {
                    noFlag++
                }
            }

            if(flag > 0 && noFlag == 0) {
                if(!isDuplicate && !isDuplicateLab) {
                    val builder = Dialog(this)
                    builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    builder.setContentView(R.layout.hit_check)
                    val btn = builder.findViewById<Button>(R.id.dismiss)
                    builder.setCancelable(true)
                    btn.setOnClickListener {

                        if (!TextUtils.isEmpty(binding.subject1.text) && !TextUtils.isEmpty(binding.credit1.text)) {
                            addDataToDatabase(
                                binding.subject1.text.toString(),
                                binding.credit1.text.toString(), 1, 0
                            )
                        }
                        if (!TextUtils.isEmpty(binding.subject2.text) && !TextUtils.isEmpty(binding.credit2.text)) {
                            addDataToDatabase(
                                binding.subject2.text.toString(),
                                binding.credit2.text.toString(),1,0
                            )
                        }
                        if (!TextUtils.isEmpty(binding.subject3.text) && !TextUtils.isEmpty(binding.credit3.text)) {
                            addDataToDatabase(
                                binding.subject3.text.toString(),
                                binding.credit3.text.toString(), 1, 0
                            )
                        }
                        if (!TextUtils.isEmpty(binding.subject4.text) && !TextUtils.isEmpty(binding.credit4.text)) {
                            addDataToDatabase(
                                binding.subject4.text.toString(),
                                binding.credit4.text.toString(), 1, 0
                            )
                        }
                        if (!TextUtils.isEmpty(binding.subject5.text) && !TextUtils.isEmpty(binding.credit5.text)) {
                            addDataToDatabase(
                                binding.subject5.text.toString(),
                                binding.credit5.text.toString(), 1, 0
                            )
                        }
                        if (!TextUtils.isEmpty(binding.subject6.text) && !TextUtils.isEmpty(binding.credit6.text)) {
                            addDataToDatabase(
                                binding.subject6.text.toString(),
                                binding.credit6.text.toString(), 1, 0
                            )
                        }
                        if (!TextUtils.isEmpty(binding.subject7.text) && !TextUtils.isEmpty(binding.credit7.text)) {
                            addDataToDatabase(
                                binding.subject7.text.toString(),
                                binding.credit7.text.toString(), 1, 0
                            )
                        }
                        if (!TextUtils.isEmpty(binding.subject8.text) && !TextUtils.isEmpty(binding.credit8.text)) {
                            addDataToDatabase(
                                binding.subject8.text.toString(),
                                binding.credit8.text.toString(), 1, 0
                            )
                        }
                        if (!TextUtils.isEmpty(binding.subject9.text) && !TextUtils.isEmpty(binding.credit9.text)) {
                            addDataToDatabase(
                                binding.subject9.text.toString(),
                                binding.credit9.text.toString(), 1, 0
                            )
                        }
                        if (!TextUtils.isEmpty(binding.subject10.text) && !TextUtils.isEmpty(binding.credit10.text)) {
                            addDataToDatabase(
                                binding.subject10.text.toString(),
                                binding.credit10.text.toString(), 1, 0
                            )
                        }
                        if (!TextUtils.isEmpty(binding.lab1.text) && !TextUtils.isEmpty(binding.labCredit1.text)) {
                            addDataToDatabase(
                                binding.lab1.text.toString(),
                                binding.labCredit1.text.toString(), 0, 1
                            )
                        }
                        if (!TextUtils.isEmpty(binding.lab2.text) && !TextUtils.isEmpty(binding.labCredit2.text)) {
                            addDataToDatabase(
                                binding.lab2.text.toString(),
                                binding.labCredit2.text.toString(), 0, 1
                            )
                        }
                        if (!TextUtils.isEmpty(binding.lab3.text) && !TextUtils.isEmpty(binding.labCredit3.text)) {
                            addDataToDatabase(
                                binding.lab3.text.toString(),
                                binding.labCredit3.text.toString(), 0, 1
                            )
                        }
                        if (!TextUtils.isEmpty(binding.lab4.text) && !TextUtils.isEmpty(binding.labCredit4.text)) {
                            addDataToDatabase(
                                binding.lab4.text.toString(),
                                binding.labCredit4.text.toString(), 0, 1
                            )
                        }
                        if (!TextUtils.isEmpty(binding.lab5.text) && !TextUtils.isEmpty(binding.labCredit5.text)) {
                            addDataToDatabase(
                                binding.lab5.text.toString(),
                                binding.labCredit5.text.toString(), 0, 1
                            )
                        }

                        builder.dismiss()
                        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                            .putBoolean("isFirstRun", false).apply()
                        val intentToActivity = Intent(this, MainActivity::class.java)
                        startActivity(intentToActivity)
                        finish()
                    }
                    builder.show()
                }else{
                    Toast.makeText(this, "Duplicate entries found", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Invalid entry", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addDataToDatabase(subject: String, credit: String, isSub: Int, isLab: Int){
        Log.d("creditInsert", credit)
        mMarksViewModel.addData(
            Marks(0, subject, isSub, isLab,
                credit, -1, -1, -1, -1,
                -1,-1, "0",-1))
    }
}