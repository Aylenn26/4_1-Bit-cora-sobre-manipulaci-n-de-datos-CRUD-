package edu.itvo.roompersistence.domain.usecase

import edu.itvo.roompersistence.domain.repository.StadiumRepository
import javax.inject.Inject

class GetStadiumsUseCase @Inject constructor(
    private val repository: StadiumRepository
) {

    operator fun invoke() = repository.getStadiums()
}
