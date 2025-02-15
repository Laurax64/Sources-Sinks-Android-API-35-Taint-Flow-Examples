package com.example.sources_sinks_android_api_35_taint_flow_examples

import android.content.Context
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class CustomAudienceViewModelTest {
    private val customAudienceViewModel: CustomAudienceViewModel = CustomAudienceViewModel()

    @Test
    fun testStoreCustomAudienceNameInExternalFileStorage() =
        runTest {
            val mockContext = mock<Context>()
            customAudienceViewModel.storeCustomAudienceNameInExternalFileStorage(mockContext)
            val filePath = customAudienceViewModel.filePath.value
            assert(filePath.isNotEmpty()) { "File path should not be empty" }
            assertEquals("discount-seekers", customAudienceViewModel.customAudienceName.value)
            verify(mockContext).getExternalFilesDir(null)
        }
}
