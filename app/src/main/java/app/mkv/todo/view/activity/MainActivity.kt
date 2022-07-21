package app.mkv.todo.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import app.mkv.todo.R
import app.mkv.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBarWithNavController(findNavController(R.id.navHostFragment))

    }


    override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(R.id.navHostFragment )
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}