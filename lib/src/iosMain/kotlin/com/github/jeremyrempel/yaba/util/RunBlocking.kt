package com.github.jeremyrempel.yaba.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

actual fun <T> runBlockingTest(
    context: CoroutineContext,
    block: suspend CoroutineScope.() -> T
): T {
    return runBlocking(EmptyCoroutineContext, block)
}