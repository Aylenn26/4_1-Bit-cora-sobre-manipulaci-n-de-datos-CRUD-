package edu.itvo.roompersistence.presentation.stadium.state

data class AddStadiumUiState(

    val name: String = "",

    val city: String = "",

    val country: String = "",

    // Se guarda como texto para facilitar el OutlinedTextField;
    // se convierte a Int al guardar en el ViewModel.
    val capacity: String = "",

    val photoUri: String? = null,

    val isLoading: Boolean = false,

    val errorMessage: String? = null
)
