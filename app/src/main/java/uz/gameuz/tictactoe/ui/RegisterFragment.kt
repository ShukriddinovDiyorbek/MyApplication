package uz.gameuz.tictactoe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import uz.gameuz.tictactoe.R
import uz.gameuz.tictactoe.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var reference : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        initViews()
        return binding.root
    }

    private fun initViews() {

        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("users")


        binding.btnregister.setOnClickListener {
            val name = binding.tvname.text.toString()
            val number = binding.tvnumber.text.toString()
            if (name.isNotEmpty() && number.isNotEmpty()){
                reference.setValue(name)
                openHomeFragment()
            } else {
                Toast.makeText(requireContext(), "To'liq to'ldiring", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openHomeFragment() {
        findNavController().navigate(R.id.homeFragment)
    }
}