package edu.itvo.roompersistence.presentation.stadium.state

import edu.itvo.roompersistence.domain.model.Stadium

data class StadiumListUiState(

    val stadiums: List<Stadium> = emptyList()
)
