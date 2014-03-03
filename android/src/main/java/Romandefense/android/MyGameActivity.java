package Romandefense.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import Romandefense.core.MyGame;

public class MyGameActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new MyGame());
  }
}
