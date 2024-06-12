package com.example.shatterpointsandbox

import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clipScrollableContainer
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Recomposer
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shatterpointsandbox.ui.theme.ShatterpointSandboxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShatterpointSandboxTheme {
                Page()
            }
        }
    }
}

@Composable
fun UnitList(unit: List<String>, modifier: Modifier = Modifier) {
    Column (modifier = modifier){
        unit.forEach { unitName ->
            UnitRow(unitName)
        }
    }
}

private fun GenerateList(): List<String>
{
    val list = listOf(
        "Fowler", "Beck", "Evans", "Fowler", "Beck", "Evans",
        "Fowler", "Beck", "Evans", "Fowler", "Beck", "Evans",
        "Fowler", "Beck", "Evans", "Fowler", "Beck", "Evans",
        "Fowler", "Beck", "Evans", "Fowler", "Beck", "Evans",
        "Fowler", "Beck", "Evans", "Fowler", "Beck", "Evans",
        "Fowler", "Beck", "Evans", "Fowler", "Beck", "Evans",
        "Fowler", "Beck", "Evans", "Fowler", "Beck", "Evans",
        "Fowler", "Beck", "Evans", "Fowler", "Beck", "Evans",
        "Fowler", "Beck", "Evans", "Fowler", "Beck", "Evans",
        "Fowler", "Beck", "Evans", "Fowler", "Beck", "Evans",
        "Fowler", "Beck", "Evans", "Fowler", "Beck", "Evans")
    return list
}

@Composable
fun UnitRow(unitName: String, modifier: Modifier = Modifier){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        ProfilePicture(
            resourceId = R.drawable.untitled,
            left = -12,
            top = 6,
            modifier = Modifier
                .weight(1f)
        )
        Text(
            unitName,
            modifier = Modifier
                .padding(8.dp)
                .weight(1f)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
        ) {
            
        }
    }
}

@Composable
fun Page(modifier : Modifier = Modifier){
    Column {
        Surface (
            color = Color.Gray,
            modifier = modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .weight(10f)
        ){
            UnitList(GenerateList())
        }
        UnitArray(
            modifier.weight(1f)
        )
    }
}

@Composable
fun UnitArray(modifier: Modifier = Modifier){
    Row (
        modifier = modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        ProfilePicture(
            resourceId = R.drawable.untitled,
            left = -12,
            top = 6,
            modifier = modifier
                .weight(1f)
        )
        ProfilePicture(
            resourceId = R.drawable.untitled,
            left = -12,
            top = 6,
            modifier = modifier
                .weight(1f)
        )
        ProfilePicture(
            resourceId = R.drawable.untitled,
            left = -12,
            top = 6,
            modifier = modifier
                .weight(1f)
        )
        ProfilePicture(
            resourceId = R.drawable.untitled,
            left = -12,
            top = 6,
            modifier = modifier
                .weight(1f)
        )
        ProfilePicture(
            resourceId = R.drawable.untitled,
            left = -12,
            top = 6,
            modifier = modifier
                .weight(1f)
        )
        ProfilePicture(
            resourceId = R.drawable.untitled,
            left = -12,
            top = 6,
            modifier = modifier
                .weight(1f)
        )
    }
}


@Composable
fun ProfilePicture(resourceId: Int, left: Int, top: Int, modifier: Modifier = Modifier) {
    val painter = painterResource(id = resourceId)
    Image(
        painter = painter,
        contentDescription = "example",
        modifier = Modifier
            .size(50.dp)
            .clip(RoundedCornerShape(percent = 50))
            .scale(5f)
            .offset(x = left.dp, y = top.dp)
    )
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    ShatterpointSandboxTheme {
        Page()
    }
}