package com.gmail.hankwu0501

import com.gmail.hankwu0501.listener.PackStatusEvent
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class ForceResourcePack: JavaPlugin() {
    companion object{
        lateinit var instance:ForceResourcePack
    }
    init{
        instance = this
    }
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(PackStatusEvent(),this)
        instance.logger.info("插件啟動成功")
    }
}