package udy.tutorials.agetomincalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.util.*


class MainActivity : AppCompatActivity() {
    private var tvselecteddate:TextView?=null
    private var tvagetomin:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker: Button = findViewById(R.id.btnpicker)
        tvselecteddate=findViewById(R.id.selectdate)
        tvagetomin=findViewById(R.id.tvagetomin)
        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }
    }
        fun clickDatePicker()
        {
           val mycalender=Calendar.getInstance()
            val year=mycalender.get(Calendar.YEAR)
            val month=mycalender.get(Calendar.MONTH)
            val dayOfWeek=mycalender.get(Calendar.DAY_OF_MONTH)
            val dpd=DatePickerDialog(this,{
                view,selectedyear,selectedmonth,selecteddayofmonth->

                Toast.makeText(this,"the year is $selectedyear and the month is ${selectedmonth+1}",Toast.LENGTH_LONG).show()
                 var selectedDate="$selecteddayofmonth/${selectedmonth+1}/$selectedyear"
                tvselecteddate?.setText(selectedDate)
                val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val sdfdate=sdf.parse(selectedDate)
                val timeinmin=sdfdate.time/60000
                val currdate=sdf.parse(sdf.format(System.currentTimeMillis()))
                val currdatetime = currdate.time/60000
                var diff=currdatetime-timeinmin
                tvagetomin?.text=diff.toString()



            },year,month,dayOfWeek)
                dpd.datePicker.maxDate=System.currentTimeMillis()-86400000
                dpd.show()

        }





}