package com.hisroyal.italisman.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TALISMAN_TAB = new CreativeModeTab("talismantab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TALISMAN_ANGEL.get());
        }
    };
}
