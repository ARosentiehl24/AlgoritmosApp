/**
 * @author dawson dong
 */

package com.unimagdalena.android.app.algoritmosapp.util.kisstools.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.unimagdalena.android.app.algoritmosapp.util.kisstools.KissTools;

public class DebugUtil {

	public static boolean isDebugable() {
		try {
			Context context = KissTools.getApplicationContext();
			ApplicationInfo info = context.getApplicationInfo();
			return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
