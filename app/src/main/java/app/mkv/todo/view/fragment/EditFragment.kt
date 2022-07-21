package app.mkv.todo.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import app.mkv.todo.R
import app.mkv.todo.databinding.FragmentEditBinding


class EditFragment : Fragment() {


    lateinit var binding: FragmentEditBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditBinding.inflate(layoutInflater, container, false)

        event();

        return binding.root
    }

    private fun event(){
        setHasOptionsMenu(true)


    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.edit_menu, menu)
    }

}