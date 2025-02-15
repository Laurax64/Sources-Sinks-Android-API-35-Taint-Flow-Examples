package com.example.sources_sinks_android_api_35_taint_flow_examples

import android.adservices.customaudience.FetchAndJoinCustomAudienceRequest
import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.util.Properties

class CustomAudienceViewModel() : ViewModel() {

    private var _customAudienceName = MutableStateFlow<String>("")
    val customAudienceName = _customAudienceName.asStateFlow()

    private var _filePath = MutableStateFlow<String>("")
    val filePath = _filePath.asStateFlow()

    /**
     * Creates an object of type FetchAndJoinCustomAudienceRequest with a fake fetch Uri and custom audience name
     * and sets the name of the [customAudienceName] a user might be added to.
     *
     * A custom audience is an abstract grouping of users with similar demonstrated interests.
     */
    fun getCustomAudienceName() {
        val builder = FetchAndJoinCustomAudienceRequest
            .Builder(Uri.parse("content://com.example.customaudience"))
            .setName("discount-seekers") // Sensitive user data
        val fetchAndJoinCustomAudienceRequest = builder.build()
        val name = fetchAndJoinCustomAudienceRequest.name ?: "" // Sensitive source
        viewModelScope.launch {
            _customAudienceName.emit(name)
        }
    }

    /**
     * Stores the given custom audience name to external file storage and sets the [filePath] where the name was stored.
     *
     * @see "https://developer.android.com/training/data-storage/files"
     *
     * @param context the context to use
     */
    fun storeCustomAudienceNameInExternalFileStorage(context: Context) {
        val externalDir = context.getExternalFilesDir(null) ?: return

        val file = File(externalDir, "installed_apps.xml")
        if (!file.exists()) {
            file.createNewFile()
        }
        getCustomAudienceName()
        var name = ""
        viewModelScope.launch {
            name = customAudienceName.last()
        }

        val outputStream = FileOutputStream(file, true)

        val properties = Properties()
        properties.setProperty("customAudienceName", name)
        properties.storeToXML(outputStream, name, Charsets.UTF_8) // Sensitive sink
        viewModelScope.launch {
            _filePath.emit(file.absolutePath)
        }
        Log.d("CustomAudienceViewModel", "File path: ${filePath.value}")
    }
}