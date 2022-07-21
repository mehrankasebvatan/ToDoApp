package app.mkv.todo.view.fragment

import android.app.Application
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.createViewModelLazy
import androidx.fragment.app.viewModels

import androidx.navigation.fragment.findNavController
import app.mkv.todo.R
import app.mkv.todo.data.model.Priority
import app.mkv.todo.data.model.ToDoData
import app.mkv.todo.data.viewmodel.ToDoViewModel
import app.mkv.todo.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding

    private val viewModel: ToDoViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater, container, false)



        event();
        return binding.root
    }


    private fun event() {

        setHasOptionsMenu(true)

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_add_done) {
            insertDataToDb()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun insertDataToDb() {
        val mTitle = binding.txtTitle.text.toString()
        val mPriority = binding.spinner.selectedItem.toString()
        val mDescription = binding.txtDescription.text.toString()

        val validation = verifyDataFromUser(mTitle, mDescription)
        if (validation){
            val newData = ToDoData(
                0,
                mTitle,
                parsePriority(mPriority),
                mDescription
            )
            viewModel.insertData(newData)
            Toast.makeText(requireContext(), "Add Successfully", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_homeFragment)
        } else Toast.makeText(requireContext(), "Fill All Inputs!!", Toast.LENGTH_SHORT).show()

    }

    private fun verifyDataFromUser(title: String, description: String): Boolean {
        return if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            false
        } else !(title.isEmpty() || description.isEmpty())
    }

    private fun parsePriority(priority: String): Priority {
        return when (priority) {
            "High Priority" -> {Priority.HIGH}
            "Medium Priority" -> {Priority.MEDIUM}
            "Low Priority" -> {Priority.LOW}
                else -> Priority.LOW

        }
    }

}

