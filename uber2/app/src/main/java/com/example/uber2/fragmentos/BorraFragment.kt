package com.example.uber2.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.uber2.R
import com.example.uber2.modelo.DespensaFirebase
import kotlinx.android.synthetic.main.fragment_borra.*

class BorraFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_borra, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        borra_button.setOnClickListener {
            val despensaFirebase = DespensaFirebase()
            despensaFirebase.borraTodosLosItems()
        }
    }

}
