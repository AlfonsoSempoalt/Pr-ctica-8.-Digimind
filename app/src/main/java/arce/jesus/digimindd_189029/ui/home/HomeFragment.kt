package arce.jesus.digimindd_189029.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import arce.jesus.digimindd_189029.R
import arce.jesus.digimindd_189029.Recordatorio
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.recordatorio.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    var reminderAdapter : ReminderAdapter? = null
    var listaRecordatorio = ArrayList<Recordatorio>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val gvReminder = root.findViewById(R.id.GV_items) as GridView
        listaRecordatorio.add(Recordatorio("Everyday","17:00","Practice"))
        listaRecordatorio.add(Recordatorio("Everyday","17:00","Practice"))
        listaRecordatorio.add(Recordatorio("Everyday","17:00","Practice"))
        listaRecordatorio.add(Recordatorio("Everyday","17:00","Practice"))
        listaRecordatorio.add(Recordatorio("Everyday","17:00","Practice"))
        listaRecordatorio.add(Recordatorio("Everyday","17:00","Practice"))


        reminderAdapter = ReminderAdapter(requireContext(), listaRecordatorio)

        gvReminder.adapter=reminderAdapter

        return root
    }

}

class ReminderAdapter : BaseAdapter, ListAdapter {
    var recordatorios = ArrayList<Recordatorio>()
    var context: Context? = null

    constructor(context: Context, lstReminders: ArrayList<Recordatorio>) {
        this.context = context
        this.recordatorios = lstReminders
    }

    override fun getCount(): Int {
        return recordatorios.size
    }

    override fun getItem(p0: Int): Any {
        return recordatorios[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var reminder = recordatorios[p0]
        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = inflater.inflate(R.layout.recordatorio, null)

        view.tvTitle.setText(reminder.nombre)
        view.tvTime.setText(reminder.dias)
        view.tvWhen.setText(reminder.tiempo)
        return view
    }
}