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

public class EnderTalismanTooltipListener {


    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onItemToolTip(final ItemTooltipEvent itemTooltipEvent) {
        if (itemTooltipEvent.getItemStack().getItem() == ModItems.TALISMAN_ANGEL_ENDER.get()) {
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_angel").withStyle(ChatFormatting.DARK_BLUE));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.non-consumable").withStyle(ChatFormatting.GRAY));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.ender").withStyle(ChatFormatting.DARK_PURPLE));



        }




        if (itemTooltipEvent.getItemStack().getItem() == ModItems.TALISMAN_HUNTER_ENDER.get()) {
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_hunter").withStyle(ChatFormatting.DARK_BLUE));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.non-consumable").withStyle(ChatFormatting.GRAY));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.ender").withStyle(ChatFormatting.DARK_PURPLE));

        }

        if (itemTooltipEvent.getItemStack().getItem() == ModItems.TALISMAN_WARRIOR_ENDER.get()) {
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_warrior").withStyle(ChatFormatting.DARK_BLUE));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_not_work_offhand").withStyle(ChatFormatting.DARK_RED, ChatFormatting.BOLD));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.consumable").withStyle(ChatFormatting.GRAY));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.ender").withStyle(ChatFormatting.DARK_PURPLE));





        }

        if (itemTooltipEvent.getItemStack().getItem() == ModItems.TALISMAN_KNIGHT_ENDER.get()) {
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_knight").withStyle(ChatFormatting.DARK_BLUE));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_not_work_offhand").withStyle(ChatFormatting.DARK_RED, ChatFormatting.BOLD));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.consumable").withStyle(ChatFormatting.GRAY));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.ender").withStyle(ChatFormatting.DARK_PURPLE));




        }


        if (itemTooltipEvent.getItemStack().getItem() == ModItems.TALISMAN_LAVAWALKER_ENDER.get()) {
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_lavawalker").withStyle(ChatFormatting.DARK_BLUE));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_not_work_offhand").withStyle(ChatFormatting.DARK_RED, ChatFormatting.BOLD));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.consumable").withStyle(ChatFormatting.GRAY));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.ender").withStyle(ChatFormatting.DARK_PURPLE));

        }



        if (itemTooltipEvent.getItemStack().getItem() == ModItems.TALISMAN_ANVIL_ENDER.get()) {
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_anvil").withStyle(ChatFormatting.DARK_BLUE));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_anvil2").withStyle(ChatFormatting.YELLOW));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.non-consumable").withStyle(ChatFormatting.GRAY));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.ender").withStyle(ChatFormatting.DARK_PURPLE));

        }


        if (itemTooltipEvent.getItemStack().getItem() == ModItems.TALISMAN_WATERBREATHER_ENDER.get()) {
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_waterbreather").withStyle(ChatFormatting.DARK_BLUE));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.consumable").withStyle(ChatFormatting.GRAY));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.ender").withStyle(ChatFormatting.DARK_PURPLE));

        }

        if (itemTooltipEvent.getItemStack().getItem() == ModItems.TALISMAN_MINER_ENDER.get()) {
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.talisman_miner").withStyle(ChatFormatting.DARK_BLUE));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.non-consumable").withStyle(ChatFormatting.GRAY));
            itemTooltipEvent.getToolTip().add(new TranslatableComponent("tooltip.italisman.ender").withStyle(ChatFormatting.DARK_PURPLE));

        }



    }
}