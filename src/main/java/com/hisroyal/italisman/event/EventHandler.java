package com.hisroyal.italisman.event;


import com.hisroyal.italisman.InventoryTalisman;
import com.hisroyal.italisman.item.ModItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.PlayerMainInvWrapper;

import java.util.Random;

@Mod.EventBusSubscriber(modid = InventoryTalisman.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {


    @SubscribeEvent
    public static void NegateFallDamageFromAngelTalisman(LivingHurtEvent Event) {
        int a = new Random().nextInt(100);
        if (Event.getEntity() instanceof Player player) {
        IItemHandler inventory = new PlayerMainInvWrapper(player.getInventory());
        for (int i = 0; i < inventory.getSlots(); i++) {
            if (inventory.getStackInSlot(i).getItem() == ModItems.TALISMAN_ANGEL.get() && a < 75 && Event.getSource() == DamageSource.FALL) {

                Event.setCanceled(true);
               }
            }

        }
    }
    // NOTE: to be worked on
    @SubscribeEvent
    public static void TravellerBoost(TickEvent.PlayerTickEvent Event) {
        int a = new Random().nextInt(100);
        IItemHandler inventory = new PlayerMainInvWrapper(Event.player.getInventory());
        for (int i = 0; i < inventory.getSlots(); i++) {

            if (Event.player.isSprinting() && a < 40 && inventory.getStackInSlot(i).getItem() == ModItems.TALISMAN_TRAVELLER.get() && !Event.player.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                Event.player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600));

            }
        }
    }



}
