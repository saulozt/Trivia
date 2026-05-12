package com.saulozt.trivia.educational;

import android.app.Application;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

/**
 * Safe LSPosed/Vector educational hook.
 *
 * This module intentionally does not target any real third-party package. It is
 * scoped to a placeholder app id that you can replace with an app you own or a
 * local demo app when learning LSPosed/Vector behavior.
 */
public final class DemoHook implements IXposedHookLoadPackage {
    private static final String TAG = "TriviaEducationalModule";

    /** Placeholder target. Replace only with your own/demo package. */
    private static final String DEMO_PACKAGE = "com.saulozt.trivia.demo";

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!DEMO_PACKAGE.equals(lpparam.packageName)) {
            return;
        }

        XposedBridge.log(TAG + ": loaded in demo package " + lpparam.packageName);

        findAndHookMethod(Application.class, "onCreate", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) {
                XposedBridge.log(TAG + ": Application.onCreate observed for " + lpparam.packageName);
            }
        });
    }
}
