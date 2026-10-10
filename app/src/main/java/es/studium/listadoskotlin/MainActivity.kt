package es.studium.listadoskotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        if (savedInstanceState == null) {
            // Load Empire by default
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, CharactersFragment.newInstance(CharactersFragment.FACTION_EMPIRE))
                .commit()
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_empire -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, CharactersFragment.newInstance(CharactersFragment.FACTION_EMPIRE))
                        .commit()
                    true
                }
                R.id.nav_rebels -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, CharactersFragment.newInstance(CharactersFragment.FACTION_REBELS))
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}
