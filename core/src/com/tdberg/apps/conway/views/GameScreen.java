package com.tdberg.apps.conway.views;

import com.badlogic.gdx.graphics.GL20;
import com.tdberg.apps.conway.ConwayGdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

// Test code
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import space.earlygrey.shapedrawer.ShapeDrawer;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Texture;
import com.tdberg.apps.conway.objects.GameCell;
import com.badlogic.gdx.graphics.Color;

public class GameScreen extends ScreenAdapter {
    private OrthographicCamera camera;
    private Stage stage;
    private FitViewport viewport;

    // Test code
    private PolygonSpriteBatch batch;
    private Pixmap pixmap;
    private Texture greenTexture;
    private ShapeDrawer drawer;
    private GameCell testCell;

    public GameScreen(final OrthographicCamera camera) {
        this.camera = camera;

        viewport = new FitViewport(ConwayGdx.getInstance().getScreenWidth(),
                        ConwayGdx.getInstance().getScreenHeight(), camera);
        stage = new Stage(viewport);
        stage.setDebugAll(true);

        // Test code
        batch = new PolygonSpriteBatch();
        pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.GREEN);
        pixmap.drawPixel(0,0);
        greenTexture = new Texture(pixmap);
        pixmap.dispose();
        TextureRegion region = new TextureRegion(greenTexture, 0, 0, 1, 1);
        drawer = new ShapeDrawer(batch, region);
        testCell = new GameCell(ConwayGdx.getInstance().getScreenWidth()/2, ConwayGdx.getInstance().getScreenHeight()/2, 0);
    }

    public void update(float delta) {

    }

    @Override
    public void render(float delta) {
        update(delta);
        camera.update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        viewport.apply();
        // Need to decide of Scene2D is what we want to use here.
        batch.begin();

        testCell.render(batch, drawer);

        batch.end();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    public Stage getStage() {
        return stage;
    }
}
