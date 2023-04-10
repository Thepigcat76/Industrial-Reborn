package com.maciej916.indreb.common.client.keys;

import com.maciej916.indreb.IndReb;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class ModKeys {
    private static final String CATEGORY = "Industrial Reborn";

    public static final KeyMapping NIGHT_VISION_KEY = new KeyMapping("key." + IndReb.MODID + ".night_vision", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_C, CATEGORY);

    public static final KeyMapping CREATIVE_FLIGHT_KEY = new KeyMapping("key." + IndReb.MODID + ".creative_flight_key", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_I, CATEGORY);

    public static final KeyMapping SPEED_BOOST_KEY = new KeyMapping("key." + IndReb.MODID + ".speed_boost_key", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, CATEGORY);
    public static final KeyMapping JUMP_BOOST_KEY = new KeyMapping("key." + IndReb.MODID + ".jump_boost_key", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_J, CATEGORY);

    public static final KeyMapping QUANTUM_ABILITY_KEY = new KeyMapping("key." + IndReb.MODID + ".quantum_ability_key", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_M, CATEGORY);
}