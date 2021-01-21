package com.slowpower.widowcrafting.commands;

import com.slowpower.widowcrafting.Main;
import com.slowpower.widowcrafting.guis.CraftableGUI;
import com.slowpower.widowcrafting.guis.RecipesGUI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RecipesCommand implements CommandExecutor {

    private Main plugin;

    public RecipesCommand(Main plugin) {
        this.plugin = plugin;

        plugin.getCommand("recipes").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player p = (Player) sender;

        p.openInventory(RecipesGUI.GUI(p));
        return false;
    }
}
