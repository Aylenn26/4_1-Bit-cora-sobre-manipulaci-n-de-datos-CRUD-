package edu.itvo.roompersistence.domain.usecase

import edu.itvo.roompersistence.domain.model.Stadium
import edu.itvo.roompersistence.domain.repository.StadiumRepository
import javax.inject.Inject

class DeleteStadiumUseCase @Inject constructor(
    private val repository: StadiumRepository
) {

    suspend operator fun invoke(
        stadium: Stadium
    ) {

        repository.deleteStadium(stadium)
    }
}
