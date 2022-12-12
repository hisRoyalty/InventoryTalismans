package com.hisroyal.italisman.event;


import com.hisroyal.italisman.InventoryTalisman;
import com.hisroyal.italisman.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InventoryTalisman.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class EventListener {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onItemToolTip(final ItemTooltipEvent itemTooltipEvent) {
        if (itemTooltipEvent.getItemStack().getItem() == ModItems.TALISMAN_ANGEL.get()) {
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_angel").withStyle(ChatFormatting.DARK_BLUE));

        }


        if (itemTooltipEvent.getItemStack().getItem() == ModItems.TALISMAN_TRAVELLER.get()) {
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_traveller").withStyle(ChatFormatting.DARK_BLUE));

        }


        if (itemTooltipEvent.getItemStack().getItem() == ModItems.TALISMAN_HUNTER.get()) {
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_hunter").withStyle(ChatFormatting.DARK_BLUE));

        }

        if (itemTooltipEvent.getItemStack().getItem() == ModItems.TALISMAN_WARRIOR.get()) {
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_warrior").withStyle(ChatFormatting.DARK_BLUE));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_warrior2").withStyle(ChatFormatting.DARK_RED, ChatFormatting.BOLD));


        }



    }
}
