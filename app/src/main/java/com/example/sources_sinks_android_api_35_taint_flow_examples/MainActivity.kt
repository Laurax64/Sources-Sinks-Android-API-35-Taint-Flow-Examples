package com.example.sources_sinks_android_api_35_taint_flow_examples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.sources_sinks_android_api_35_taint_flow_examples.ui.theme.SourcesSinksAndroidAPI35TaintFlowExamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SourcesSinksAndroidAPI35TaintFlowExamplesTheme {
                CustomAudienceScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SourcesSinksAndroidAPI35TaintFlowExamplesTheme {
        CustomAudienceScreen()
    }
}