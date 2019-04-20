package dan200.computercraft.client.entity;

import dan200.computercraft.ComputerCraft;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.world.World;

public class EntityEyebotTurtle extends EntityBlaze
{

    public EntityEyebotTurtle(World worldIn) {
        super(worldIn);
        ComputerCraft.log.warn( "Initting EntityEyebotTurtle");
    }

}
