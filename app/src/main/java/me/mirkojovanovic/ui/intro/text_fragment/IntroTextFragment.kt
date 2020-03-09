package me.mirkojovanovic.ui.intro.text_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.mirkojovanovic.R

private const val HEADLINE_KEY = "headline"
private const val DESCRIPTION_KEY = "description"

class IntroTextFragment : Fragment() {

    private val viewModel: IntroTextViewModel by lazy {
        ViewModelProvider(this).get(IntroTextViewModel::class.java)
    }

    companion object {
        fun newInstance(headline: String?, description: String?) = IntroTextFragment().apply {
            arguments = Bundle().apply {
                putString(HEADLINE_KEY, headline)
                putString(DESCRIPTION_KEY, description)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.intro_text_fragment, container, false)

        val headlineTextView = view.findViewById<TextView>(R.id.intro_headline)

        headlineTextView.text = arguments?.getString(HEADLINE_KEY)

        val descriptionTextView = view.findViewById<TextView>(R.id.intro_description)
        descriptionTextView.text = arguments?.getString(DESCRIPTION_KEY)

        return view
    }

}
