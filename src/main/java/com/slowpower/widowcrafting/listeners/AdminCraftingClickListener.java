package com.slowpower.widowcrafting.listeners;

import com.slowpower.widowcrafting.guis.AdminCraftingGUI;
import com.slowpower.widowcrafting.guis.CraftableGUI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.slowpower.widowcrafting.Main;

public class AdminCraftingClickListener implements Listener {

    private final Main plugin;

    public AdminCraftingClickListener(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        String title = e.getInventory().getTitle();
        if (title.equals(AdminCraftingGUI.inventory_name)) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) return;

            if (title.equals(AdminCraftingGUI.inventory_name)) {
                AdminCraftingGUI.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
            }
        }
    }
}
