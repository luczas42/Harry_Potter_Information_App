package br.com.hp_app.ui.elixirs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.hp_app.databinding.FragmentElixirsBinding
import br.com.hp_app.ui.viewmodel.ElixirsViewModel
import org.w3c.dom.Text

class ElixirsFragment : Fragment() {

    private var _binding: FragmentElixirsBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val elixirsViewModel =
            ViewModelProvider(this).get(ElixirsViewModel::class.java)

        _binding = FragmentElixirsBinding.inflate(inflater, container, false)
        val root: View = binding.root



        elixirsViewModel.text.observe(viewLifecycleOwner) {
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}