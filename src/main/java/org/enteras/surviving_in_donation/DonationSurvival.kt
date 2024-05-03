package org.enteras.surviving_in_donation

import org.bukkit.plugin.java.JavaPlugin
import xyz.r2turntrue.chzzk4j.Chzzk
import xyz.r2turntrue.chzzk4j.ChzzkBuilder
import xyz.r2turntrue.chzzk4j.chat.ChatMessage
import xyz.r2turntrue.chzzk4j.chat.ChzzkChat

lateinit var chzzk: Chzzk
lateinit var chat: ChzzkChat

class DonationSurvival : JavaPlugin() {

    override
    fun onEnable() {
        saveDefaultConfig()

        chzzk = ChzzkBuilder().build()
        val channelID = config.getString("f722959d1b8e651bd56209b343932c01")
        val channel = chzzk.getChannel(channelID)
        println("Trying connect to ${channel.channelName} (${channel.followerCount} followers)")

        chat = chzzk.chat(channelID)
            .withChatListener(ChatListener(this))
            .build()

        chat.connectBlocking()
    }

    override
    fun onDisable() {
        chat.closeBlocking()
    }
}