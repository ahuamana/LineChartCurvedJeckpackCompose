package com.paparazziteam.cryptoserviceapp.modules

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paparazziteam.cryptoserviceapp.R
import com.paparazziteam.cryptoserviceapp.ui.theme.CryptoServiceAppTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {

        }
    ) {
        //Content
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(modifier = Modifier.background(Color.Transparent)) {
                //card with image
                Row(
                    modifier = Modifier
                        .background(Color.Red)
                ) {
                    Card(
                        shape = RoundedCornerShape(150.dp),
                        modifier = Modifier.padding(2.dp).height(50.dp).width(150.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(5.dp)
                        ){
                            Image(painter = painterResource(id = R.drawable.ic_litecoin), contentDescription = "lite coin")
                        }

                    }
                    //text
                    Box(modifier = Modifier.align(Alignment.CenterVertically)) {
                        Text(
                            text = "32.046 ETH",
                            modifier = Modifier
                                .background(Color.Red)
                                .padding(horizontal = 5.dp),
                            fontSize = 10.sp
                        )
                    }

                }

            }

            //floatingActionButton
            FloatingActionButton(onClick = { /*TODO*/ }, shape = RoundedCornerShape(50.dp), modifier = Modifier.size(50.dp)) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }

        }
    }
    
}

@Preview
@Composable
fun HomeScreenPrev() {
    CryptoServiceAppTheme() {
        HomeScreen()
    }
}