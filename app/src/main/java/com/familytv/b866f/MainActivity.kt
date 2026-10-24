package com.familytv.b866f
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import android.graphics.Color
import android.view.Gravity
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        val root = FrameLayout(this)
        val bg = ImageView(this).apply { 
            setImageResource(R.drawable.wallpaper)
            scaleType = ImageView.ScaleType.CENTER_CROP 
        }
        root.addView(bg, FrameLayout.LayoutParams(-1,-1))
        val side = LinearLayout(this).apply { 
            orientation=LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#AA000000"))
            setPadding(40,80,40,80) 
        }
        side.addView(TextView(this).apply { 
            text="Google TV\nFamily"
            setTextColor(Color.WHITE)
            textSize=22f
            setPadding(0,0,0,40) 
        })
        for ((a,b) in listOf("Home" to packageName,"YouTube" to "com.google.android.youtube.tv","Netflix" to "com.netflix.ninja","Plex" to "com.plexapp.android")) {
            side.addView(TextView(this).apply { 
                text=a
                setTextColor(Color.WHITE)
                textSize=18f
                setPadding(0,30,0,30)
                isFocusable=true
                setOnClickListener{ 
                    try{startActivity(packageManager.getLaunchIntentForPackage(b)!!)}catch(e:Exception){} 
                } 
            })
        }
        root.addView(side, FrameLayout.LayoutParams(400,-1).apply { gravity=Gravity.START })
        setContentView(root)
    }
}
