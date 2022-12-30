package com.dominando.android.customview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dominando.android.customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.jogoDaVelha.listener = object : JogoDaVelhaView.JogoDaVelhaListener {
            override fun fimDeJogo(vencedor: Int) {
                val mensagem = when (vencedor) {
                    JogoDaVelhaView.XIS -> "X venceu"
                    JogoDaVelhaView.BOLA -> "O venceu"
                    else -> "Empatou"
                }
                Toast.makeText(this@MainActivity, mensagem, Toast.LENGTH_LONG).show()
            }
        }
        binding.button.setOnClickListener {
            binding.jogoDaVelha.reiniciarJogo()
        }
    }
}

