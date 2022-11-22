package br.com.hp_app.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import br.com.hp_app.R
import br.com.hp_app.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar()

        setupNavigation()

    }

    private fun setupNavigation() {
        if (intent.hasExtra("elixirId")) {
            findNavController(R.id.nav_host_fragment_content_detalhes).navigate(R.id.navigation_elixirs_details)
        } else if (intent.hasExtra("housesId")) {
            findNavController(R.id.nav_host_fragment_content_detalhes).navigate(R.id.navigation_houses_details)
        } else if (intent.hasExtra("spellId")) {
            findNavController(R.id.nav_host_fragment_content_detalhes).navigate(R.id.navigation_spells_details)
        } else if (intent.hasExtra("wizardId")) {
            findNavController(R.id.nav_host_fragment_content_detalhes).navigate(R.id.navigation_wizards_details)
        } else if (intent.hasExtra("ingredientId")) {
            findNavController(R.id.nav_host_fragment_content_detalhes).navigate(R.id.navigation_ingredients_details)
        }
    }

    private fun setupToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
        supportActionBar?.elevation = 0f
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }


}