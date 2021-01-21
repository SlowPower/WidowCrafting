package com.slowpower.widowcrafting.commands;

import com.slowpower.widowcrafting.Main;
import com.slowpower.widowcrafting.guis.AdminCraftingGUI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCraftingCommand implements CommandExecutor {

    private Main plugin;

    public AdminCraftingCommand(Main plugin) {
        this.plugin = plugin;

        plugin.getCommand("admincrafting").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        if (!(sender.hasPermission("widowcrafting.admincrafting"))) {
            sender.sendMessage(ChatColor.RED + "Insufficient Permission.");
            return true;
        }

        Player p = (Player) sender;

        p.openInventory(AdminCraftingGUI.GUI(p));
        return false;
    }
}
