package com.hisroyal.italisman.event;


import com.hisroyal.italisman.InventoryTalisman;
import com.hisroyal.italisman.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.PlayerMainInvWrapper;


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


            if (Event.player.isSprinting() && a < 40 && Event.player.getMainHandItem().getItem() == ModItems.TALISMAN_TRAVELLER.get() && !Event.player.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                Event.player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600));

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
    public static void onKnightHit(LivingHurtEvent e) {
        int a = new Random().nextInt(10);

        if (e.getSource().isFire() || e.getSource().isExplosion() || e.getSource().isMagic() || e.getSource().isProjectile() || e.getSource().isFall()) {
            return;
        }



        if (a < 3 && e.getEntity() instanceof Player player) {
            IItemHandler inventory = new PlayerMainInvWrapper(player.getInventory());
            for (int i = 0; i < inventory.getSlots(); i++) {
                if (inventory.getStackInSlot(i).getItem() == ModItems.TALISMAN_KNIGHT.get()) {
                    if (player.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        return;
                    }
                    ItemStack mainStack = inventory.getStackInSlot(i);
                    mainStack.shrink(1);
                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 3));

                }
            }
        }

    }


    @SubscribeEvent
    public static void onLavaTouch(LivingHurtEvent e) {
        if (e.getSource() == DamageSource.LAVA && e.getEntity() instanceof Player player) {
            if (player.hasEffect(MobEffects.FIRE_RESISTANCE)) {
                return;
            }
            Inventory inv = player.getInventory();

            for(int slot = 0; slot < inv.getContainerSize(); ++slot) {
                ItemStack stack = inv.getItem(slot);
                if (stack.getItem() == ModItems.TALISMAN_LAVAWALKER.get()) {
                    e.setCanceled(true);
                    ItemStack mainStack = inv.getItem(slot);
                    mainStack.shrink(1);
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3600));


                }
            }


        }
    }


    @SubscribeEvent
    public static void onAbsorbProjectile(LivingHurtEvent e) {
        int a = new Random().nextInt(100);
        if (e.getSource().isProjectile() && e.getEntity() instanceof Player player) {
            if (a < 75 && player.getInventory().contains(ModItems.TALISMAN_WHIRLWIND.get().getDefaultInstance())) {
                e.setCanceled(true);
            }

        }

    }


    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Inventory inv = player.getInventory();

        for(int slot = 0; slot < inv.getContainerSize(); ++slot) {
            ItemStack stack = inv.getItem(slot);
            int delay = 150;
            if (stack.getItem() == ModItems.TALISMAN_ANVIL.get() && player.tickCount % delay == 0) {
                repair(player, inv);
            }
        }

    }

    private static void repair(Player player, Inventory inv) {


        for(int slot = minSlot; slot < maxSlot; ++slot) {
            ItemStack target = inv.getItem(slot);
            if (!target.isEmpty() && target != player.getMainHandItem() && target.isDamaged()) {
                target.setDamageValue(target.getDamageValue() - 1);
                return;
            }
        }

    }

    private static final int minSlot = 0;
    private static final int maxSlot = 40;



    @SubscribeEvent
    public static void doubleDropsOre(BlockEvent.BreakEvent e) {
        int a = new Random().nextInt(10);
        if (e.getPlayer().getMainHandItem().getEnchantmentTags().getAsString().contains("{id:\"minecraft:silk_touch\",lvl:1s}")) {
            return;
        }
        if (e.getPlayer().getMainHandItem().canPerformAction(ToolActions.PICKAXE_DIG) && e.getPlayer().getMainHandItem().isCorrectToolForDrops(e.getState()) && e.getState().is(Tags.Blocks.ORES) && e.getPlayer().getInventory().contains(ModItems.TALISMAN_MINER.get().getDefaultInstance()) && a < 3) {

            List<ItemStack> List = e.getState().getBlock().getDrops(e.getState(), (ServerLevel) e.getWorld(), e.getPos(), null);
            ItemEntity item = new ItemEntity((Level) e.getWorld(), e.getPos().getX(), e.getPos().getY(), e.getPos().getZ(), new ItemStack(List.get(0).getItem(), List.get(0).getCount()));
            e.getWorld().addFreshEntity(item);

        }

    }

    @SubscribeEvent
    public static void onPlayerDrown(LivingHurtEvent e) {

        if (e.getSource() == DamageSource.DROWN && e.getEntity() instanceof Player player) {
            Inventory inv = player.getInventory();
            if (player.hasEffect(MobEffects.WATER_BREATHING)) {
                return;
            }
            for (int slot = 0; slot < inv.getContainerSize(); ++slot) {
                ItemStack stack = inv.getItem(slot);
                if (stack.getItem() == ModItems.TALISMAN_WATERBREATHER.get()) {
                    e.setCanceled(true);
                    ItemStack mainStack = inv.getItem(slot);
                    mainStack.shrink(1);
                    player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 3600));


                }
            }
        }
    }















}
