package com.AutomaticalEchoes.SimpleAndUnadorned.client.Renderer;

import com.AutomaticalEchoes.SimpleAndUnadorned.common.projectile.DipolarTubeProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DipolarTubeRender extends EntityRenderer<DipolarTubeProjectile> {
    private static final float MIN_CAMERA_DISTANCE_SQUARED = 12.25F;
    private final ItemRenderer itemRenderer;
    private final float scale;
    private final boolean fullBright;

    public DipolarTubeRender(EntityRendererProvider.Context p_174416_, float p_174417_, boolean p_174418_) {
        super(p_174416_);
        this.itemRenderer = p_174416_.getItemRenderer();
        this.scale = p_174417_;
        this.fullBright = p_174418_;
    }

    public DipolarTubeRender(EntityRendererProvider.Context p_174414_) {
        this(p_174414_, 1.0F, false);
    }

    protected int getBlockLightLevel(DipolarTubeProjectile p_116092_, BlockPos p_116093_) {
        return this.fullBright ? 15 : super.getBlockLightLevel(p_116092_, p_116093_);
    }

    public void render(DipolarTubeProjectile p_116085_, float p_116086_, float p_116087_, PoseStack p_116088_, MultiBufferSource p_116089_, int p_116090_) {
        if (p_116085_.TickCount() >= 2 || !(this.entityRenderDispatcher.camera.getEntity().distanceToSqr(p_116085_) < 12.25D)) {
            p_116088_.pushPose();
            p_116088_.translate(0,0.25F,0);
            p_116088_.scale(this.scale, this.scale, this.scale);
            float Rx = Mth.lerp(p_116086_, p_116085_.xRotO, p_116085_.getXRot());
            float Ry = Mth.lerp(p_116087_, p_116085_.yRotO, p_116085_.getYRot()) ;
            p_116088_.mulPose(Vector3f.YP.rotationDegrees(p_116085_.isVertical() ? Ry - 90.0F : Ry));
            p_116088_.mulPose(Vector3f.ZP.rotationDegrees(p_116085_.isVertical() ? Rx + 90.0F : p_116085_.turnAngle * 30F));
            this.itemRenderer.renderStatic(p_116085_.getItem(), ItemTransforms.TransformType.GROUND, p_116090_, OverlayTexture.NO_OVERLAY, p_116088_, p_116089_, p_116085_.getId());
            p_116088_.popPose();
            super.render(p_116085_, p_116086_, p_116087_, p_116088_, p_116089_, p_116090_);
        }
    }

    public ResourceLocation getTextureLocation(DipolarTubeProjectile p_116083_) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
