package br.com.hp_app.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.com.hp_app.R
import br.com.hp_app.databinding.ActivityDetalhesBinding
import com.google.android.material.snackbar.Snackbar

class DetalhesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("elixirId")) {
            findNavController(R.id.nav_host_fragment_content_detalhes).navigate(R.id.navigation_elixirs_details)
        }

    }


}