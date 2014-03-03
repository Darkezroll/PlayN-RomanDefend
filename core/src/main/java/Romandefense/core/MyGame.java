package Romandefense.core;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;

public class MyGame extends Game.Default {

    private ScreenStack ss = new ScreenStack();

  public MyGame() {
    super(33); // call update every 33ms (30 times per second)
  }

  @Override
  public void init() {


      Screen menu = new Home(ss);
      ss.push(menu);
  }

  @Override
  public void update(int delta) {
      ss.update(delta);
  }

  @Override
  public void paint(float alpha) {
    // the background automatically paints itself, so no need to do anything here!
  }
}
