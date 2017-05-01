/**
 * This file is part of ComputerCraft - http://www.computercraft.info
 * Copyright Daniel Ratcliffe, 2011-2016. Do not distribute without permission.
 * Send enquiries to dratcliffe@gmail.com
 */

package dan200.computercraft.shared.util;

import dan200.computercraft.ComputerCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabTreasure extends CreativeTabs
{
    public CreativeTabTreasure( int i )
    {
        super( i, "Treasure Disks" );
    }
    
    @Override
    public Item getTabIconItem()
    {
        return ComputerCraft.Items.treasureDisk;
    }
    
    @Override
    public String getTranslatedTabLabel()
    {
    	return getTabLabel();
    }
}
