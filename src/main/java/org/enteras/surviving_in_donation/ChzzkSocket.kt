package org.enteras.surviving_in_donation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kr.enak.outsource.akuru.mamulkuruft.utils.*
import kr.enak.outsource.akuru.mamulkuruft.websocket.abc.ServiceSocket
import org.bukkit.Bukkit
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI

private fun buildChatServerUrl() = (1..5).random().let { idx ->
    "wss://kr-ss${idx}.chat.naver.com/chat"
}

private fun liveDetailUrl(channelId: String) = "https://api.chzzk.naver.com/service/v2/channels/$channelId/live-detail"

private const val CHZZK_TOKEN_URL = "https://comm-api.game.naver.com/nng_main/v1/chats/access-token?chatType=STREAMING"

private suspend fun getAccessToken(chatId: String) = get("$CHZZK_TOKEN_URL&channelId=$chatId") { conn ->
    val d = conn.json()

    d.asJsonObject
        .getAsJsonObject("content")
        .getAsJsonPrimitive("accessToken")
        .asString
}

private suspend fun exchangeChatId(channelId: String) = get(liveDetailUrl(channelId)) { conn ->
    val d = conn.json()

    d.asJsonObject
        .getAsJsonObject("content")
        .getAsJsonPrimitive("chatChannelId")
        .asString
}

@Serializable
private data class ChzzkAuthPayload(
    val svcid: String = "game",
    val ver: String = "2",
    val tid: Int = 1,
    val cmd: Int = ChzzkCommand.Request.AUTH.code,
    val cid: String,
    val bdy: Body,
) {
    @Serializable
    data class Body(
        val uid: String? = null,
        val auth: String = "READ",
        val devType: Int = 2001,
        val accTkn: String,
    )

    constructor(
        chatId: String,
        accessToken: String,
    ) : this(cid = chatId, bdy = Body(accTkn = accessToken))
}

private data class ChzzkDonationData(
    val userId: String,
    val userNick: String,
    val amount: Int,
)

