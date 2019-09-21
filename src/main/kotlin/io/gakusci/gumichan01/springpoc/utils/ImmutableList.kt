package io.gakusci.gumichan01.springpoc.utils

class ImmutableList<T>(private val inner: MutableList<T>) : List<T> by inner {
    override fun toString(): String {
        return inner.map { e -> e.toString() }.reduce { acc, s -> acc + s }
    }
}