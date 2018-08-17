package ru.zayarniy.alexandr.android;

import com.badlogic.gdx.Game;

import ru.zayarniy.alexandr.android.screen.MenuScreen;

public class Star2DGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
