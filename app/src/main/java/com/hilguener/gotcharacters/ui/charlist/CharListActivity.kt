package com.hilguener.gotcharacters.ui.charlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hilguener.gotcharacters.R
import com.hilguener.gotcharacters.ui.charinfo.CharInfoActivity
import kotlinx.android.synthetic.main.activity_charlist.*

class CharListActivity : AppCompatActivity(){

    private lateinit var viewModel: CharListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charlist)

        viewModel = ViewModelProvider(this).get(CharListViewModel::class.java)

        initUI()
    }
    private fun initUI(){
        charlistRecyclerView.layoutManager = LinearLayoutManager(this)
        charlistRecyclerView.adapter = CharListAdapter{
            val intent = Intent(this, CharInfoActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }
        viewModel.getCharList()

        viewModel.charList.observe(this, Observer { list ->
            (charlistRecyclerView.adapter as CharListAdapter).setData(list)
        }
        )
    }
}