package Romandefense.core;

import Sprite.Sprite;
import Sprite.SpriteLoader;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import playn.core.Layer;
import playn.core.util.Callback;
import tripleplay.entity.World;

/**
 * Created by Chettawat on 4/3/2557.
 */
public class zeus {

    private Sprite sprite;
    private int spriteIndex = 0;
    private boolean hasLoaded = false;


    /*private Body initPhysicsBody(World world,float x,float y){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyType.DYNAMIC;
        bodyDef.position = new Vec2(0,0);
        Body body = world.createBody(bodyDef);


        PolygonShape shape = new PolygonShape();
        shape.setAsBox(56 * Game.M_PER_PIXEL/2,
                sprite.layer().height()* Game.M_PER_PIXEL/2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.4f;
        fixtureDef.friction = 0.1f;
        body.createFixture(fixtureDef);

        body.setLinearDamping(0.2f);
        body.setTransform(new Vec2(x, y),0f);
        return body;
    }*/

    public Layer layer(){
        return sprite.layer();
    }

    public enum State{
        IDLE
    }

    private State state=State.IDLE;
    private int offset=0;
    private int e=0;

    public zeus(final float x,final float y){
        sprite = SpriteLoader.getSprite("images/zeus.json");
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
