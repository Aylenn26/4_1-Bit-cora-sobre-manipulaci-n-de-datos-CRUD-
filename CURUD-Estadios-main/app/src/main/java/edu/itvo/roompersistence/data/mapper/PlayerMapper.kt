package edu.itvo.roompersistence.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import edu.itvo.roompersistence.data.local.entity.PlayerEntity
import edu.itvo.roompersistence.domain.model.Gender
import edu.itvo.roompersistence.domain.model.Player
import edu.itvo.roompersistence.domain.model.Position
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun PlayerEntity.toDomain(): Player {

    return Player(
        id = id,
        fullName = fullName,
        nickName = nickName,
        nationality = nationality,
        gender = Gender.valueOf(gender),
        birthDate = LocalDate.parse(birthDate),
        photo = photo,
        position = Position.valueOf(position)
    )
}

fun Player.toEntity(): PlayerEntity {

    return PlayerEntity(
        id = id,
        fullName = fullName,
        nickName = nickName,
        nationality = nationality,
        gender = gender.name,
        birthDate = birthDate.toString(),
        photo = photo,
        position = position.name
    )
}