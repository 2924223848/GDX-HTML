package team.rpsg.htmlTest.view;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import script.ui.widget.widget.Image;
import script.ui.widget.widget.Label;
import team.rpsg.gdxQuery.$;
import team.rpsg.htmlTest.core.Game;
import team.rpsg.htmlTest.core.Log;
import team.rpsg.htmlTest.core.Path;
import team.rpsg.htmlTest.core.Res;
import team.rpsg.htmlTest.ui.view.View;

/**
 * 载入动画视图<br>
 * {@link LoadView}在一般情况下，是为{@link Res}工作的，当其正在加载东西时，LoadView将在游戏最上层画出加载动画，但也可以手动的调用{@link #start(String)}让其工作。
 */
public class LoadView extends View {

	/**当为false时，本视图将被绘制*/
	private boolean updated = true;
	/**id列表*/
	private List<String> idList = new ArrayList<>();

	//Label fps = new Label("1 ", 17), fpsShadow = new Label(" ", 17);
	Group sprite;

	public void create() {
		stage = Game.stage();
		
		Image image = Res.get(Path.IMAGE_LOAD + "sprite.png");
		image.query().action(Actions.forever(Actions.rotateBy(360, .5f))).position(Game.STAGE_WIDTH - 70, 30).to(stage);

		$.add(sprite = new Group()).addActor(image).a(0).to(stage);

//		$.add(fpsShadow).position(4, Game.STAGE_HEIGHT - 24).color(Color.BLACK).a(0.5f).to(stage);
//		$.add(fps).position(3, Game.STAGE_HEIGHT - 23).color(Color.WHITE).a(0.5f).to(stage);

		
		Log.i("Load-view[created]");
	}

	public void draw() {
		//如果Res正在处理资源，或有自定义资源正在处理，则画图
		stage.act();
		stage.draw();
	}

	public void act() {
		//更新资源
		updated = Res.act();
		if(sprite.getActions().size == 0){
			if(updated && idList.isEmpty() && sprite.getColor().a == 1f)
				sprite.addAction(Actions.fadeOut(.3f));
			
			if((!updated || !idList.isEmpty()) && sprite.getColor().a == 0)
				sprite.addAction(Actions.fadeIn(.3f));
		}


//		String currentFPS = Gdx.graphics.getFramesPerSecond() + "";

//		fps.text(currentFPS);
//		fpsShadow.text(currentFPS);
	}
	
	public void start(String id) {
		idList.add(id);

		sprite.clearActions();
		sprite.addAction(Actions.fadeIn(.3f));
	}
	
	public void stop(String id) {
		idList.remove(id);
	}
	
	public boolean updated() {
		return updated;
	}
	
}
