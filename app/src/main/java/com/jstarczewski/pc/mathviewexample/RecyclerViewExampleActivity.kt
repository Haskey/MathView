package com.jstarczewski.pc.mathviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jstarczewski.pc.mathviewexample.databinding.ActivityRecyclerViewExampleBinding
import com.jstarczewski.pc.mathviewexample.databinding.MatchItemBinding

class RecyclerViewExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val equations: ArrayList<Equation> = arrayListOf()

        equations.add(Equation("Praca", "$\\W=F↖{→}◦∆r↖{→}$, $\\W=Frcosα$, $[N*m=J]$ <br> $\\W$ praca, $\\F↖{→}$ siła, $∆r↖{→}$ zmiana położenia, $\\α$ kąt zawarty między wektorem siły i przemieszczenia, $\\J$ dżul <br> $\\W=∫F↖{→}{dr↖{→}$ <br> $\\W=∫F↖{→}dr↖{→}$ całka siły po przemiszeczeni"))
        equations.add(Equation("Moc", "$\\P=W/t$, $[J/s=W]$, gdy $\\v↖{→}={const}↖{→}$ to $\\P=Fv$ <br> $\\P$ moc, $\\v$ prędkość, $\\F$ siła, jednostka mocy to Wat $\\W$"))
        equations.add(Equation("Energia kinetyczna", "$\\E_k={mv^2}/2$, $[kg * m^2/{s^2}=J]$ <br> $\\E_k$ energia kinetyczna, $\\m$ masa, $\\v↖{→}$ prędkość, jednostka energi to dżul $\\J$"))
        equations.add(Equation("Energia potencjalna", "$\\E_p=mgh$, $\\[kg*m^2/{s^2}=J]$, $\\R_z>>h$ <br> $\\E_p$ energia potencjalna, $\\m$ masa, $\\g↖{→}$ przyśpieszenie grawitacyjne, $\\h$ wysokość, $\\R_z$ promień ziemi, $\\J$ dżul"))
        equations.add(Equation("Energia potencjalna sprezystosci", "$\\E_{ps}={k*x^2}/2$, $\\[J]$ <br> $\\E_{ps}$ energia potencjalna sprężystości, $\\k$ współczynnik sprężystości $\\[N/m]$, $\\\\x$ wychylenie/wydłużenie sprężyny"))
        equations.add(Equation("Zasada zachowania energii", "W izolowanym układzie, całkowita energia mechaniczna nie zmienia sie."))

        binding.rvTest.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = MathTestAdapter(equations)
        }
    }
}


class MathTestAdapter(private var equations: ArrayList<Equation>) : RecyclerView.Adapter<MathTestAdapter.ViewHolder>() {

    class ViewHolder(val binding: MatchItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = MatchItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        val holder = ViewHolder(binding)
        holder.binding.mvTest.apply {
            textColor = "black"
            backgroundColor = "#EEEEEE"
            textZoom = 70
        }
        return holder
    }

    override fun getItemCount(): Int {
        return equations.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.binding.tvTitle.text = equations[position].title
        viewHolder.binding.mvTest.text = equations[position].equation
    }
}
