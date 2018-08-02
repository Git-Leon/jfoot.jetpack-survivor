package com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteSensorDecorator;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles.Gun;
import com.github.git_leon.jetpack_survivor_maven.system.controls.JFootKey;

public class P1Partner extends Ally {
    private P1 player;
    private Gun gun;

    public P1Partner() {
        super("npc/partner1/", ".png", 7);
        this.gun = new Gun(this);
    }

    @Override
    public void postAnimationBehavior() {
        JFootKey.Q.onKeyPress(()->gun.shoot(1));
        shadowPlayer();
    }

    private void shadowPlayer() {
        P1 player = getPlayer();
        if (player != null) {
            int pX = player.getX() - 50;
            int pY = player.getY() - 75;
            setLocation(pX, pY);
        }
    }

    private P1 getPlayer() {
        if (this.player == null) {
            this.player = new SpriteSensorDecorator<P1>(this).getNearest(P1.class);
        }
        return this.player;
    }
}