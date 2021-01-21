package com.slowpower.widowcrafting.listeners;

import com.slowpower.widowcrafting.Main;
import com.slowpower.widowcrafting.guis.RecipesGUI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class RecipesClickListener implements Listener {

    private final Main plugin;

    public RecipesClickListener(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        String title = e.getInventory().getTitle();
        if (title.equals(RecipesGUI.inventory_name)) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) return;

            if (title.equals(RecipesGUI.inventory_name)) {
                RecipesGUI.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
            }
        }
    }
}
