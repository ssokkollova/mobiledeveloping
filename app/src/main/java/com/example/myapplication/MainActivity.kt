package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.screens.MainCard
import com.example.myapplication.screens.TabLayout
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import org.json.JSONObject
import com.example.myapplication.data.WeatherModel

const val API_KEY = "7f6eebb6101546f29f2122941242210"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val daysList = remember {
                    mutableStateOf(listOf<WeatherModel>())
                }
                val currentDay = remember {
                    mutableStateOf(WeatherModel(
                        "",
                        "",
                        "0.0",
                        "",
                        "",
                        "0.0",
                        "0.0",
                        "",
                    )
                    )
                }
                getData("London", this, daysList, currentDay)
                Image(
                    painter = painterResource(id = R.drawable.background_im),
                    contentDescription = "im1",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.7f),
                    contentScale = ContentScale.FillHeight
                )
                Column {
                    MainCard(currentDay)
                    TabLayout(daysList)
                }
            }
        }
    }
}



private fun getData(city: String, context: Context,
                    daysList: MutableState<List<WeatherModel>>,
                    currentDay: MutableState<WeatherModel>){
    val url = "https://api.weatherapi.com/v1/forecast.json?key=$API_KEY" +
            "&q=$city"+
            "&days=" +
            "3" +
            "&aqi=no&alerts=no\n"
        val queue = Volley.newRequestQueue(context)
        val sRequest = StringRequest(
            Request.Method.GET,
            url,
            { response ->
                val list = getWeatherByDays(response)
                currentDay.value = list[0]
                daysList.value = list
            },
            { Log.d("MyLog", "VolleyError $it")
            }
        )
        queue.add(sRequest)
    }
private fun getWeatherByDays(response: String): List<WeatherModel> {
    if (response.isEmpty()) return listOf()
    val list = ArrayList<WeatherModel>()
    val mainObject = JSONObject(response)
    val city = mainObject.getJSONObject("location").getString("name")
    val days = mainObject.getJSONObject("forecast").getJSONArray("forecastday")
    for (i in 0 until days.length()) {
        val item = days[i] as JSONObject
        list.add(
            WeatherModel(
                city,
                item.getString("date"),
                "",
                item.getJSONObject("day").getJSONObject("condition")
                    .getString("text"),
                item.getJSONObject("day").getJSONObject("condition")
                    .getString("icon"),
                item.getJSONObject("day").getString("maxtemp_c"),
                item.getJSONObject("day").getString("mintemp_c"),
                item.getJSONArray("hour").toString()
            )
        )
    }
    list[0] = list[0].copy(
        time = mainObject.getJSONObject("current").getString("last_updated"),
        currentTemp = mainObject.getJSONObject("current").getString("temp_c")
    )
    return list
}

