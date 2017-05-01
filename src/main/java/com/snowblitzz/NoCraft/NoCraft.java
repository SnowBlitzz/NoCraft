package com.snowblitzz.NoCraft;

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.InteractBlockEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

@Plugin(id = "nocraft", name = "NoCraft", version = "1.0.0", description = "Disallows right clicking on workbench.")
public class NoCraft {	
	
	@Listener
	public void onRightClick(InteractBlockEvent.Secondary.MainHand event, @First Player player) {
		
		if(event.getTargetBlock().getLocation().isPresent()) {
			Location<World> block = event.getTargetBlock().getLocation().get();
	        if(block.getBlock().getType() == BlockTypes.CRAFTING_TABLE) {
	        	event.setCancelled(true);
	        	player.sendMessage(Text.of(TextColors.RED, "You are not allowed to craft with the workbench."));
	        }
		}
	}
}
