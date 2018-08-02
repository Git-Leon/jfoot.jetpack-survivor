package com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.weapons.projectiles;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.Sprite;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.SpriteCreatorRemover;

public class Bullet extends Sprite implements ProjectileInterface {
    private int speed = 5;
    private SpriteCreatorRemover spriteCreatorRemover;

    public Bullet() {
        super("ant.png");
        this.spriteCreatorRemover = new SpriteCreatorRemover(this);
    }

    public void act() {
        moveRight(speed);
        spriteCreatorRemover.destroy((sprite)-> sprite.isAtEdge(), this);
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}