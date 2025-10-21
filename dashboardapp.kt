package com.example.miapigos

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardApp() {
    var currentScreen by remember { mutableStateOf("dashboard") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Student Roster",
                        modifier = Modifier.clickable {
                            currentScreen = "list"
                        }
                    )
                }
            )
        },
        floatingActionButton = {
            if (currentScreen == "dashboard" || currentScreen == "list") {
                FloatingActionButton(
                    onClick = {
                        currentScreen = "add"
                    }
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            when (currentScreen) {
                "dashboard" -> {
                    Text(
                        text = "Dashboard Kosong, Klik student roster untuk melihat siswa",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                "list" -> {
                    StudentListApp(
                        headers = listOf("ID", "Nama"),
                        rows = StudentData.getAllStudents().map {
                            listOf(it.id, it.name)
                        }
                    )
                }

                "add" -> {
                    StudentAddApp(
                        onRegister = {
                            currentScreen = "list"
                        },
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            }
        }
    }
}