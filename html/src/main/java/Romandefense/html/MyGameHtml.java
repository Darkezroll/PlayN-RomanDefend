package Romandefense.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import Romandefense.core.MyGame;

public class MyGameHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform.Config config = new HtmlPlatform.Config();
    // use config to customize the HTML platform, if needed
    HtmlPlatform platform = HtmlPlatform.register(config);
    platform.assets().setPathPrefix("RomanDef/");
    PlayN.run(new MyGame());
  }
}
