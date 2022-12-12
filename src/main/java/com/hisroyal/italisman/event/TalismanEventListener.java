package com.hisroyal.italisman.event;


import com.hisroyal.italisman.InventoryTalisman;
import com.hisroyal.italisman.item.ModItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.wrapper.PlayerMainInvWrapper;


import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = InventoryTalisman.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TalismanEventListener {

    @SubscribeEvent
    public static void doubleInventoryLoot(LivingDropsEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) {
            return;
        }
        boolean hasItemInInventory = player.getInventory().contains(ModItems.TALISMAN_HUNTER.get().getDefaultInstance());
        if(!hasItemInInventory){
            return;
        }

        int a = new Random().nextInt(10);
        if (a < 2) {
            for (ItemEntity item : event.getDrops()) {
                event.getEntity().spawnAtLocation(item.getItem());
            }
        }




    }



    @SubscribeEvent
    public static void onNegateFallDamageFromAngelTalisman(LivingHurtEvent Event) {
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
    public static void onTravellerBoost(TickEvent.PlayerTickEvent Event) {
        int a = new Random().nextInt(100);
        IItemHandler inventory = new PlayerMainInvWrapper(Event.player.getInventory());
        for (int i = 0; i < inventory.getSlots(); i++) {

            if (Event.player.isSprinting() && a < 40 && inventory.getStackInSlot(i).getItem() == ModItems.TALISMAN_TRAVELLER.get() && !Event.player.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                Event.player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600));

            }
        }

    }

    @SubscribeEvent
    public static void onWarriorHit(LivingHurtEvent e) {


        if (e.getSource().isFire() || e.getSource().isExplosion() || e.getSource().isMagic() || e.getSource().isProjectile() || e.getSource().isFall()) {
            return;
        }


        if (e.getEntity() instanceof Player player) {
                IItemHandler inventory = new PlayerMainInvWrapper(player.getInventory());
                for (int i = 0; i < inventory.getSlots(); i++) {
                    if (inventory.getStackInSlot(i).getItem() == ModItems.TALISMAN_WARRIOR.get()) {
                        if (player.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            return;
                        }
                        ItemStack mainStack = inventory.getStackInSlot(i);
                        mainStack.shrink(1);
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 4));

                    }
                }
        }

    }

    @SubscribeEvent
    public static void onRepairDestroyItem(PlayerDestroyItemEvent e) {
        IItemHandler inventory = new PlayerMainInvWrapper(e.getPlayer().getInventory());
        ItemStack brokenItem = e.getOriginal();
        if (brokenItem.isDamaged()) {
            ItemStack itemStack = brokenItem.copy();
            itemStack.setDamageValue(itemStack.getDamageValue() - 1);
            ItemHandlerHelper.giveItemToPlayer(e.getPlayer(), itemStack, e.getPlayer().getInventory().getSuitableHotbarSlot());
        }

        /*int slot = -1;

        if (brokenItem.equals(e.getPlayer().getMainHandItem())) {
            slot = e.getPlayer().getInventory().getSuitableHotbarSlot();
        } else if (brokenItem.equals(e.getPlayer().getOffhandItem())) {
            slot = 40;
        } else {
            final int[] armorSlots = { 39, 38, 37, 36 };
            for (int s: armorSlots) {
                if (brokenItem.equals(e.getPlayer().getInventory().getItem(s))) {
                    slot = s;
                    break;
                }

            }
        }

        if (slot < 0) {
            return;
        }

        ItemStack repairedItem = e.getOriginal().copy();
        repairedItem.setDamageValue(repairedItem.getMaxDamage());

        int itemSlot = slot;*/


    }






}
