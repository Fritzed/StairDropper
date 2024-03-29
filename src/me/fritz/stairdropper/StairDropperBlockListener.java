package me.fritz.stairdropper;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.inventory.ItemStack;

/** Listens for block changes
 * 
 * @author Fritz
 *
 */
public class StairDropperBlockListener extends BlockListener {
    List<Integer> pickaxeList = new ArrayList<Integer>();
    List<Integer> axeList = new ArrayList<Integer>();

    List<Integer> stoneBlocks = new ArrayList<Integer>();
    List<Integer> woodenBlocks = new ArrayList<Integer>();

    /** Listens for block changes
     */
    public StairDropperBlockListener() {
        pickaxeList.add(270);
        pickaxeList.add(274);
        pickaxeList.add(257);
        pickaxeList.add(278);

        axeList.add(271);
        axeList.add(275);
        axeList.add(258);
        axeList.add(279);

        stoneBlocks.add(67);
        stoneBlocks.add(108);
        stoneBlocks.add(109);
        stoneBlocks.add(114);

        woodenBlocks.add(53);
    }

    /** Called by the bukkit plugin manager whenever a block is broken
     * 
     * @param event BlockBreakEvent generated by bukkit
     */
    @Override
    public void onBlockBreak(BlockBreakEvent event){
        Integer blockType = event.getBlock().getTypeId();
        Integer tool = event.getPlayer().getItemInHand().getTypeId();

        if (stoneBlocks.contains(blockType) && pickaxeList.contains(tool)) {
            dropItem(event);
        }

        else if (woodenBlocks.contains(blockType) && axeList.contains(tool)) {
            dropItem(event);
        }
    }

    /** Drops an item based upon the event details
     * 
     * @event BlockBreakEvent generated by bukkit
     */
    private void dropItem(BlockBreakEvent event) {
        Block block = event.getBlock();
        Location location = block.getLocation();
        World world = block.getWorld();
        ItemStack drop = new ItemStack(block.getTypeId(),1);

        event.setCancelled(true);
        block.setTypeId(0);
        world.dropItem(location, drop);
    }
}