package com.slowpower.widowcrafting.commands;

import com.slowpower.widowcrafting.Main;
import com.slowpower.widowcrafting.guis.AdminCraftingGUI;
import com.slowpower.widowcrafting.guis.CraftableGUI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CraftableCommand implements CommandExecutor {

    private Main plugin;

    public CraftableCommand(Main plugin) {
        this.plugin = plugin;

        plugin.getCommand("craftable").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        if (!(sender.hasPermission("widowcrafting.craftable"))) {
            sender.sendMessage(ChatColor.RED + "Insufficient Permission.");
            return true;
        }

        Player p = (Player) sender;

        p.openInventory(CraftableGUI.GUI(p));
        return false;
    }
}
