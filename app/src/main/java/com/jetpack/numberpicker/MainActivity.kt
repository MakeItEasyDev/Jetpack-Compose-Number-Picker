package com.jetpack.numberpicker

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.jetpack.numberpicker.ui.theme.NumberPickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NumberPickerTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Number Picker",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    ) {
                        NumberPickerView()
                    }
                }
            }
        }
    }
}

@Composable
fun NumberPickerView() {
    val context = LocalContext.current

    ConstraintLayout(
        constraintSet = ConstraintSet {
            val layout = createRefFor("picker")

            constrain(layout) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.layoutId("picker"),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Horizontal Number Picker",
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .align(CenterHorizontally)
            )

            HorizontalNumberPicker(
                min = 10,
                max = 100,
                default = 50,
                onValueChange = { value ->
                    Toast.makeText(context, value.toString(), Toast.LENGTH_SHORT).show()
                }
            )

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Vertical Number Picker",
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .align(CenterHorizontally)
            )

            VerticalNumberPicker(
                min = 20,
                max = 30,
                default = 20,
                onValueChange = { value ->
                    Toast.makeText(context, value.toString(), Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

















