package com.spoon.geckobrowser

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoView

class MainActivity : AppCompatActivity() {

    private lateinit var geckoView: GeckoView
    private lateinit var geckoSession: GeckoSession
    private lateinit var geckoRuntime: GeckoRuntime
    private lateinit var urlBar: EditText
    private lateinit var goButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        geckoView = findViewById(R.id.geckoview)
        urlBar = findViewById(R.id.url_bar)
        goButton = findViewById(R.id.go_button)
        
        geckoSession = GeckoSession()
        geckoRuntime = GeckoRuntime.create(this)
        
        geckoSession.open(geckoRuntime)
        geckoView.setSession(geckoSession)
        
        loadUrl("https://duckduckgo.com")

        goButton.setOnClickListener {
            loadUrl(urlBar.text.toString())
        }

        urlBar.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                loadUrl(urlBar.text.toString())
                true
            } else {
                false
            }
        }
    }

    private fun loadUrl(url: String) {
        val finalUrl = if (!url.startsWith("http://") && !url.startsWith("https://")) {
            "https://$url"
        } else {
            url
        }
        geckoSession.loadUri(finalUrl)
        urlBar.setText(finalUrl)
    }
}
