package uz.yxdev.famouspersons.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import uz.yxdev.famouspersons.R
import uz.yxdev.famouspersons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.commit {
            add(R.id.fragment_container, MainScreen(), "MainScreen")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}