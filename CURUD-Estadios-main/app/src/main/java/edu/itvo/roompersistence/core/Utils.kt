package edu.itvo.roompersistence.core

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File

fun createImageUri(
    context: Context
): Uri {

    val imageFile = File(
        context.cacheDir,
        "player_${System.currentTimeMillis()}.jpg"
    )

    return FileProvider.getUriForFile(
        context,
        "${context.packageName}.provider",
        imageFile
    )
}