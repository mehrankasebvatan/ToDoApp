package app.mkv.todo.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import app.mkv.todo.R
import app.mkv.todo.databinding.FragmentAddBinding
import app.mkv.todo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        event();
        return binding.root
    }

    private fun event(){

        binding.btnAdd.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_addFragment) }

        binding.goToEdit.setOnClickListener{ findNavController().navigate(R.id.action_homeFragment_to_editFragment)}

        setHasOptionsMenu(true)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
    }


}