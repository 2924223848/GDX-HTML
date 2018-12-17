package team.rpsg.html.android;

import android.os.Bundle;
import box2dLight.RayHandler;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import team.rpsg.htmlTest.core.Views;

/**
 * android launcher
 */
public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.numSamples=8;

		initialize(new Views(), config);
	}


}
