package com.hoangddt.duoihinhbatchu.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

public class FileUtils {
    private static FileUtils instance;
    private Context context;

    private FileUtils(Context c) {
        this.context = c;
    }

    public static FileUtils getInstance(Context c) {
        if (instance == null) {
            instance = new FileUtils(c);
        }
        return instance;
    }

    public int getResId(String drawableName) {
        return context.getResources().getIdentifier(drawableName, "drawable", context.getPackageName());
    }

    public int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Drawable getDrawable(String name) {
        return context.getResources().getDrawable(getResId(name));
    }
}