package com.example.sources_sinks_android_api_35_taint_flow_examples

import android.adservices.customaudience.FetchAndJoinCustomAudienceRequest
import android.content.Context
import android.net.Uri
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkConstructor
import io.mockk.mockkStatic
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import java.io.File

class CustomAudienceViewModelTest {

   lateinit var customAudienceViewModel: CustomAudienceViewModel

    @get:Rule
    val tempFolder = TemporaryFolder()

    @Before
    fun setup() {
        mockkStatic(Uri::class)
        val mockUri = mockk<Uri>()

        every { Uri.parse("content://com.example.customaudience") } returns mockUri

        val mockRequest = mockk<FetchAndJoinCustomAudienceRequest>()
        every { mockRequest.name } returns "discount-seekers"

        val mockRequestBuilder = mockk<FetchAndJoinCustomAudienceRequest.Builder>()
        every { mockRequestBuilder.setName("discount-seekers") } returns mockRequestBuilder
        every { mockRequestBuilder.build() } returns mockRequest

        mockkConstructor(FetchAndJoinCustomAudienceRequest.Builder::class)
        every { anyConstructed<FetchAndJoinCustomAudienceRequest.Builder>().setName(any()) } returns mockRequestBuilder
        every { anyConstructed<FetchAndJoinCustomAudienceRequest.Builder>().build() } returns mockRequest

        customAudienceViewModel = CustomAudienceViewModel()
    }

    @Test
    fun testStoreCustomAudienceNameInExternalFileStorage() = runTest {
        val fakeExternalDir = tempFolder.newFolder("externalFiles")

        val context = mock<Context> {
            on { getExternalFilesDir(null) } doReturn fakeExternalDir
        }

        customAudienceViewModel.storeCustomAudienceNameInExternalFileStorage(context)

        val storedFile = File(fakeExternalDir, "installed_apps.xml")
        assertTrue("File should exist", storedFile.exists())
        assertEquals("discount-seekers", customAudienceViewModel.customAudienceName.value)
    }
}
