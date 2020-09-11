package com.example.democompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Box
import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.democompose.data.model.playstore.AppItem
import com.example.democompose.ui.DemoComposeTheme
import com.example.democompose.ui.typography

class PlayStoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoComposeTheme {
                PlayStoreScreen()
            }
        }

    }
}

@Composable
fun AppItemLayout(appItem: AppItem) {
    Column {
        Box(
            backgroundColor = Color.Gray,
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .clip(shape = RoundedCornerShape(8.dp))
        )
        Text(
            text = appItem.name,
            style = typography.body2
        )
        Text(
            text = "${appItem.size} MB",
            style = typography.body2,
            color = Color.Gray
        )
    }
}

@Preview(
    name = "Preview App Item Layout",
    showBackground = true
)
@Composable
fun PreviewAppItemLayot() {
    AppItemLayout(appItem = AppItem.generate()[0])
}


@Composable
fun PlayStoreScreen() {
    val scaffoldState = rememberScaffoldState()
    val text = remember {
        mutableStateOf("")
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
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
        },
        bodyContent = { innerPadding ->
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
                            onClick = {},
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
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
                elevation = 10.dp
            ) {
                BottomNavigationItem(
                    icon = { Icon(vectorResource(id = R.drawable.ic_games)) },
                    label = { Text(text = "Games") },
                    selected = false,
                    onSelect = {}
                )
                BottomNavigationItem(
                    icon = { Icon(vectorResource(id = R.drawable.ic_apps)) },
                    label = { Text(text = "Apps") },
                    selected = true,
                    onSelect = {}
                )
                BottomNavigationItem(
                    icon = { Icon(vectorResource(id = R.drawable.ic_movies)) },
                    label = { Text(text = "Movies") },
                    selected = false,
                    onSelect = {}
                )
                BottomNavigationItem(
                    icon = { Icon(vectorResource(id = R.drawable.ic_books)) },
                    label = { Text(text = "Books") },
                    selected = false,
                    onSelect = {}
                )
            }
        }
    )
}

@Preview(
    showBackground = true,
    name = "Preview PlayStore Screen"
)
@Composable
fun PreviewPlayStoreScreen() {
    PlayStoreScreen()
}
