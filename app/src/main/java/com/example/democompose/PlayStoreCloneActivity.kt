package com.example.democompose

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.InnerPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.democompose.data.model.playstore.BottomNavItem
import com.example.democompose.ui.DemoComposeTheme
import com.example.democompose.ui.typography

class PlayStoreCloneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoComposeTheme {
                PlayStoreCloneScreen()
            }
        }
    }
}

@Composable
fun PlayStoreCloneScreen() {
    val scaffoldState = rememberScaffoldState()
    val text = remember {
        mutableStateOf("")
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { PlayStoreTopAppBar(text) },
        bottomBar = { PlayStoreBottomNavigation() },
        bodyContent = { PlayStoreContent(it) }
    )
}

@Composable
fun PlayStoreBottomNavigation() {
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 10.dp
    ) {
        BottomNavItem.generate()
            .forEachIndexed { index, navItem ->
                BottomNavigationItem(
                    icon = { Icon(vectorResource(id = navItem.icon)) },
                    label = { Text(text = navItem.label) },
                    selected = index == 1,
                    onSelect = {}
                )
            }
    }
}

@Composable
fun PlayStoreContent(innerPadding: InnerPadding) {
    ScrollableColumn(contentPadding = innerPadding) {
        ScrollableTabRow(
            selectedTabIndex = 0,
            backgroundColor = Color.White
        ) {
            listOf(
                "For you",
                "Top charts",
                "Categories",
                "Editors' Choice",
                "Family",
                "Early access"
            ).forEachIndexed { index, title ->
                Tab(
                    selected = 0 == index,
                    onClick = {
                        Log.d("HELLO", title)
                    },
                    text = {
                        Text(
                            text = title,
                            style = typography.body2
                        )
                    }
                )
            }
        }

    }
}

@Composable
fun PlayStoreTopAppBar(text: MutableState<String>) {
    TopAppBar(
        backgroundColor = Color.White,
        title = {
            Surface(
                modifier = Modifier.padding(4.dp),
                elevation = 10.dp
            ) {
                TextField(
                    value = text.value,
                    backgroundColor = Color.White,
                    onValueChange = { text.value = it },
                    label = { Text("Search for apps & games") },
                    leadingIcon = { Icon(Icons.Filled.Menu) },
                    trailingIcon = { Icon(vectorResource(id = R.drawable.ic_mic)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(10.dp))
                )
            }
        }
    )
}

@Preview(
    showBackground = true,
    name = "Preview PlayStoreCloneScreen"
)
@Composable
fun PreviewPlayStoreCloneScreen() {
    PlayStoreCloneScreen()
}