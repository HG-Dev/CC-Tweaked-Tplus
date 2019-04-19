package dan200.computercraft.client.render;

import dan200.computercraft.client.entity.EntityEyebotTurtle;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEyebotTurtle extends RenderLiving<EntityEyebotTurtle>
{

    private static final ResourceLocation EYEBOT_TEXTURE = new ResourceLocation( "computercraft", "textures/entities/eyebot.png");
    public static final Factory FACTORY = new Factory();
    private static final String __OBFID = "CL_11111111";

    public RenderEyebotTurtle(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelEyebotTurtle(), 1.0F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityEyebotTurtle entityEyebotTurtle)
    {
        return EYEBOT_TEXTURE;
    }

    protected ResourceLocation getEntityTexture(Object genericEntity)
    {
        return this.getEntityTexture((EntityEyebotTurtle)genericEntity);
    }

    public static class Factory implements IRenderFactory<EntityEyebotTurtle>
    {

        @Override
        public Render<? super EntityEyebotTurtle> createRenderFor(RenderManager manager) {
            return new RenderEyebotTurtle(manager);
        }
    }

}
