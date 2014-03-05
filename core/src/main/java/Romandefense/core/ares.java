package Romandefense.core;

import Sprite.Sprite;
import Sprite.SpriteLoader;
import playn.core.Layer;
import playn.core.util.Callback;

/**
 * Created by Chettawat on 4/3/2557.
 */
public class ares {

    private Sprite sprite;
    private int spriteIndex = 0;
    private boolean hasLoaded = false;

    public Layer layer(){
        return sprite.layer();
    }

    public enum State{
        IDLE
    }

    private State state=State.IDLE;
    private int offset=0;
    private int e=0;

    public ares(final float x,final float y){

        sprite = SpriteLoader.getSprite("images/ares.json");
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

    public void update(int delta){
        if (!hasLoaded) return;
        e+=delta;
        if (e > 150){
            switch (state){
                case IDLE: offset =0;
                    break;
            }
            spriteIndex = offset + ((spriteIndex+1)%4);
            sprite.setSprite(spriteIndex);
            e=0;

        }
    }
}
