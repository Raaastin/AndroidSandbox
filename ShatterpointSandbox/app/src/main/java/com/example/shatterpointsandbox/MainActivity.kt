package com.example.shatterpointsandbox

import KeyWords
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shatterpointsandbox.ui.theme.ShatterpointSandboxTheme
import com.example.shatterpointsandbox.ui.theme.UnitKeyWordsColor
import com.example.shatterpointsandbox.ui.theme.UnitNameColor
import com.example.shatterpointsandbox.ui.theme.UnitTypeColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShatterpointSandboxTheme {
                Scaffold (
                    topBar = {
                        Text(
                            "Insert Menu Here",
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Cyan)
                        )
                    },
                    bottomBar = {
                        UnitArray()
                    }
                ){innerPadding ->
                    Content(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun UnitList(modifier: Modifier = Modifier) {
    var data = UnitDatabaseService().unitList

    Column (modifier = modifier){
        data.forEach { unit ->
            UnitRow(unit.name, unit.type, unit.keyWords)
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
fun UnitRow(unitName: String, type: UnitType, keyWords: List<String>, modifier: Modifier = Modifier){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ){
        ProfilePicture(
            resourceId = R.drawable.untitled,
            left = -12,
            top = 6,
            modifier = Modifier
                .padding(8.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
        ){
            Text(
                text = unitName,
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = UnitNameColor
            )
            Text(
                type.toString(),
                modifier = Modifier,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                color = UnitTypeColor
            )
            Text(
                keyWords.joinToString(),
                modifier = Modifier,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = UnitKeyWordsColor
            )
        }
        IconButton(
            modifier = Modifier
                .padding(4.dp),
            onClick = { },

        ){
            Icon(
                painter = painterResource(id = R.drawable.card_detail),
                contentDescription = "detail button",
                tint = UnitNameColor
            )
        }
    }
}

@Composable
fun Content(modifier : Modifier = Modifier){
    Surface (
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ){
        UnitList()
    }
}

@Composable
fun UnitArray(modifier: Modifier = Modifier){
    Row (
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        ProfilePicture(
            resourceId = R.drawable.untitled,
            left = -12,
            top = 6
        )
        ProfilePicture(
            resourceId = R.drawable.untitled,
            left = -12,
            top = 6
        )
        ProfilePicture(
            resourceId = R.drawable.untitled,
            left = -12,
            top = 6
        )
        ProfilePicture(
            resourceId = R.drawable.untitled,
            left = -12,
            top = 6
        )
        ProfilePicture(
            resourceId = R.drawable.untitled,
            left = -12,
            top = 6
        )
        ProfilePicture(
            resourceId = R.drawable.untitled,
            left = -12,
            top = 6
        )
    }
}


@Composable
fun ProfilePicture(resourceId: Int, left: Int, top: Int, modifier: Modifier = Modifier) {
    val painter = painterResource(id = resourceId)
    Image(
        painter = painter,
        contentDescription = "example",
        modifier = modifier
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
        UnitRow("kalany", UnitType.Secondary, listOf(KeyWords.BattleDroid, KeyWords.Droid, KeyWords.SeparatistAlliance))
    }
}