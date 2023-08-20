package com.github.superglue.vaultwrapper

import org.bukkit.Bukkit
import org.bukkit.Bukkit.getServer
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import java.util.UUID


object Economy {

    private val eco: net.milkbowl.vault.economy.Economy

    init {
        if (!Bukkit.getPluginManager().isPluginEnabled("Vault")) {
            throw IllegalStateException("Attempted to use VaultWrapper without vault on the server!")
        }

        val rsp = getServer().servicesManager.getRegistration(net.milkbowl.vault.economy.Economy::class.java)
            ?: throw IllegalStateException("No Economy Provider found!")

        eco = rsp.provider
    }

    private fun UUID.toOfflinePlayer() = Bukkit.getOfflinePlayer(this)

    /** Give the player money */
    fun deposit(player: OfflinePlayer, amount: Double) = eco.depositPlayer(player, amount)
    /** Give the player money */
    fun deposit(uuid: UUID, amount: Double) = eco.depositPlayer(uuid.toOfflinePlayer(), amount)
    /** Give the player money */
    fun Player.deposit(amount: Double) = eco.depositPlayer(this, amount)

    /** Withdraw money from the player */
    fun withdraw(player: OfflinePlayer, amount: Double) = eco.withdrawPlayer(player, amount)
    /** Withdraw money from the player */
    fun withdraw(uuid: UUID, amount: Double) = eco.withdrawPlayer(uuid.toOfflinePlayer(), amount)
    /** Withdraw money from the player */
    fun Player.withdraw(amount: Double) = withdraw(this, amount)

    /** Whether the player has enough money to afford the amount */
    fun has(player: OfflinePlayer, amount: Double) = eco.has(player, amount)
    /** Whether the player has enough money to afford the amount */
    fun canAfford(player: OfflinePlayer, amount: Double) = has(player, amount)
    /** Whether the player has enough money to afford the amount */
    fun canAfford(uuid: UUID, amount: Double) = has(uuid.toOfflinePlayer(), amount)
    /** Whether the player has enough money to afford the amount */
    fun Player.canAfford(amount: Double) = has(this, amount)

    /** @return how much money the player has */
    fun getBalance(player: OfflinePlayer) = eco.getBalance(player)
    /** @return how much money the player has */
    fun getBalance(uuid: UUID) = getBalance(uuid.toOfflinePlayer())
    /** @return how much money the player has */
    fun Player.getBalance() = getBalance(this)

}