package uz.gameuz.tictactoe.ui

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.gameuz.tictactoe.R
import uz.gameuz.tictactoe.broadcast.InternetBroadcastReceiver
import uz.gameuz.tictactoe.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater,container,false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        countDownTimer()
    }

    private fun countDownTimer() {
        object : CountDownTimer(4000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                openRegisterFragment()
            }
        }.start()
    }

    private fun openRegisterFragment() {
        findNavController().navigate(R.id.action_splashFragment_to_homeFragment)

    }
}