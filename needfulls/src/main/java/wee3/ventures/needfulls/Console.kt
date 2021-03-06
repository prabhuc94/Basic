/*
 * *
 *  * Created by Prabhu Chandran on 3/15/19 12:18 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 3/15/19 12:18 PM
 *
 */

package wee3.ventures.needfulls

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.annotation.Nullable

object Console {
    enum class LOG{
        Debug,Error,Info,Warn,Verbose
    }
    @SuppressLint("LogNotTimber")
    fun log(@Nullable TAG : String = BuildConfig.APPLICATION_ID, @Nullable activity: Activity? = null, message : Any, @Nullable throwable: Throwable? = null, type : LOG = LOG.Error){
        @Suppress("NAME_SHADOWING") val TAG : String? = if (activity != null){
            activity::class.java.simpleName
        } else {
            TAG
        }
        if (BuildConfig.DEBUG){
            when (type){
                LOG.Error->{
                    if (throwable == null) {
                        Log.e(TAG, "$message")
                    } else {
                        Log.e(TAG, "$message",throwable)
                    }
                }
                LOG.Debug->{
                    if (throwable == null) {
                        Log.d(TAG,"$message")
                    } else {
                        Log.d(TAG,"$message",throwable)
                    }
                }
                LOG.Info->{
                    if (throwable == null) {
                        Log.i(TAG,"$message")
                    } else {
                        Log.i(TAG,"$message",throwable)
                    }
                }
                LOG.Verbose->{
                    if (throwable == null) {
                        Log.v(TAG,"$message")
                    } else {
                        Log.v(TAG,"$message",throwable)
                    }
                }
                LOG.Warn->{
                    if (throwable == null) {
                        Log.w(TAG,"$message")
                    } else {
                        Log.w(TAG,"$message",throwable)
                    }
                }
            }
        }
    }
}