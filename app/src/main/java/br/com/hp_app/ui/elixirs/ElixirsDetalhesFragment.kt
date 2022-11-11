package br.com.hp_app.ui.elixirs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.hp_app.databinding.FragmentDetalhesElixirsBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ElixirsDetalhesFragment : Fragment() {

    private var _binding: FragmentDetalhesElixirsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetalhesElixirsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val elixirId = requireActivity().intent.getStringExtra("elixirId")

        binding.textviewSecond.text = elixirId

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}