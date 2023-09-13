package com.maciej916.indreb.common.sound;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.maciej916.indreb.IndReb.MODID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    public static final RegistryObject<SoundEvent> GENERATOR = registerSound("tile.generator");
    public static final RegistryObject<SoundEvent> GEO_GENERATOR = registerSound("tile.geo_generator");
    public static final RegistryObject<SoundEvent> SOLAR_PANEL = registerSound("tile.solar_generator");
    public static final RegistryObject<SoundEvent> NUCLEAR_REACTOR = registerSound("tile.nuclear_reactor");
    public static final RegistryObject<SoundEvent> SEMIFLUID_GENERATOR = registerSound("tile.semifluid_generator");
    public static final RegistryObject<SoundEvent> CHARGE_PAD = registerSound("tile.charge_pad");

    public static final RegistryObject<SoundEvent> SIMPLE_CRUSHER = registerSound("tile.simple_crusher");
    public static final RegistryObject<SoundEvent> SIMPLE_COMPRESSOR = registerSound("tile.simple_compressor");
    public static final RegistryObject<SoundEvent> SIMPLE_EXTRACTOR = registerSound("tile.simple_extractor");

    public static final RegistryObject<SoundEvent> CRUSHER = registerSound("tile.crusher");
    public static final RegistryObject<SoundEvent> COMPRESSOR = registerSound("tile.compressor");
    public static final RegistryObject<SoundEvent> EXTRACTOR = registerSound("tile.extractor");
    public static final RegistryObject<SoundEvent> SAWMILL = registerSound("tile.sawmill");
    public static final RegistryObject<SoundEvent> RECYCLER = registerSound("tile.recycler");
    public static final RegistryObject<SoundEvent> CANNING_MACHINE = registerSound("tile.canning_machine");
    public static final RegistryObject<SoundEvent> MATTER_FABRICATOR = registerSound("tile.matter_fabricator");
    public static final RegistryObject<SoundEvent> ORE_WASHING_PLANT = registerSound("tile.ore_washing_plant");
    public static final RegistryObject<SoundEvent> METAL_FORMER = registerSound("tile.metal_former");
    public static final RegistryObject<SoundEvent> REPLICATOR = registerSound("tile.replicator");
    public static final RegistryObject<SoundEvent> SCANNER = registerSound("tile.scanner");
    public static final RegistryObject<SoundEvent> THERMAL_CENTRIFUGE = registerSound("tile.thermal_centrifuge");
    public static final RegistryObject<SoundEvent> ALLOY_SMELTER = registerSound("tile.alloy_smelter");
    public static final RegistryObject<SoundEvent> FERMENTER = registerSound("tile.fermenter");
    public static final RegistryObject<SoundEvent> ELECTRIC_FURNACE = registerSound("tile.electric_furnace");

    public static final RegistryObject<SoundEvent> TREETAP = registerSound("item.treetap");
    public static final RegistryObject<SoundEvent> WRENCH = registerSound("item.wrench");
    public static final RegistryObject<SoundEvent> ELECTRIC_WRENCH = registerSound("item.electric_wrench");
    public static final RegistryObject<SoundEvent> PAINTER = registerSound("item.painter");
    public static final RegistryObject<SoundEvent> GEIGER = registerSound("item.geiger");

    public static final RegistryObject<SoundEvent> NIGHT_VISION = registerSound("player.night_vision");

    public static final RegistryObject<SoundEvent> MATTER_FABRICATOR_AMPLIFIED = registerSound("extra.matter_fabricator_amplified");

    private static RegistryObject<SoundEvent> registerSound(String name) {
        ResourceLocation soundLocation = new ResourceLocation(MODID, name);
        SoundEvent soundEvent = SoundEvent.createVariableRangeEvent(soundLocation);
        return SOUNDS.register(name, () -> soundEvent);
    }

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}
