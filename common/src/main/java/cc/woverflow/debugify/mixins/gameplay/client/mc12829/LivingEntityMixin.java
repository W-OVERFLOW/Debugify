package cc.woverflow.debugify.mixins.gameplay.client.mc12829;

import cc.woverflow.debugify.fixes.BugFix;
import cc.woverflow.debugify.fixes.FixCategory;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@BugFix(id = "MC-12829", category = FixCategory.GAMEPLAY, env = BugFix.Env.CLIENT)
@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @ModifyExpressionValue(method = "isClimbing", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;isSpectator()Z"))
    protected boolean isNotClimbing(boolean isSpectator) {
        return isSpectator;
    }
}
