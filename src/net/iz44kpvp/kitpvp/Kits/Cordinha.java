package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.craftbukkit.v1_7_R4.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import net.minecraft.server.v1_7_R4.*;

public class Cordinha extends EntityFishingHook
{
    private Snowball sb;
    private EntitySnowball controller;
    public int a;
    public EntityHuman owner;
    public Entity hooked;
    public boolean lastControllerDead;
    public boolean isHooked;
    
    public Cordinha(final World world, final EntityHuman entityhuman) {
        super((net.minecraft.server.v1_7_R4.World)((CraftWorld)world).getHandle(), entityhuman);
        this.owner = entityhuman;
    }
    
    protected void c() {
    }
    
    public void h() {
        if (!this.lastControllerDead) {
            final boolean dead = this.controller.dead;
        }
        this.lastControllerDead = this.controller.dead;
        for (final org.bukkit.entity.Entity entity : this.controller.world.getWorld().getEntities()) {
            if (!(entity instanceof Firework) && entity.getEntityId() != this.getBukkitEntity().getEntityId() && entity.getEntityId() != this.owner.getBukkitEntity().getEntityId() && entity.getEntityId() != this.controller.getBukkitEntity().getEntityId() && (entity.getLocation().distance(this.controller.getBukkitEntity().getLocation()) < 2.0 || (entity instanceof Player && ((Player)entity).getEyeLocation().distance(this.controller.getBukkitEntity().getLocation()) < 2.0))) {
                this.controller.die();
                this.hooked = (Entity)entity;
                this.isHooked = true;
                this.locX = entity.getLocation().getX();
                this.locY = entity.getLocation().getY();
                this.locZ = entity.getLocation().getZ();
                this.motX = 0.0;
                this.motY = 0.03;
                this.motZ = 0.0;
            }
        }
        try {
            this.locX = ((org.bukkit.entity.Entity)this.hooked).getLocation().getX();
            this.locY = ((org.bukkit.entity.Entity)this.hooked).getLocation().getY();
            this.locZ = ((org.bukkit.entity.Entity)this.hooked).getLocation().getZ();
            this.motX = 0.0;
            this.motY = 0.03;
            this.motZ = 0.0;
            this.isHooked = true;
        }
        catch (Exception e) {
            if (this.controller.dead) {
                this.isHooked = true;
            }
            this.locX = this.controller.locX;
            this.locY = this.controller.locY;
            this.locZ = this.controller.locZ;
        }
    }
    
    public void die() {
    }
    
    public void remove() {
        super.die();
    }
    
    public void spawn(final Location location) {
        this.sb = (Snowball)this.owner.getBukkitEntity().launchProjectile((Class)Snowball.class);
        this.controller = ((CraftSnowball)this.sb).getHandle();
        final PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(new int[] { this.controller.getId() });
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player p = onlinePlayers[i];
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)packet);
        }
        ((CraftWorld)location.getWorld()).getHandle().addEntity((Entity)this);
    }
    
    public boolean isHooked() {
        return this.isHooked;
    }
    
    public void setHookedEntity(final Entity damaged) {
        this.hooked = damaged;
    }
}
