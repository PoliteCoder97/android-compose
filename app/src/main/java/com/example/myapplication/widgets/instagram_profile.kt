package com.example.myapplication.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.myapplication.ui.theme.ButtonBlue
import com.example.myapplication.ui.theme.TextBlack
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

@Preview(showBackground = true)
@Composable()
fun InstagramProfile() {
    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        buildAppbar()
        Spacer(modifier = Modifier.height(16.dp))
        buildHeader()
        Spacer(modifier = Modifier.height(16.dp))
        buildBody()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Bio",
            style = MaterialTheme.typography.headlineSmall
                .copy(color = TextBlack)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray)
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "PoliteCoder that Called Mohammad is The Best Mobile Application Developer we know ever for all times",
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography
                    .bodyMedium,
                lineHeight = 20.sp
            )
        }
    }
}

@Composable()
private fun buildBody() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "PoliteCoder",
            style = MaterialTheme.typography.headlineLarge
                .copy(
                    color = TextBlack
                )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "San Fransisco, CA",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "28",
                    style = MaterialTheme.typography.headlineLarge
                        .copy(
                            color = TextBlack
                        )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Posts",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "110",
                    style = MaterialTheme.typography.headlineLarge
                        .copy(
                            color = TextBlack
                        )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Followers",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "58",
                    style = MaterialTheme.typography.headlineLarge
                        .copy(
                            color = TextBlack
                        )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Folowwing",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        Spacer(Modifier.height(24.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp),
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(180.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonBlue
                )
            ) {
                Text(
                    text = "Make a post"
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp),
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(180.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray
                )
            ) {
                Text(
                    text = "Edit Profile"
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Box(
                modifier = Modifier
                    .width(36.dp)
                    .height(36.dp)
                    .clip(RoundedCornerShape(360.dp))
                    .background(Color.LightGray)
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                FaIcon(
                    faIcon = FaIcons.ChevronDown,
                    tint = Color.Black,
                    size = 20.dp
                )
            }
        }
    }
}

@Composable()
private fun buildHeader() {
    Box {
        Box {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .allowHardware(false)
                    .data("https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&h=750&w=1260")
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(16.dp)),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                Spacer(Modifier.weight(1f))
                Row(
                    Modifier.fillMaxWidth()
                ) {
                    Spacer(Modifier.weight(1f))
                    IconButton(onClick = { /*TODO*/ }) {
                        FaIcon(FaIcons.Edit, tint = Color.White)
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .clip(RoundedCornerShape(360.dp))
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .allowHardware(false)
                        .data("https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&h=750&w=1260")
                        .build(),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable()
private fun buildAppbar() {
    var txtSearch by remember {
        mutableStateOf("")
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.Center
    ) {
        FaIcon(faIcon = FaIcons.ChevronLeft)
        Spacer(modifier = Modifier.width(16.dp))
        Box(
            modifier = Modifier
                .weight(weight = 1f)
                .height(33.dp)
                .clip(shape = RoundedCornerShape(180.dp))
                .background(Color.LightGray)
                .padding(horizontal = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicTextField(
                    modifier = Modifier.weight(1f),
                    value = txtSearch,
                    onValueChange = {
                        txtSearch = it
                    },
                    textStyle = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
                    decorationBox = { innerTextField ->
                        Row(modifier = Modifier.fillMaxWidth()) {
                            if (txtSearch.isEmpty()) {
                                Text(
                                    text = "Search",
                                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black)
                                )
                            }
                        }
                        innerTextField()
                    }
                )
                FaIcon(
                    faIcon = FaIcons.Search,
                    modifier = Modifier.background(Color.Transparent),
                    tint = Color.Gray,
                    size = 20.dp
                )
            }
        }

    }
}