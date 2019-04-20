/*
 * This file is part of ComputerCraft - http://www.computercraft.info
 * Copyright Daniel Ratcliffe, 2011-2019. Do not distribute without permission.
 * Send enquiries to dratcliffe@gmail.com
 */

package dan200.computercraft.client.proxy;

import dan200.computercraft.ComputerCraft;
import dan200.computercraft.client.entity.EntityEyebotTurtle;
import dan200.computercraft.client.render.TileEntityCableRenderer;
import dan200.computercraft.client.render.TileEntityMonitorRenderer;
import dan200.computercraft.client.render.TileEntityTurtleRenderer;
import dan200.computercraft.shared.command.CommandCopy;
import dan200.computercraft.shared.peripheral.modem.wired.TileCable;
import dan200.computercraft.shared.peripheral.monitor.ClientMonitor;
import dan200.computercraft.shared.peripheral.monitor.TileMonitor;
import dan200.computercraft.shared.proxy.ComputerCraftProxyCommon;
import dan200.computercraft.shared.turtle.blocks.TileTurtle;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.BiomeDictionary;

public class ComputerCraftProxyClient extends ComputerCraftProxyCommon
{
    @Override
    public void preInit()
    {
        super.preInit();

        // Register any client-specific commands
        ClientCommandHandler.instance.registerCommand( CommandCopy.INSTANCE );
    }

    @Override
    public void init()
    {
        super.init();

        // Setup renderers
        ClientRegistry.bindTileEntitySpecialRenderer( TileMonitor.class, new TileEntityMonitorRenderer() );
        ClientRegistry.bindTileEntitySpecialRenderer( TileCable.class, new TileEntityCableRenderer() );
        ClientRegistry.bindTileEntitySpecialRenderer( TileTurtle.class, new TileEntityTurtleRenderer() );

    }

    @Mod.EventBusSubscriber( modid = ComputerCraft.MOD_ID, value = Side.CLIENT )
    public static final class ForgeHandlers
    {
        public static EntityEntry EYEBOT = EntityEntryBuilder.create()
            .entity(EntityEyebotTurtle.class)
            .id(new ResourceLocation(ComputerCraft.MOD_ID, "EyebotTurtle"), 0)
            .name("EyebotTurtle")
            .egg(0xFFFFFF, 0xAAAAAA)
            .tracker(64, 20, false)
            .spawn(EnumCreatureType.CREATURE, 20, 1, 5, BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST))
            .build();

        @SubscribeEvent
        public static void onEvent(final RegistryEvent.Register<EntityEntry> event)
        {
            final IForgeRegistry<EntityEntry> registry = event.getRegistry();

            registry.register(EYEBOT);
        }

        @SubscribeEvent
        public static void onWorldUnload( WorldEvent.Unload event )
        {
            if( event.getWorld().isRemote )
            {
                ClientMonitor.destroyAll();
            }
        }
    }


}
