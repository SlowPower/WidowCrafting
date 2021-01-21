package com.slowpower.widowcrafting;

import com.slowpower.widowcrafting.commands.AdminCraftingCommand;
import com.slowpower.widowcrafting.commands.CraftableCommand;
import com.slowpower.widowcrafting.commands.RecipesCommand;
import com.slowpower.widowcrafting.guis.CraftableGUI;
import com.slowpower.widowcrafting.guis.RecipesGUI;
import com.slowpower.widowcrafting.listeners.AdminCraftingClickListener;
import com.slowpower.widowcrafting.guis.AdminCraftingGUI;
import com.slowpower.widowcrafting.listeners.CraftableClickListener;
import com.slowpower.widowcrafting.listeners.RecipesClickListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        new AdminCraftingCommand(this);
        new AdminCraftingClickListener(this);
        AdminCraftingGUI.initialize();

        new CraftableCommand(this);
        new CraftableClickListener(this);
        CraftableGUI.initialize();

        new RecipesCommand(this);
        new RecipesClickListener(this);
        RecipesGUI.initialize();
    }



}
