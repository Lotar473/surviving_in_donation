package org.enteras.surviving_in_donation

import org.bukkit.event.Listener
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerInteractEvent
import xyz.r2turntrue.chzzk4j.chat.ChatEventListener
import xyz.r2turntrue.chzzk4j.chat.ChatMessage
import org.bukkit.Material
import org.bukkit.block.BlockFace
import org.bukkit.block.BlockState
import org.bukkit.entity.ItemFrame
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemStack

class EventListener : Listener {

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player: Player = event.player
        val clickedBlock: Block? = event.clickedBlock

        if (event.action == Action.RIGHT_CLICK_BLOCK && clickedBlock != null) {
            if (clickedBlock.type == Material.BARRIER) {
                val itemInHand: ItemStack? = player.itemInHand
                if (itemInHand != null && itemInHand.type != Material.AIR) {
                    val itemToPlace: ItemStack = itemInHand.clone()
                    itemToPlace.amount = 1
                    val emptySpace: Block? = findEmptySpace(clickedBlock)

                    if (emptySpace != null) {
                        val frame: BlockState = emptySpace.getState()
                        frame.setType(Material.ITEM_FRAME)
                        frame.setType(Material.GLOW_ITEM_FRAME)
                        val itemFrame = frame as ItemFrame
                        itemFrame.setFacingDirection(BlockFace.UP)
                        itemFrame.setItem(itemToPlace)

                        itemInHand.amount -= 1
                        player.setItemInHand(itemInHand)

                        event.isCancelled = true
                    }
                }
            }
        }
    }

    private fun findEmptySpace(barrierBlock: Block): Block? {
        val surroundingBlocks = arrayOf(
            barrierBlock.getRelative(BlockFace.NORTH),
            barrierBlock.getRelative(BlockFace.EAST),
            barrierBlock.getRelative(BlockFace.SOUTH),
            barrierBlock.getRelative(BlockFace.WEST)
        )

        for (block in surroundingBlocks) {
            if (block.isEmpty) {
                return block
            }
        }
        return null
    }
}