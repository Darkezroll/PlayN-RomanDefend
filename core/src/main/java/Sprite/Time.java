package Sprite;

import Romandefense.core.GameScreen;
import playn.core.Layer;
import playn.core.util.Callback;


/**
 * Created by Chettawat on 13/3/2557.
 */
public class Time {

    private Sprite sprite;
    private int spriteIndex = 0;
    private boolean hasLoaded = false;
    private GameScreen g;

    public int time = 0;

    public Time(final float x,final float y){
        sprite = SpriteLoader.getSprite("images/Time.json");
        sprite.addCallback(new Callback<Sprite>() {
            @Override
            public void onSuccess(Sprite result) {

                sprite.setSprite(spriteIndex);
                sprite.layer().setOrigin(sprite.width()/2f,sprite.height()/2f);
                sprite.layer().setTranslation(x,y);

                hasLoaded = true;

            }

            @Override
            public void onFailure(Throwable cause) {

            }
        });

    }

    public Layer layer(){
        return sprite.layer();
    }

    public enum State{
        IDLE
    }

    private State state=State.IDLE;
    private int offset=0;
    private int e=0;



    public void update(int delta){
        if (!hasLoaded) return;
        e+= delta+delta;
        if (e > 10){
            switch (state){
                case IDLE: offset = 0;

                    if (spriteIndex == 8){
                        time = time + 1;
                    }

                    break;
            }
            spriteIndex = offset + ((spriteIndex+1)%9);
            sprite.setSprite(spriteIndex);
            e = 0;

        }
    }
}

