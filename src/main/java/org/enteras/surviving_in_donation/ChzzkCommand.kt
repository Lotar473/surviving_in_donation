package org.enteras.surviving_in_donation

sealed class ChzzkCommand {
    enum class Request(val code: Int) {
        AUTH(100),
        PONG(10000),
        ;

        override fun toString() = "$code"
    }

    enum class Response(val code: Int) {
        PING(0),
        AUTH(10100),
        NEW_MESSAGES(93101),
        DONATION(93102),
        ;

        companion object {
            operator fun get(code: Int) = entries.firstOrNull { it.code == code }
        }

        override fun toString() = "$code"
    }
}