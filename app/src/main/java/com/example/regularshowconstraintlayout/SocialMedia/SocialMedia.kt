package com.example.regularshowconstraintlayout.SocialMedia

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.activity.addCallback
import com.example.regularshowconstraintlayout.R
import android.net.Uri



class SocialMedia : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val callback = requireActivity().onBackPressedDispatcher.addCallback {
            parentFragmentManager.popBackStack()
        }
        val view = inflater.inflate(R.layout.fragment_social_media, container, false)

        // Inflate the layout for this fragment
        val myImageButton: ImageButton = view.findViewById(R.id.twittB)
        val myImageButtons: ImageButton = view.findViewById(R.id.IGButton)
        val myImageButtonsss: ImageButton = view.findViewById(R.id.discordB)

        myImageButton.setOnClickListener {
            gotoUrl("https://twitter.com/")
        }
        myImageButtons.setOnClickListener {
            gotoUrl("https://twitter.com/")
        }
        myImageButtonsss.setOnClickListener {
            gotoUrl("https://twitter.com/")
        }
        return view




    }

    private fun gotoUrl(s: String) {

        val uri = Uri.parse(s)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }


    }
