package com.example.grades

import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.grades.data.MarksTest2
import com.example.grades.data.MarksViewModel
import com.example.grades.data.finalMarks
import java.util.*

class finalAdapter: RecyclerView.Adapter<finalAdapter.myViewHolder>() {

    private var marksList = emptyList<finalMarks>()
    private lateinit var mViewModel: MarksViewModel
    private lateinit var context1: Context
    private lateinit var context: ViewModelStoreOwner
    private lateinit var gpa: RelativeLayout

    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var subject = itemView.findViewById<TextView>(R.id.subject_indi)
        var marksView = itemView.findViewById<EditText>(R.id.marks_indi)
        var indiView = itemView.findViewById<View>(R.id.indi_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        context1 = parent.context
        return myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sub_marks_indi, parent,false))
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentMarks = marksList[position]
        mViewModel = ViewModelProvider(context).get(MarksViewModel::class.java)
        //val cieAdapter: CieAdapter = CieAdapter()
        val activity = MainActivity()

        val cal = Calendar.getInstance()
        val hours = cal.get(Calendar.HOUR_OF_DAY)

        if (hours in 5..11) {
            holder.marksView.setHintTextColor(Color.GRAY)
            holder.indiView.setBackgroundColor(Color.parseColor("#6d0f0b"))
        } else if (hours in 12..15) {
            holder.marksView.setHintTextColor(Color.GRAY)
            holder.indiView.setBackgroundColor(Color.parseColor("#e06d36"))
        } else if (hours in 16..19) {
            holder.indiView.setBackgroundColor(Color.parseColor("#dc423d"))
            holder.marksView.setHintTextColor(Color.GRAY)
        } else if (hours in 20..23 || hours in 0..4) {
            holder.marksView.setHintTextColor(Color.GRAY)
            holder.indiView.setBackgroundColor(Color.parseColor("#f3dff4"))
        }

        if (currentMarks.isSub == 1) {
            holder.subject.visibility = View.VISIBLE
            holder.marksView.visibility = View.VISIBLE
            holder.subject.text = currentMarks.Subject
            holder.marksView.hint = "100"

            holder.subject.setOnClickListener {
                Toast.makeText(context1, ("\ud83d\ude36") + " not again!", Toast.LENGTH_SHORT).show()
            }
            if (currentMarks.MFinal != -1) {
                holder.marksView.setText(currentMarks.MFinal.toString())
            }
        } else{
            holder.subject.visibility = View.GONE
            holder.marksView.visibility = View.GONE
        }

        holder.marksView.setOnEditorActionListener { textView, i, keyEvent ->
            if(i == EditorInfo.IME_ACTION_DONE){
                if(!TextUtils.isEmpty(holder.marksView.text.toString())) {
                    if (Integer.parseInt(holder.marksView.text.toString()) in 0..100) {
                        mViewModel.updateFinalMarks(
                            finalMarks(
                                currentMarks.id,
                                currentMarks.Subject,
                                1,
                                Integer.parseInt(holder.marksView.text.toString())
                            )
                        )
                        holder.marksView.clearFocus()
                        gpa.visibility = View.GONE
                    }else{
                        Toast.makeText(context1, "Input out of range!", Toast.LENGTH_SHORT).show()
                    }
                }
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
    }

    fun setData(marks: List<finalMarks>, context: ViewModelStoreOwner, gpa: RelativeLayout){
        marksList = marks
        this.context = context
        this.gpa = gpa
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return marksList.size
    }
}