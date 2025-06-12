package jp.wings.nikkeibp.getallsensors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomAdapter(context: Context, val sensorList: ArrayList<SensorObject>): ArrayAdapter<SensorObject>(context, 0) {
    //private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //    getViewメソッドでレイアウトを設定
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//      レイアウトの設定
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
//      それぞれの項目を表示するviewの設定
        val sensor = sensorList[position]
        view?.findViewById<TextView>(R.id.name).apply{sensor.name}
        view?.findViewById<TextView>(R.id.power).apply{sensor.power}
        view?.findViewById<TextView>(R.id.mindelay).apply{sensor.mindelay}

       /* val name = view?.findViewById<TextView>(R.id.name)
        name?.text = sensor.name
        val power = view?.findViewById<TextView>(R.id.power)
        power?.text = sensor.power.toString()
        val mindelay = view?.findViewById<TextView>(R.id.mindelay)
        mindelay?.text = sensor.mindelay.toString()*/
        return view!!
    }
}