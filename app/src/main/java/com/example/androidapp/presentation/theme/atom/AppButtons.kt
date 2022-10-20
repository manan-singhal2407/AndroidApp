package com.example.androidapp.presentation.theme.atom

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.androidapp.presentation.theme.Primary10
import com.example.androidapp.presentation.theme.Primary60
import com.example.androidapp.presentation.theme.QuickSand
import com.example.androidapp.presentation.theme.elevation4dp
import com.example.androidapp.presentation.theme.height40dp
import com.example.androidapp.presentation.theme.padding24dp
import com.example.androidapp.presentation.theme.padding8dp
import com.example.androidapp.presentation.theme.radius12dp

@Composable
fun PrimaryButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.heightIn(height40dp),
        enabled = enabled,
        contentPadding = PaddingValues(
            horizontal = padding24dp,
            vertical = padding8dp
        ),
        border = null,
        shape = RoundedCornerShape(radius12dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Primary10,
            disabledContainerColor = Primary60,
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = elevation4dp
        )
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleSmall,
            color = Color.White,
            fontFamily = QuickSand
        )
    }
}