package com.syafi.wisellet.presentation.add_transaction.income

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.syafi.wisellet.presentation.add_transaction.IncomeViewModel
import com.syafi.wisellet.ui.theme.blue
import com.syafi.wisellet.util.Route
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncomeScreen(
    viewModel: IncomeViewModel = hiltViewModel(),
    navController: NavController
) {

    val calendarState = rememberSheetState()
    val source = remember { MutableInteractionSource() }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        CalendarDialog(
            state = calendarState,
            config = CalendarConfig(
                monthSelection = true,
                yearSelection = true
            ),
            selection = CalendarSelection.Date { date ->
                viewModel.dateChange(date.toString())
            }
        )

        if (source.collectIsPressedAsState().value) {
            calendarState.show()
        }

        OutlinedTextField(
            value = viewModel.dateValue,
            onValueChange = {
                viewModel.dateChange(it)
            },
            label = {
                Text(text = "Date")
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.blue,
                focusedIndicatorColor = MaterialTheme.colorScheme.blue
            ),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            readOnly = true,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.CalendarMonth,
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        calendarState.show()
                    },
                    tint = MaterialTheme.colorScheme.blue
                )
            },
            interactionSource = source
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {


            OutlinedTextField(
                value = "IDR",
                onValueChange = {},
                label = {
                    Text(text = "Currency")
                },
                enabled = false,
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.blue,
                    focusedIndicatorColor = MaterialTheme.colorScheme.blue
                ),
                modifier = Modifier.weight(1f),
                trailingIcon = {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
                }
            )

            OutlinedTextField(
                value = viewModel.amoutValue,
                onValueChange = {
                    viewModel.amountChange(it)
                },
                label = {
                    Text(text = "Amount")
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.blue,
                    focusedIndicatorColor = MaterialTheme.colorScheme.blue
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(2.3f),
                shape = RoundedCornerShape(15.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = viewModel.titleValue,
            onValueChange = {
                viewModel.titleChange(it)
            },
            label = {
                Text(text = "Title")
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.blue,
                focusedIndicatorColor = MaterialTheme.colorScheme.blue
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = viewModel.descriptionValue,
            onValueChange = {
                viewModel.descriptionChange(it)
            },
            label = {
                Text(text = "Description")
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.blue,
                focusedIndicatorColor = MaterialTheme.colorScheme.blue
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                scope.launch {
                    viewModel.onSaveClick(context)
                    navController.navigate(Route.HOME)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(13.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.blue)
        ) {
            Text(text = "SAVE", fontWeight = FontWeight.SemiBold)
        }
    }
}