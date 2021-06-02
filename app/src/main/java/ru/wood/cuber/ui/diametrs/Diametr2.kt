package ru.wood.cuber.ui.diametrs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import ru.wood.cuber.R
import ru.wood.cuber.databinding.FragmentDiametr2Binding
import ru.wood.cuber.view_models.TreesViewModel

class Diametr2 : Fragment(), View.OnClickListener {
    private val viewModel: TreesViewModel by activityViewModels()
    var diametr: Int?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDiametr2Binding.inflate(inflater)
        val view=binding.root
        binding.fragment=this
        binding.setOnClikListener=this

        return view
    }

    override fun onClick(v: View?) {
        when(view?.id){
            R.id.length_36-> diametr=36
            R.id.length_37->diametr=37
            R.id.length_38->diametr=38
            R.id.length_39->diametr=39
            R.id.length_40->diametr=40
            R.id.length_41->diametr=41
            R.id.length_42->diametr=42
            R.id.length_43->diametr=43
            R.id.length_44->diametr=44
            R.id.length_45->diametr=45
            R.id.length_46->diametr=46
            R.id.length_47->diametr=47
            R.id.length_48->diametr=48
            R.id.length_49->diametr=49
            R.id.length_50->diametr=50
            R.id.length_51->diametr=51
        }
        viewModel.addNew(diametr)
    }
}