package com.hk47bot.rotp_wr.entity.stand.stands;

import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityType;

import com.hk47bot.rotp_wr.client.ui.weather.WeatherChangeMenu;
import com.hk47bot.rotp_wr.init.InitStands;
import net.minecraft.client.gui.screen.GamemodeSelectionScreen;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class WeatherReportEntity extends StandEntity {
    public WeatherReportEntity(StandEntityType<WeatherReportEntity> type, World world) {
        super(type, world);
    }
    public float cloudRotation = 0.0F;
    public boolean isBarraging(){
        return this.getCurrentTaskAction() == InitStands.WEATHER_REPORT_BARRAGE.get();
    }

    public boolean isDeflecting(){
        return this.getCurrentTaskAction() == InitStands.WEATHER_REPORT_CLOUD_SHIELD.get();
    }
    @Override
    public void tick() {
        super.tick();
        // clouds
        if (cloudRotation > 360.0F){
            cloudRotation -= 0.015F;
            if (this.getCurrentTaskAction() == InitStands.WEATHER_REPORT_CHANGE_WEATHER.get()){
                cloudRotation -= 0.03F;
            }
        }
        else {
            cloudRotation += 0.015F;
            if (this.getCurrentTaskAction() == InitStands.WEATHER_REPORT_CHANGE_WEATHER.get()){
                cloudRotation += 0.03F;
            }
        }
        // rain
        if (this.level.getLevelData().isRaining() && !this.isBarraging()){
            for (int i = 0; i < 2; i++) {
                this.level.addParticle(ParticleTypes.FALLING_WATER, this.getRandomX(1), this.getRandomY(), this.getRandomZ(1), 0, 1, 0);
            }
        }
    }
}
