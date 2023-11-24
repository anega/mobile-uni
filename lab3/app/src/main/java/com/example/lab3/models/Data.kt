package com.example.lab3.models

sealed class Data {
    data class Movie(
        val id: Int,
        val posterPath: String,
        val title: String,
        val overview: String,
        val mediaType: String,
        val releaseDate: String,
        val voteAverage: Double,
        val voteCount: Int
    ): Data()

    data class Person(
        val id: Int,
        val name: String,
        val profilePath: String?,
        val mediaType: String,
        val gender: String,
        val knownForDepartment: String,
        val knownFor: Array<String>
    ): Data() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Person

            if (id != other.id) return false
            if (name != other.name) return false
            if (mediaType != other.mediaType) return false
            if (gender != other.gender) return false
            if (knownForDepartment != other.knownForDepartment) return false
            if (!knownFor.contentEquals(other.knownFor)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = id
            result = 31 * result + name.hashCode()
            result = 31 * result + mediaType.hashCode()
            result = 31 * result + gender.hashCode()
            result = 31 * result + knownForDepartment.hashCode()
            result = 31 * result + knownFor.contentHashCode()
            return result
        }
    }
}
