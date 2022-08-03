package com.example.grades

import android.content.Context
import android.graphics.Color
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.view.menu.MenuView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grades.data.Marks
import com.example.grades.data.MarksTest1
import com.example.grades.data.MarksViewModel
import java.util.*

class MarksAdapter: RecyclerView.Adapter<MarksAdapter.myViewHolder>() {

    private var marksList = emptyList<MarksTest1>()
    private lateinit var recycler: RelativeLayout
    private lateinit var context1: Context
    private lateinit var context: ViewModelStoreOwner
    private lateinit var mViewHolder: MarksViewModel
    private lateinit var gpa: RelativeLayout

    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var subject = itemView.findViewById<TextView>(R.id.subject_indi)
        var marksView = itemView.findViewById<EditText>(R.id.marks_indi)
        var indiView = itemView.findViewById<View>(R.id.indi_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        context1 = parent.context
        return myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sub_marks_indi, parent, false))
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentMarks = marksList[position]
        mViewHolder = ViewModelProvider(context).get(MarksViewModel::class.java)
        val activity = CieAdapter()

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

            holder.subject.setOnClickListener {
                Toast.makeText(context1, (	"\ud83d\ude11") + " Hey!", Toast.LENGTH_SHORT).show()
            }

            holder.subject.text = currentMarks.Subject
            holder.marksView.hint = "20"
            if (currentMarks.MTest1 != -1) {
                holder.marksView.setText(currentMarks.MTest1.toString())

            }
        } else{
            holder.subject.visibility = View.GONE
            holder.marksView.visibility = View.GONE
        }

        holder.marksView.setOnEditorActionListener { textView, i, keyEvent ->
            if(i == EditorInfo.IME_ACTION_DONE){
                if(!TextUtils.isEmpty(holder.marksView.text.toString())) {
                    if (Integer.parseInt(holder.marksView.text.toString()) in 0..20) {
                        mViewHolder.updateTest1(
                            MarksTest1(
                                currentMarks.id,
                                currentMarks.Subject,
                                1,
                                Integer.parseInt(holder.marksView.text.toString())
                            )
                        )
                        holder.marksView.clearFocus()
                        recycler.visibility = View.GONE
                        gpa.visibility = View.GONE
                        //activity.updateCieClicked()
                        //holder.marksView.isEnabled = false
                    }else{
                        Toast.makeText(context1, "Input out of range!", Toast.LENGTH_SHORT).show()
                    }
                }
                //notifyDataSetChanged()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }

    }

    fun setData(marks: List<MarksTest1>, context: ViewModelStoreOwner, recycler: RelativeLayout, gpa: RelativeLayout){
        this.marksList = marks
        this.context = context
        this.recycler = recycler
        this.gpa = gpa
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return marksList.size
    }
}