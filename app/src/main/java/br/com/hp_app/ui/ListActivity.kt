package br.com.hp_app.ui

import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.com.hp_app.R
import br.com.hp_app.databinding.ActivityListBinding
import br.com.hp_app.ui.viewmodel.ListsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListActivity : AppCompatActivity() {
    private val viewModel by viewModel<ListsViewModel>()
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView
        val toolbar: androidx.appcompat.widget.Toolbar = binding.listToolbar

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_houses,
                R.id.navigation_elixirs,
                R.id.navigation_spells,
                R.id.navigation_ingredients,
                R.id.navigation_wizards
            )
        )

        setSupportActionBar(binding.listToolbar)

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_nav_menu, menu)
        val search = menu?.findItem(R.id.search)
        val searchView: SearchView = search?.actionView as SearchView
        searchView.queryHint = "Type here..."
        viewModel.getSearchQuery("")
        searchView.clearFocus()

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    viewModel.getSearchQuery(newText)
                }else{
                    viewModel.getSearchQuery("")
                }
                return false
            }


        })

        return super.onCreateOptionsMenu(menu)
    }
}