package com.vitzrotech.vipam3500

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

@Composable
fun AboutScreen() {
    LazyColumn (
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        //Row(Modifier.fillMaxWidth()) {
            //Text(
                //Modifier
                    //.weight(1f)
                    //.height(40.dp)
                    //.border(0.6.dp, Color.Black),
                //"VIPAM 3500"
            //)
        //}
    }
}

@Composable
@Preview
fun AboutScreenPreview() {
    VIPAM3500Theme {
        AboutScreen()
    }
}