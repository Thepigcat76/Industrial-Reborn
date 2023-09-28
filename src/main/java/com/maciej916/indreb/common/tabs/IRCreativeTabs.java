package com.maciej916.indreb.common.tabs;

import com.maciej916.indreb.IndReb;
import com.maciej916.indreb.common.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IRCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IndReb.MODID);

    public static RegistryObject<CreativeModeTab> INDREB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MINING_DRILL.get()))
                    .title(Component.translatable("creativetab.indreb"))
                    .displayItems((pParameters, pOutput) -> {
                        /* Circuits */
                        add(pOutput, ModItems.ELECTRONIC_CIRCUIT);
                        add(pOutput, ModItems.ADVANCED_CIRCUIT);
                        add(pOutput, ModItems.LAPOTRONIC_ENERGY_RELAY);

                        /* Crafting components */
                        add(pOutput, ModItems.ELECTRIC_MOTOR);
                        add(pOutput, ModItems.HEAT_CONDUCTOR);
                        add(pOutput, ModItems.COIL);
                        add(pOutput, ModItems.BIOPLASTIC);
                        add(pOutput, ModItems.COIL);

                        /* Weapons && Tools */
                        add(pOutput, ModItems.MEMORY_CARD);
                        add(pOutput, ModItems.GEIGER_COUNTER);
                        add(pOutput, ModItems.WIND_METER);
                        add(pOutput, ModItems.ELECTRIC_HOE);
                        add(pOutput, ModItems.ELECTRIC_WRENCH);
                        add(pOutput, ModItems.ELECTRIC_TREETAP);
                        add(pOutput, ModItems.MULTI_TOOL);

                        add(pOutput, ModItems.MINING_DRILL);
                        add(pOutput, ModItems.DIAMOND_DRILL);
                        add(pOutput, ModItems.IRIDIUM_DRILL);

                        add(pOutput, ModItems.CHAINSAW);
                        add(pOutput, ModItems.DIAMOND_CHAINSAW);
                        add(pOutput, ModItems.IRIDIUM_CHAINSAW);

                        add(pOutput, ModItems.NANO_SABER);

                        add(pOutput, ModItems.BRONZE_SWORD);
                        add(pOutput, ModItems.BRONZE_AXE);
                        add(pOutput, ModItems.BRONZE_PICKAXE);
                        add(pOutput, ModItems.BRONZE_SHOVEL);
                        add(pOutput, ModItems.BRONZE_HOE);

                        add(pOutput, ModItems.BRONZE_HELMET);
                        add(pOutput, ModItems.BRONZE_CHESTPLATE);
                        add(pOutput, ModItems.BRONZE_LEGGINGS);
                        add(pOutput, ModItems.BRONZE_BOOTS);

                        add(pOutput, ModItems.HAZMAT_SUIT_BOOTS);
                        add(pOutput, ModItems.HAZMAT_SUIT_CHESTPLATE);
                        add(pOutput, ModItems.HAZMAT_SUIT_LEGGINGS);
                        add(pOutput, ModItems.HAZMAT_SUIT_BOOTS);

                        add(pOutput, ModItems.NANO_HELMET);
                        add(pOutput, ModItems.NANO_CHESTPLATE);
                        add(pOutput, ModItems.NANO_LEGGINGS);
                        add(pOutput, ModItems.NANO_BOOTS);

                        add(pOutput, ModItems.QUANTUM_HELMET);
                        add(pOutput, ModItems.QUANTUM_CHESTPLATE);
                        add(pOutput, ModItems.QUANTUM_LEGGINGS);
                        add(pOutput, ModItems.QUANTUM_BOOTS);

                        /* Batteries */
                        add(pOutput, ModItems.BATTERY);
                        add(pOutput, ModItems.ADVANCED_BATTERY);
                        add(pOutput, ModItems.ENERGY_CRYSTAL);
                        add(pOutput, ModItems.LAPOTRON_CRYSTAL);

                        add(pOutput, ModItems.CHARGING_BATTERY);
                        add(pOutput, ModItems.CHARGING_ADVANCED_BATTERY);
                        add(pOutput, ModItems.CHARGING_ENERGY_CRYSTAL);
                        add(pOutput, ModItems.CHARGING_LAPOTRON_CRYSTAL);

                        /* Generators */
                        add(pOutput, ModItems.GENERATOR);
                        add(pOutput, ModItems.GEO_GENERATOR);
                        add(pOutput, ModItems.SEMIFLUID_GENERATOR);
                        add(pOutput, ModItems.SOLAR_PANEL);
                        add(pOutput, ModItems.ADVANCED_SOLAR_PANEL);
                        add(pOutput, ModItems.HYBRID_SOLAR_PANEL);
                        add(pOutput, ModItems.SOLAR_PANEL);

                        /* Machines */
                        add(pOutput, ModItems.SIMPLE_COMPRESSOR);
                        add(pOutput, ModItems.SIMPLE_CRUSHER);
                        add(pOutput, ModItems.SIMPLE_EXTRACTOR);
                        add(pOutput, ModItems.IRON_FURNACE);

                        add(pOutput, ModItems.ELECTRIC_FURNACE);
                        add(pOutput, ModItems.COMPRESSOR);
                        add(pOutput, ModItems.CRUSHER);
                        add(pOutput, ModItems.EXTRACTOR);
                        add(pOutput, ModItems.EXTRUDER);
                        add(pOutput, ModItems.CANNING_MACHINE);
                        add(pOutput, ModItems.METAL_FORMER);
                        add(pOutput, ModItems.RECYCLER);
                        add(pOutput, ModItems.FLUID_ENRICHER);
                        add(pOutput, ModItems.SAWMILL);

                        add(pOutput, ModItems.ALLOY_SMELTER);
                        add(pOutput, ModItems.FERMENTER);
                        add(pOutput, ModItems.ORE_WASHING_PLANT);
                        add(pOutput, ModItems.THERMAL_CENTRIFUGE);

                        add(pOutput, ModItems.MATTER_FABRICATOR);
                        add(pOutput, ModItems.REPLICATOR);
                        add(pOutput, ModItems.SCANNER);

                        /* Misc items */
                        add(pOutput, ModItems.MUD_PILE);
                        add(pOutput, ModItems.FERTILIZER);
                        add(pOutput, ModItems.BIO_CHAFF);

                        /* Transformers, Energy storages, charge pads */
                        add(pOutput, ModItems.LV_TRANSFORMER);
                        add(pOutput, ModItems.MV_TRANSFORMER);
                        add(pOutput, ModItems.HV_TRANSFORMER);
                        add(pOutput, ModItems.EV_TRANSFORMER);

                        add(pOutput, ModItems.BATTERY_BOX);
                        add(pOutput, ModItems.CESU);
                        add(pOutput, ModItems.MFE);
                        add(pOutput, ModItems.MFSU);

                        add(pOutput, ModItems.CHARGE_PAD_BATTERY_BOX);
                        add(pOutput, ModItems.CHARGE_PAD_CESU);
                        add(pOutput, ModItems.CHARGE_PAD_MFE);
                        add(pOutput, ModItems.CHARGE_PAD_MFSU);

                        /* Deco blocks */
                        add(pOutput, ModItems.ACID_HAZARD_SIGN_BLOCK);
                        add(pOutput, ModItems.BIO_HAZARD_SIGN_BLOCK);
                        add(pOutput, ModItems.EXPLOSION_HAZARD_SIGN_BLOCK);
                        add(pOutput, ModItems.FIRE_HAZARD_SIGN_BLOCK);
                        add(pOutput, ModItems.FROST_HAZARD_SIGN_BLOCK);
                        add(pOutput, ModItems.RADIOACTIVE_HAZARD_SIGN_BLOCK);
                        add(pOutput, ModItems.MAGIC_HAZARD_SIGN_BLOCK);
                        add(pOutput, ModItems.NOISE_HAZARD_SIGN_BLOCK);
                        add(pOutput, ModItems.YELLOW_STRIPES_BLOCK_LEFT);
                        add(pOutput, ModItems.YELLOW_STRIPES_BLOCK_RIGHT);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static void add(CreativeModeTab.Output output, RegistryObject<Item> item) {
        output.accept(item.get());
    }
}
