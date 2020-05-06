package com.example.uber2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.FirebaseError
import com.google.firebase.database.ValueEventListener
import com.example.uber2.modelo.DespensaFirebase
import com.example.uber2.modelo.Item

class MainActivity : AppCompatActivity() {

    private val despensaFirebase : DespensaFirebase = DespensaFirebase()
    private var itemLast: Item = Item()
    private var mutableList: MutableList<Item> = mutableListOf<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun consulta(view: View){
        despensaFirebase.obtenTodos()
    }
    override fun onResume() {
        super.onResume()
    }
}