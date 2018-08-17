package ru.zayarniy.alexandr.android.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.zayarniy.alexandr.android.base.Base2DScreen;

/**
 * Экран меню
 */

public class MenuScreen extends Base2DScreen {

    private static final float SPEED = 3f;

    SpriteBatch batch;
    Texture img;
    Texture object;

    Vector2 pos;
    Vector2 v;

    Vector2 touch;
    Vector2 buffer;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("background.png");
        object = new Texture("Nebuchadnezzar.png");
        pos = new Vector2(img.getWidth()/3, 0);
        v = new Vector2(0, 0);
        touch = new Vector2();
        buffer = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        buffer.set(touch);
        if (buffer.sub(pos).len() > SPEED) {
            pos.add(v);
        } else {
            pos.set(touch);
            v.setZero();
        }
        batch.begin();
        batch.draw(img,0,0,800,600);
        batch.draw(object, pos.x, pos.y);
        batch.end();
        pos.add(v);
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        img.dispose();
        object.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(touch.cpy().sub(pos).setLength(SPEED));
        System.out.println("touch.x = " + touch.x + " touch.y = " + touch.y);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        super.touchUp(screenX, screenY, pointer, button);
        return false;
    }


}