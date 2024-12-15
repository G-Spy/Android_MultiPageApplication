package fr.epita.multi_page_application

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Handle image click to open a URL
        val epitaLogoImageView : ImageView = findViewById(R.id.activity_main_img_logo)
        epitaLogoImageView.setOnClickListener {
            val implicitIntent : Intent = Intent (Intent.ACTION_VIEW)
            implicitIntent.data = Uri.parse("https://www.epita.fr")
            startActivity(implicitIntent)

        }

        // Handle button click to navigate to MainActivity2
        val gotoPage2Button: Button = findViewById (R.id.activity_main_btn_goto2)
        gotoPage2Button.setOnClickListener{
            val explicitIntent = Intent( this@MainActivity, Page2Activity::class.java)
            val messageEditText : EditText = findViewById(R.id.activity_main_edit_message)
            val message : String = messageEditText.text.toString()
            explicitIntent.putExtra("MESSAGE", message)
            startActivity(explicitIntent)
        }

    }
}
