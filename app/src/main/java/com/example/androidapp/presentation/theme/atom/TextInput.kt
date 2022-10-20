package com.example.androidapp.presentation.theme.atom

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androidapp.presentation.theme.QuickSand
import com.example.androidapp.presentation.theme.elevation12dp
import com.example.androidapp.presentation.theme.radius12dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(
    hint: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(radius12dp),
        shadowElevation = elevation12dp
    ) {
        var inputText by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = inputText,
            onValueChange = {
                inputText = it
                onTextChange(inputText)
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            placeholder = {
                Text(
                    text = hint,
                    color = Color.LightGray,
                    fontSize = 13.sp,
                    fontFamily = QuickSand
                )
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontFamily = QuickSand,
                fontWeight = FontWeight.W500
            ),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = Color.White,
            )
        )
    }
}