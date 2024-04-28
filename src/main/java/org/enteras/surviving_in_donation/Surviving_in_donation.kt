package org.enteras.surviving_in_donation

import org.bukkit.plugin.java.JavaPlugin

class Surviving_in_donation : JavaPlugin() {
    override fun onEnable() {
        getLogger().info("I LIKE MONEY! GIVE ME NONEY!")
    }

    override fun onDisable() {
        getLogger().info("Damn it! Plugin disabled!")
    }
}
