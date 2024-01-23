package com.example.brandnewchat.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteApp(
//    summarizeViewModel: SummarizeViewModel,
    onNextButtonClicked:()->Unit = {},
    onNextButtonClickedTwo:()->Unit = {},

    ) {
    Scaffold (
        topBar = { TopAppBarOP() },
        bottomBar = { BottomBar() }
    ){innerPaddingValues ->

        Showshow(triggerNa = onNextButtonClicked,
            triggerNaTwo = onNextButtonClickedTwo)

    }



}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarOP(){
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())


    LargeTopAppBar(
        title = {
            Text(
                text ="New Chat",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis


            )
        },

        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null
                )
            }

        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )

        ,
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.FavoriteBorder,
                    contentDescription = "Localized description"
                )
            }
        },
        scrollBehavior = scrollBehavior,
        modifier = Modifier,


        )

}
@Composable
fun Showshow(modifier: Modifier = Modifier,
             triggerNa:()->Unit,
             triggerNaTwo: () -> Unit){
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ContentInBetween(navigateNa = triggerNa,navigateNaTwo = triggerNaTwo )
            Spacer(modifier = Modifier.padding(10.dp))
            ContentInBetween(navigateNa = triggerNa,navigateNaTwo = triggerNaTwo)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentInBetween(
    modifier: Modifier = Modifier,
    navigateNa: ()-> Unit,
    navigateNaTwo: () -> Unit
) {
    Row(
        modifier = Modifier,
    ) {
        Card(
            elevation = CardDefaults.cardElevation(16.dp),
            modifier = Modifier.size(128.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor =  MaterialTheme.colorScheme.primaryContainer,
            ),
            onClick = navigateNa
        ) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "professor",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                )
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Card(
            elevation = CardDefaults.cardElevation(16.dp),
            shape = RoundedCornerShape(16.dp),
            onClick = navigateNaTwo ,
            modifier = Modifier.size(128.dp),
            border = BorderStroke(2.dp, Color.Black),
            colors = CardDefaults.cardColors(
                containerColor =  MaterialTheme.colorScheme.primaryContainer,

            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "title ads",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 4.dp),
                    textAlign = TextAlign.End
                )
            }
        }
    }
}


@Composable
fun BottomBar(){
    BottomAppBar(
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(Icons.Filled.Check, contentDescription = "Localized description")
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.Edit,
                    contentDescription = "Localized description",
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.ShoppingCart,
                    contentDescription = "Localized description",
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.Build,
                    contentDescription = "Localized description",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* do something */ },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, "Localized description")
            }
        }
    )
}








