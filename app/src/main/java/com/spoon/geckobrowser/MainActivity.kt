package com.spoon.geckobrowser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoView

class MainActivity : AppCompatActivity() {

    private lateinit var geckoView: GeckoView
    private lateinit var geckoSession: GeckoSession
    private lateinit var geckoRuntime: GeckoRuntime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        geckoView = findViewById(R.id.geckoview)
        
        // Initialize the Gecko Engine
        geckoSession = GeckoSession()
        geckoRuntime = GeckoRuntime.create(this)
        
        // Open the session and link it to the visual view
        geckoSession.open(geckoRuntime)
        geckoView.setSession(geckoSession)
        
        // Load a test website
        geckoSession.loadUri("https://duckduckgo.com")
    }
}
