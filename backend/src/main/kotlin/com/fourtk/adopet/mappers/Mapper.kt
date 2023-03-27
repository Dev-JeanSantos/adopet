package com.fourtk.adopet.mappers

interface Mapper<T, U> {
    fun map(t: T): U
}