package com.github.git_leon.jetpack_survivor_maven.worlds;

import com.github.git_leon.jetpack_survivor_maven.actors.sprite.items.Platform;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.P1;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.ally.P1Partner;
import com.github.git_leon.jetpack_survivor_maven.actors.sprite.npc.enemy.EnemyMaterializer;
import com.github.git_leon.jetpack_survivor_maven.actors.userinterface.gamewindow.GameOverWindow;

public class SubSpriteWorld extends SpriteWorld {
    private P1 p1;

    public SubSpriteWorld() {
        super(800, 300, 1);
    }

    @Override
    public void init() {
        createGround();
        this.p1 = new P1();
        addObject(p1, 0, 0);
        addObject(new EnemyMaterializer(1F), getWidth() - 40, 60);
        addObject(new P1Partner(), 0, 0);
    }

    @Override
    public void act() {
        if (!p1.isAddedToWorld()) {
            addObject(new GameOverWindow(), getWidth() / 2, getHeight() / 2);
        }
    }

    private void createGround() {
        for (int i = 0; i < 13; i++) {
            Platform platform = new Platform();
            int xOffset = platform.getImage().getWidth() / 2;
            addObject(platform, i * xOffset, getHeight());
        }
    }
}
