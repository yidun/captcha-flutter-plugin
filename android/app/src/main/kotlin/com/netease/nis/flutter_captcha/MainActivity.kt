package com.netease.nis.flutter_captcha

import android.os.Bundle
import android.os.PersistableBundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    val METHOD_CHANNEL = "yd_captcha_flutter_method_channel"
    val EVENT_CHANNEL = "yd_captcha_flutter_event_channel"
    val SHOW_CAPTCHA = "showCaptcha"

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor, METHOD_CHANNEL).setMethodCallHandler { call, result ->
            if (SHOW_CAPTCHA.equals(call.method)) {
                CaptchaHelper.showCaptcha(this)
            }
        }
        EventChannel(flutterEngine.dartExecutor, EVENT_CHANNEL).setStreamHandler(object : EventChannel.StreamHandler {
            override fun onListen(arguments: Any?, events: EventChannel.EventSink?) {
                CaptchaHelper.events = events
            }

            override fun onCancel(arguments: Any?) {

            }

        })
    }
}
