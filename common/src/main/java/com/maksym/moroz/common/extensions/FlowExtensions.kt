package com.maksym.moroz.common.extensions

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

@OptIn(FlowPreview::class)
inline fun <T, R> Flow<List<T>>.mapToDomain(crossinline mapper: T.() -> R): Flow<List<R>> {
    return this
        .map { list -> list.map(mapper) }
}

@OptIn(InternalCoroutinesApi::class)
fun <T> Flow<T>.throttleFirst(windowDuration: Long): Flow<T> = flow {
    var windowStartTime = System.currentTimeMillis()
    var yetToEmit = true
    collect { value ->
        val currentTime = System.currentTimeMillis()
        val delta = currentTime - windowStartTime
        if (delta >= windowDuration) {
            windowStartTime += delta / windowDuration * windowDuration
            yetToEmit = true
        }
        if (yetToEmit) {
            emit(value)
            yetToEmit = false
        }
    }
}


