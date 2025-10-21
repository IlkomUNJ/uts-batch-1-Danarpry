package com.example.miapigos

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun StudentAddApp(
    onRegister: () -> Unit,
    modifier: Modifier = Modifier
) {
    var studentid by remember { mutableStateOf("") }
    var studentname by remember { mutableStateOf("") }
    var studentphone by remember { mutableStateOf("") }
    var studentaddress by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(200.dp))

        StudentInputField(
            value = studentid,
            onValueChange = { studentid = it },
            placeholder = "Student Id"
        )

        Spacer(modifier = Modifier.height(16.dp))

        StudentInputField(
            value = studentname,
            onValueChange = { studentname = it },
            placeholder = "Student Name"
        )

        Spacer(modifier = Modifier.height(16.dp))

        StudentInputField(
            value = studentphone,
            onValueChange = { studentphone = it },
            placeholder = "Student Phone"
        )

        Spacer(modifier = Modifier.height(16.dp))

        StudentInputField(
            value = studentaddress,
            onValueChange = { studentaddress = it },
            placeholder = "Student Address"
        )

        Spacer(modifier = Modifier.height(32.dp))

        ElevatedButton(
            onClick = {
                StudentData.addStudent(
                    StudentData.Student(
                        id = studentid,
                        name = studentname,
                        phone = studentphone,
                        address = studentaddress
                    )
                )
                onRegister()
            },
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color.Black,
                contentColor = Color(0xFFFFA500)
            ),
            shape = RectangleShape,
            modifier = Modifier
                .width(150.dp)
                .height(48.dp)
        ) {
            Text("Register")
        }
    }
}

@Composable
fun StudentInputField(value: String, onValueChange: (String) -> Unit, placeholder: String) {
    Box(
        modifier = Modifier
            .border(1.dp, Color(0xFFFFA500), RectangleShape)
            .background(Color.White)
            .padding(8.dp)
            .width(250.dp)
    ) {
        if (value.isEmpty()) {
            Text(placeholder, color = Color.Gray)
        }
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(color = Color.Black),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

class StudentData {
    data class Student(
        val id: String,
        val name: String,
        val phone: String,
        val address: String
    )

    companion object {
        private val studentList = mutableListOf<Student>()

        fun addStudent(student: Student) {
            studentList.add(student)
        }

        fun getAllStudents(): List<Student> = studentList
    }
}