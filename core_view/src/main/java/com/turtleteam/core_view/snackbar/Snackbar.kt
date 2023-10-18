package com.turtleteam.core_view.snackbar

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.res.painterResource
import com.turtleteam.core_view.R

@Composable
fun SnackbarView(text: String, closeButton: Boolean = false) {
    Snackbar {
        Row {
            Text(text = "Пользователь с таким логином уже существует")
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Войти")
            }
            if (closeButton){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_close), contentDescription = "Закрыть")
                }
            }
        }
    }
}