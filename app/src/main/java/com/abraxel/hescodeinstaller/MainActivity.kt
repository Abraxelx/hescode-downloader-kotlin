package com.abraxel.hescodeinstaller

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        MobileAds.initialize(this,getString(R.string.admob_app_id))
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = getString(R.string.admob_intersitiade_ad_id)
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        mInterstitialAd.adListener = object : AdListener(){
            override fun onAdLoaded() {
                mInterstitialAd.show()
                super.onAdLoaded()
            }
        }

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val mailIntent = Intent(Intent.ACTION_SENDTO);
            mailIntent.type = "text/plain";
            mailIntent.data = Uri.parse("mailto:");
            mailIntent.putExtra(Intent.EXTRA_EMAIL, "halilsahin.dev@gmail.com");
            startActivity(Intent.createChooser(mailIntent, "Send Email"));

        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                var url = "https://xelcode.blogspot.com.tr";
                var i = Intent(Intent.ACTION_VIEW);
                i.data = Uri.parse(url);
                startActivity(i);
                return true

            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}