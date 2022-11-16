package br.com.hp_app.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import br.com.hp_app.R
import br.com.hp_app.databinding.ActivityDetalhesBinding

class DetalhesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configuraToolbar()

        configuraNavegacao()

    }

    private fun configuraNavegacao() {
        if (intent.hasExtra("elixirId")) {
            findNavController(R.id.nav_host_fragment_content_detalhes).navigate(R.id.navigation_elixirs_details)
        }else if (intent.hasExtra("housesId")) {
            findNavController(R.id.nav_host_fragment_content_detalhes).navigate(R.id.navigation_houses_details)
        }
    }

    private fun configuraToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
        supportActionBar?.elevation = 0f
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)
    }


}