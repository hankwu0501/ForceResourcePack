package com.gmail.hankwu0501.listener


import com.gmail.hankwu0501.ForceResourcePack
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerResourcePackStatusEvent
import org.bukkit.scheduler.BukkitRunnable

class PackStatusEvent : Listener {
    @EventHandler
    fun onPackReceived(e: PlayerResourcePackStatusEvent) {
        if (e.status.toString() == "DECLINED") {
            object : BukkitRunnable() {
                override fun run() {
                    e.player.kickPlayer("請開啟材質包後再加入")
                }
            }.runTaskLater(ForceResourcePack.instance, 20)
        } else if (e.status.toString() == "FAILED_DOWNLOAD") {
            object : BukkitRunnable() {
                override fun run() {
                    e.player.kickPlayer("下載失敗請重新加入")
                }
            }.runTaskLater(ForceResourcePack.instance, 20)
        }
    }
}
