package edu.itvo.roompersistence.data.mapper

import edu.itvo.roompersistence.data.local.entity.StadiumEntity
import edu.itvo.roompersistence.domain.model.Stadium

fun StadiumEntity.toDomain(): Stadium {

    return Stadium(
        id = id,
        name = name,
        city = city,
        country = country,
        capacity = capacity,
        photo = photo
    )
}

fun Stadium.toEntity(): StadiumEntity {

    return StadiumEntity(
        id = id,
        name = name,
        city = city,
        country = country,
        capacity = capacity,
        photo = photo
    )
}
