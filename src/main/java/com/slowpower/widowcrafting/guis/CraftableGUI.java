package com.slowpower.widowcrafting.guis;

import com.slowpower.widowcrafting.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CraftableGUI {

    public static Inventory inv;
    public static String inventory_name;
    public static int inv_rows = 5 * 9;

    private static final Set<Integer> CraftableSlots = new HashSet<>(Arrays.asList(10, 11, 12, 19, 20, 21, 24, 28, 29, 30));


    public static void initialize() {
        inventory_name = Utils.chat("&8Craftable");

        inv = Bukkit.createInventory(null, inv_rows);
    }

    public static Inventory GUI (Player p) {
        Inventory inv = Bukkit.createInventory(null, inv_rows, inventory_name);

        ItemStack filler = Utils.createItemByteNoSlot(inv, 160, 15, 1, "&f&lThe &4&lWidow");

        CompletableFuture.runAsync(() -> {
            for (int i=0; i<inv_rows; ++i) {
                if ( ! CraftableSlots.contains(i)) {
                    inv.setItem(i, filler);
                }
            }
        });

        inv.setContents(inv.getContents());
        return inv;
    }

    public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
        if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&cTest Item"))) {
            p.setDisplayName(Utils.chat("&cClicked"));
        }
    }
}
