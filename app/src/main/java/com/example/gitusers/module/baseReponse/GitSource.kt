package com.example.gitusers.module.baseReponse


data class GitSource<out T> (val status: Status, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T? = null): GitSource<T> {
            return GitSource(Status.SUCCESS, data, "")
        }

        fun <T> error(msg: String): GitSource<T> {
            return GitSource(Status.ERROR, null, msg)
        }

        fun <T> empty(msg: String): GitSource<T> {
            return GitSource(Status.EMPTY, null, msg)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    EMPTY
}
