package com.hilguener.gotcharacters.ui.charinfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.hilguener.gotcharacters.R
import kotlinx.android.synthetic.main.activity_charinfo.*

class CharInfoActivity: AppCompatActivity() {

    lateinit var viewModel: CharInfoViewModel

    override fun onCreate (savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charinfo)

        viewModel = ViewModelProvider(this).get(CharInfoViewModel::class.java)
        initUI()
    }

    private fun initUI(){
        val id = intent.extras?.get("id") as Int

        viewModel.getCharInfo(id)

        viewModel.charInfo.observe(this, Observer { char ->
            nameTextView.text = char.firstName
            titleTextView.text = "Título: ${char.title}"
            familyTextView.text = "Familia: ${char.family}"

            Glide.with(this).load(char.imageUrl).into(imageView)
        })
    }
}
