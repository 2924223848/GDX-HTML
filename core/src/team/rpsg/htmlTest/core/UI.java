package team.rpsg.htmlTest.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import script.ui.widget.widget.Button;
import script.ui.widget.widget.Image;

/**
 * GDX-RPG UI工具类
 */
public class UI {
	private static Texture base;
	private static NinePatchDrawable button, button_press, button_press_noborder;
	
	public static Image base(){
		return new Image(base);
	}

	public static Drawable baseDrawable(){
		return new TextureRegionDrawable(new TextureRegion(base));
	}

	public static Button button() {
		return new Button(button, button_press);
	}

	public static <T extends com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle> T button(T style) {
		style.up = button;
		style.down = button_press;
		return style;
	}

	public static <T extends com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle> T buttonNoBorder(T style) {
		style.up = button;
		style.down = button_press_noborder;
		return style;
	}

	public static Button buttonNoBorder() {
		return new Button(button, button_press_noborder);
	}
	
	public static void init(){
		base = Res.getTexture(team.rpsg.htmlTest.core.Path.IMAGE_GLOBAL + "white.jpg");

		button = new NinePatchDrawable(get9(team.rpsg.htmlTest.core.Path.IMAGE_GLOBAL + "button.png"));
		button_press = new NinePatchDrawable(get9(team.rpsg.htmlTest.core.Path.IMAGE_GLOBAL + "button_p.png"));
		button_press_noborder = new NinePatchDrawable(get9(team.rpsg.htmlTest.core.Path.IMAGE_GLOBAL + "button_p_noborder.png"));

		team.rpsg.htmlTest.core.Log.i("UI[created]");
	}

	private static NinePatch get9(String fname){
		return get9(fname, 2, 2, 1, 1, 12, 12, 12, 12);
	}

	private static NinePatch get9(String fname, int wpad, int hpad, int woff, int hoff, int left, int right, int top, int bottom) {
		final Texture t = new Texture(Gdx.files.internal(fname));
		t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		final int width = t.getWidth() - wpad;
		final int height = t.getHeight() - hpad;
		return new NinePatch(new TextureRegion(t, woff, hoff, width, height), left, right, top, bottom);
	}


}
