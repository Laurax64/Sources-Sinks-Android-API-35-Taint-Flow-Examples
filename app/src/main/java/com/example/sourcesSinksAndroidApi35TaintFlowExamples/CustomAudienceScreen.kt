package com.example.sourcesSinksAndroidApi35TaintFlowExamples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.sourcesSinksAndroidApi35TaintFlowExamples.ui.theme.SourcesSinksAndroidAPI35TaintFlowExamplesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAudienceScreen(
    modifier: Modifier = Modifier,
    customAudienceViewModel: CustomAudienceViewModel =
        CustomAudienceViewModel(),
) {
    val context = LocalContext.current
    val filePath by customAudienceViewModel.filePath.collectAsStateWithLifecycle()
    val customAudienceName by customAudienceViewModel.customAudienceName.collectAsStateWithLifecycle()
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("Custom Audience to External Storage ")
                },
            )
        },
    ) {
        Column(
            modifier =
                modifier
                    .padding(it)
                    .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            OutlinedButton(
                onClick = {
                    customAudienceViewModel
                        .storeCustomAudienceNameInExternalFileStorage(context)
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Store custom audience name")
            }
            Text("Custom audience name: $customAudienceName")
            Text("File stored at: $filePath")
        }
    }
}

@Preview
@Composable
fun PreviewInstalledAppsScreen() {
    SourcesSinksAndroidAPI35TaintFlowExamplesTheme {
        CustomAudienceScreen()
    }
}
