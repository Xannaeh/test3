package com.xannaeh.mdzs;

import com.xannaeh.mdzs.core.init.BlockInit;
import com.xannaeh.mdzs.core.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.javafmlmod.FMLModContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Mdzs.MODID)
@Mod.EventBusSubscriber(modid = Mdzs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Mdzs {
    public static final String MODID = "mdzs";

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public Mdzs() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
    BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
        event.getRegistry().register(new BlockItem(block, new Item.Properties()
                .tab(ItemGroup.TAB_MISC)).setRegistryName(block.getRegistryName()));
    });
    }
}