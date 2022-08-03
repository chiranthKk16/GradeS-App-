package com.example.grades

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grades.data.cieShow
import java.util.*

class CieAdapter: RecyclerView.Adapter<CieAdapter.myViewHolder>() {

    private var marksList = emptyList<cieShow>()
    private var nightYes: Boolean = false
    private lateinit var context: Context

    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val cieSubj = itemView.findViewById<TextView>(R.id.cie_subject)
        val cieLayout = itemView.findViewById<RelativeLayout>(R.id.cie_show_layout)
        val cieMarks = itemView.findViewById<TextView>(R.id.cie_marks_textView)
        val reqMarks = itemView.findViewById<TextView>(R.id.required_marks)
        val circle = itemView.findViewById<ImageView>(R.id.circle)
        val gradeShow = itemView.findViewById<TextView>(R.id.grade_show_indi)
        val cieType = itemView.findViewById<TextView>(R.id.cie_like_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        context = parent.context
        return myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cie_marks_indi, parent, false))
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val current = marksList[position]

        var req_marks = (40 + (10-current.cie%10))*2

        if(req_marks == 100 && current.cie == 50){
            req_marks -= 20
        }

        when (context.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {nightYes=true}
            Configuration.UI_MODE_NIGHT_NO -> {nightYes=false}
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {}
        }

        val cal = Calendar.getInstance()
        val hours = cal.get(Calendar.HOUR_OF_DAY)

        if(current.isSub == 1 && current.cie >= 0) {
            holder.cieLayout.visibility = View.VISIBLE
            //holder.cieLayout.layoutParams = GridLayoutManager.LayoutParams(200, 320)
            val parm : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT)
            holder.cieLayout.layoutParams = parm
            holder.cieSubj.text = current.Subject.toString()
            holder.cieMarks.text = current.cie.toString()
            holder.reqMarks.text = (req_marks).toString()

            when(req_marks/2 + current.cie){
                in 90..100 -> {holder.circle.setBackgroundResource(R.drawable.circle)
                                holder.gradeShow.text = "S"
                                holder.gradeShow.setTextColor(Color.parseColor("#4CAF50"))}
                in 80..90 -> {holder.circle.setBackgroundResource(R.drawable.circle_yellow)
                              holder.gradeShow.text = "A"
                              holder.gradeShow.setTextColor(Color.parseColor("#ffdf00"))}
                in 70..80 -> {holder.circle.setBackgroundResource(R.drawable.circle_yellow)
                              holder.gradeShow.text = "B"
                              holder.gradeShow.setTextColor(Color.parseColor("#ffdf00"))}
                in 60..70 -> {holder.circle.setBackgroundResource(R.drawable.circle_yellow)
                                holder.gradeShow.text = "C"
                                holder.gradeShow.setTextColor(Color.parseColor("#ffdf00"))}
                in 50..60 -> {holder.circle.setBackgroundResource(R.drawable.circle_yellow)
                              holder.gradeShow.text = "D"
                              holder.gradeShow.setTextColor(Color.parseColor("#ffdf00"))}
                in 40..50 -> {holder.circle.setBackgroundResource(R.drawable.circle_yellow)
                              holder.gradeShow.text = "E"
                              holder.gradeShow.setTextColor(Color.parseColor("#ffdf00"))}
                in 0..40 -> {holder.circle.setBackgroundResource(R.drawable.circle_yellow)
                             holder.gradeShow.text = "F"
                             holder.gradeShow.setTextColor(Color.parseColor("#ffdf00"))}
            }

            if(nightYes) {
                holder.cieSubj.background.setTint(Color.parseColor("#121212"))
            }else{
                holder.cieSubj.background.setTint(Color.WHITE)
            }

        }
        else{
            //Toast.makeText(context, "Please enter marks", Toast.LENGTH_SHORT).show()
            holder.cieLayout.layoutParams = GridLayoutManager.LayoutParams(0,0)
            //holder.cieLayout.
        }


    }

    fun setData(marks: List<cieShow>){
        marksList = marks
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return marksList.size
    }
}