/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCActionEase.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class EaseElasticInOut
    extends EaseElastic
{
    /**
     * Creates the action with the inner action and the period in radians (default is 0.3)
     */
    public native static EaseElasticInOut create(ActionInterval action, float period);

    public native static EaseElasticInOut create(ActionInterval action);

    // Overrides
//    public native void update(float time) ;
    public native EaseElasticInOut clone();

    public native EaseElasticInOut reverse();

}
