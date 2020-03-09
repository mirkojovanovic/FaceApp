package me.mirkojovanovic.ui.intro.button_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider

import me.mirkojovanovic.R

private const val BUTTON_RED_KEY = "button_red"
private const val BUTTON_BLUE_KEY = "button_blue"

class IntroButtonFragment : Fragment() {

    private val viewModel: IntroButtonViewModel by lazy {
        ViewModelProvider(this).get(IntroButtonViewModel::class.java)
    }

    companion object {
        fun newInstance(redButtonText: String?, blueButtonText: String?) = IntroButtonFragment().apply {
            arguments = Bundle().apply {
                putString(BUTTON_RED_KEY, redButtonText)
                putString(BUTTON_BLUE_KEY, blueButtonText)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.intro_button_fragment, container, false)

        val redButton: Button = view.findViewById(R.id.intro_action_button_red)

        redButton.text = arguments?.getString(BUTTON_RED_KEY)

        val blueButton: Button = view.findViewById(R.id.intro_action_button_blue)
        blueButton.text = arguments?.getString(BUTTON_BLUE_KEY)

        return view
    }

}
