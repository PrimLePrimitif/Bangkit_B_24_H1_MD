package com.example.a_i_vv_rv

import android.content.ContextWrapper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a_i_vv_rv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dataset: ArrayList<Song> = defineStatelessData()
        val mainAdapter: MainAdapter = MainAdapter(dataset, ::handleRvOnClick)
        binding.mainRv.adapter = mainAdapter
        binding.mainRv.layoutManager = LinearLayoutManager(this)
        handleButtonClick()
    }

    private fun handleRvOnClick(song: Song): Unit {
        Toast.makeText(this, song.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun handleButtonClick() {
        binding.vvActivityBtn.setOnClickListener {
            val intent = Intent(this, MainActivity_VV::class.java)
            startActivity(intent)
        }
        Log.d("Println","Context Activity : $this.baseContext.toString()")
        Log.d("Println","Context ViewGroup : ${binding.root.context.toString()}")
        Log.d("Println","Context Button : ${binding.vvActivityBtn.context.toString()}")
        Log.d("Println","Context Button Base : ${(binding.vvActivityBtn.context as ContextWrapper).baseContext}")
    }


    private fun defineStatelessData(): ArrayList<Song> {
        val songData_1: Song = Song(1,"Neon Nights", "Synthwave Sensation")
        val songData_2: Song = Song(2,"Digital Dreams", "Cyberbeat Collective")
        val songData_3: Song = Song(3,"Galactic Groove", "Stellar Synths")
        val songData_4: Song = Song(4,"Retro Reverie", "Vintage Vibes")
        val songData_5: Song = Song(5,"Future Funk", "Groove Galaxy")
        val songData_6: Song = Song(6,"Cosmic Cruise", "Interstellar Beats")
        val songData_7: Song = Song(7,"Electric Euphoria", "Voltage Visionaries")
        val songData_8: Song = Song(8,"Synthetic Serenade", "Digital Dreamers")
        val songData_9: Song = Song(9,"Cybernetic Cadence", "Tech-tonic Beats")
        val songData_10: Song = Song(10,"Pixel Pulse", "Retro Rhythms")
        return arrayListOf(songData_1, songData_2, songData_3, songData_4,
            songData_5, songData_6, songData_7, songData_8, songData_9,
            songData_10)
    }
}

