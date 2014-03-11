package Romandefense.core;

import playn.core.Game;
import playn.core.Mouse;
import playn.core.PlayN;
import playn.core.util.Clock;
import tripleplay.game.ScreenStack;



public class MyGame extends Game.Default {

    private ScreenStack ss = new ScreenStack();
    private Clock.Source clock = new Clock.Source(33);

    public MyGame() {
        super(33);
    }

    @Override
    public void init() {

        ss.push(new HomeScreen(ss));

    }

    @Override
    public void update(int delta) {

        ss.update(delta);

    }

    @Override
    public void paint(float alpha) {

        clock.paint(alpha);
        ss.paint(clock);

    }
}