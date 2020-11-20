package com.qinbin.jwt.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;

public class FileUtils {
	public static boolean copyFileFromAssetsToDbpath(Context ctx, String fileName) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = ctx.getAssets().open(fileName, Context.MODE_PRIVATE);
			File target = ctx.getDatabasePath(fileName);
			if(target.isDirectory()){
				target.delete();
			}
			target.getParentFile().mkdirs();
			os = new FileOutputStream(target);
			int len = 0;
			byte[] buf = new byte[1024 * 8];

			while ((len = is.read(buf)) != -1) {
				os.write(buf, 0, len);
			}
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeCloseable(is);
			closeCloseable(os);
		}
	}

	public static boolean closeCloseable(Closeable closeable){
		if(closeable != null){
			try {
				closeable.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}else{
			return false;
//			throw new NullPointerException("the closeable is null!");
		}
	}
}
