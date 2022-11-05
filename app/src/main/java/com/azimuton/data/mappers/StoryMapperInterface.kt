package com.azimuton.data.mappers

interface StoryMapperInterface<T, A> {
    fun mapFromEntity(type: T): A

    fun mapToEntity(type: A): T
}