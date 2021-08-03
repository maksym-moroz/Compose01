package com.maksym.moroz.common.domain.core.model.todo.details

import android.graphics.Color
import androidx.annotation.ColorInt

enum class CategoryColor(
    @ColorInt val color: Int,
) {
    GRAY(Color.GRAY),
    DARK_GRAY(Color.DKGRAY),
    LIGHT_GRAY(Color.LTGRAY),
    RED(Color.RED),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    YELLOW(Color.YELLOW),
    MAGENTA(Color.MAGENTA),
    CYAN(Color.CYAN),
}
