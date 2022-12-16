package com.hisroyal.italisman.item;

import com.hisroyal.italisman.InventoryTalisman;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InventoryTalisman.MOD_ID);

    public static final RegistryObject<Item> TALISMAN = ITEMS.register("talisman", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TALISMAN_TAB).rarity(Rarity.UNCOMMON).stacksTo(16)));
    public static final RegistryObject<Item> TALISMAN_ANGEL = ITEMS.register("talisman_angel", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TALISMAN_TAB).rarity(Rarity.RARE).stacksTo(16)));
    public static final RegistryObject<Item> TALISMAN_TRAVELLER = ITEMS.register("talisman_traveller", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TALISMAN_TAB).rarity(Rarity.RARE).stacksTo(16)));
    public static final RegistryObject<Item> TALISMAN_HUNTER = ITEMS.register("talisman_hunter", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TALISMAN_TAB).rarity(Rarity.RARE).stacksTo(16)));
    public static final RegistryObject<Item> TALISMAN_WARRIOR = ITEMS.register("talisman_warrior", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TALISMAN_TAB).rarity(Rarity.RARE).stacksTo(16)));
    public static final RegistryObject<Item> TALISMAN_KNIGHT = ITEMS.register("talisman_knight", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TALISMAN_TAB).rarity(Rarity.RARE).stacksTo(16)));
    public static final RegistryObject<Item> TALISMAN_LAVAWALKER = ITEMS.register("talisman_lavawalker", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TALISMAN_TAB).rarity(Rarity.RARE).stacksTo(16)));
    public static final RegistryObject<Item> TALISMAN_WHIRLWIND = ITEMS.register("talisman_whirlwind", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TALISMAN_TAB).rarity(Rarity.RARE).stacksTo(16)));
    public static final RegistryObject<Item> TALISMAN_ANVIL = ITEMS.register("talisman_anvil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TALISMAN_TAB).rarity(Rarity.RARE).stacksTo(16)));
    public static final RegistryObject<Item> TALISMAN_WATERBREATHER = ITEMS.register("talisman_waterbreather", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TALISMAN_TAB).rarity(Rarity.RARE).stacksTo(16)));
    public static final RegistryObject<Item> TALISMAN_MINER = ITEMS.register("talisman_miner", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TALISMAN_TAB).rarity(Rarity.RARE).stacksTo(16)));













    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
