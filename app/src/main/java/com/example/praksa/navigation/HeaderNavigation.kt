package com.example.praksa.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import com.example.praksa.AppState

@Composable
fun HeaderNavigation(
    navigation: AppState.Navigation,
    onClick: (AppState.Navigation.Page) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.large.copy(
                    topStart = CornerSize(0),
                    topEnd = CornerSize(0)
                )
            )
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        navigation.navItems.forEach {
            val isSelected = it.title == navigation.selectedPage.title
            val weight = if (isSelected) FontWeight.Normal else FontWeight.Light
            Text(
                text = it.title,
                fontWeight = weight,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .clickable { onClick(it) }
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = MaterialTheme.shapes.medium
                    )
//                    .thenIf(isSelected) {
//                        Modifier.border(
//                            width = 1.dp,
//                            color = MaterialTheme.colors.onSurface,
//                            shape = MaterialTheme.shapes.medium
//                        )
//                    }
                    .padding(horizontal = 24.dp, vertical = 8.dp)
            )
        }
    }
}