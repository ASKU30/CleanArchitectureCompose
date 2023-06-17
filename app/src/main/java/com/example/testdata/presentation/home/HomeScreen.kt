package com.example.testdata.presentation.home


import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.testdata.R
import com.example.domain.util.Result
import com.example.testdata.presentation.components.MovieListItem
import com.example.testdata.presentation.components.ProgressBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colorScheme.background
    val titleColor = MaterialTheme.colorScheme.primary
    val topAppbarBackgroundColor = TopAppBarDefaults.smallTopAppBarColors()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = stringResource(R.string.app_name), color = titleColor)
            },
            colors = topAppbarBackgroundColor
        )
    }){paddingValues ->
           when(val movieResponse = viewModel.movieState.value) {
               is Result.Loading -> ProgressBar()
               is Result.Error -> Toast.makeText(
                   LocalContext.current,
                   stringResource(R.string.toast_error),
                   Toast.LENGTH_SHORT
               ).show()
               is Result.Success -> LazyColumn(
                   contentPadding = paddingValues
               ) {
                   movieResponse.data?.let { movieList ->
                       items(
                           items = movieList.movies,
                           itemContent = {
                               MovieListItem(movie = it, navController = navController)
                           }
                       )
                   }
               }
           }
    }
}

