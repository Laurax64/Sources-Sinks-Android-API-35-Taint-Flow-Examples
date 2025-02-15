package com.example.sourcesSinksAndroidApi35TaintFlowExamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.sourcesSinksAndroidApi35TaintFlowExamples.ui.theme.SourcesSinksAndroidAPI35TaintFlowExamplesTheme

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
