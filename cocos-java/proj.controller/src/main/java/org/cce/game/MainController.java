package org.cce.game;

/**
 *  * Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */

import org.cce.framework.GamePlayerClient;
import org.ccj.Application;
import org.ccj.Director;
import org.ccj.GLView;
import org.ccj.Logger;
import org.ccj.base.FileUtils;
import org.ccj.editor.cce.CCEReader;

import java.io.IOException;

/**
 * -Game Engine:Cocos2d-Java
 * -
 * -Game Develop Tool:CocosEditor
 * -
 * -Doc Links
 * http://www.cocoseditor.com/ (Office Website)
 * http://blog.makeapp.co/ (Office Blog)
 * http://blog.csdn.net/touchsnow (csdn Blog)
 * https://github.com/makeapp      (github)
 * -
 * -Support
 * E-Mail:  zuowen@makeapp.co
 * QQ    :  232361142
 */
public class MainController {

    public static final int DESIGN_WIDTH = 1280;
    public static final int DESIGN_HEIGHT = 720;

    public static void mainScene() {
        String paths[] = {
                ""
        };
        for (String path : paths) {
            FileUtils.getInstance().addSearchPath(path);
        }
        Director director = Director.getInstance();
        director.setDisplayStats(true);
        director.getOpenGLView().setDesignResolutionSize(DESIGN_WIDTH, DESIGN_HEIGHT, GLView.POLICY_EXACT_FIT);
        director.runWithScene(CCEReader.create().readScene("layouts/main.cce"));
    }

    public static void main(final String[] args) {
        int w = DESIGN_WIDTH ;
        int h = DESIGN_HEIGHT ;

        if (args != null && args.length >= 2) {
            w = Integer.parseInt(args[0]);
            h = Integer.parseInt(args[1]);
        }

        final int width = w;
        final int height = h;

        GamePlayerClient client = GamePlayerClient.getInstance();
        client.setHost("192.168.1.104");
        client.setName("test1");
        client.start();

        Application app = new Application() {
            public boolean applicationDidFinishLaunching() {
                if (OS_WINDOWS == getTargetPlatform()
                        || OS_ANDROID == getTargetPlatform()
                        || OS_MAC == getTargetPlatform()) {
                    GLView eglView = GLView.create("CocosControl");
                    eglView.setFrameSize(width, height);
                    Logger.log("width  " + width + " height " + height);
                    Director.getInstance().setOpenGLView(eglView);
                }
                MainController.mainScene();
                return true;
            }
        };
        app.run();
    }
}
