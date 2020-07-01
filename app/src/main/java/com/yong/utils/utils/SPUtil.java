package com.yong.utils.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

/**
 * Created by liaoxiang on 16/3/17.
 */
public class SPUtil {
    static SharedPreferences sp;

    public static void init(String mSpName, Context context) {
        if (sp == null) {
            String spName;
            if (TextUtils.isEmpty(mSpName)) {
                spName = context.getPackageName();
            } else {
                spName = mSpName;
            }
            sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        }
    }

    /**
     * 保存SharedPreferences数据
     *
     * @param map 键值对，值必须是int，float,boolean,string,long类型，其余类型不支持
     */
    public static synchronized void save(Map<String, Object> map) {
        if (sp != null) {
            SharedPreferences.Editor editor = sp.edit();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object o = entry.getValue();
                if (o instanceof String) {
                    editor.putString(entry.getKey(), (String) o);
                } else if (o instanceof Integer) {
                    editor.putInt(entry.getKey(), (Integer) o);
                } else if (o instanceof Long) {
                    editor.putLong(entry.getKey(), (Long) o);
                } else if (o instanceof Boolean) {
                    editor.putBoolean(entry.getKey(), (Boolean) o);
                } else if (o instanceof Float) {
                    editor.putFloat(entry.getKey(), (Float) o);
                } else {
                    //不支持的类型，不做操作
                }
            }
            editor.apply();
        }
    }

    /**
     * 保存String型数据
     *
     * @param key   键
     * @param value 值
     */
    public static synchronized void save(String key, String value) {
        if (sp != null) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(key, value).apply();
        }
    }

    /**
     * 保存Int型数据
     *
     * @param key   键
     * @param value 值
     */
    public static synchronized void save(String key, int value) {
        if (sp != null) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt(key, value).apply();
        }
    }

    /**
     * 保存Boolean型数据
     *
     * @param key   键
     * @param value 值
     */
    public static synchronized void save(String key, boolean value) {
        if (sp != null) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(key, value).apply();
        }
    }

    public static synchronized void save(String key, Long value) {
        if (sp != null) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putLong(key, value).apply();
        }
    }

    /**
     * 获取存储的字符型数据
     *
     * @param key 键
     * @return value
     */
    public static String getString(String key) {
        return sp == null ? "" : sp.getString(key, "");
    }

    /**
     * 获取存储的布尔型数据
     *
     * @param key 键
     * @return value
     */
    public static boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    /**
     * 获取存储的int型数据
     *
     * @param key 键
     * @return value 默认－1
     */
    public static int getInt(String key) {
        return sp != null ? sp.getInt(key, -1) : -1;
    }

    /**
     * 获取存储的布尔型数据
     *
     * @param key 键
     * @param def 默认值
     * @return value
     */
    public static boolean getBoolean(String key, boolean def) {
        return sp != null && sp.getBoolean(key, def);
    }

    public static Object getLong(String key) {

        return sp == null ? 0L : sp.getLong(key, 0L);
    }

    /**
     * 删除对应key的SharedPreferences数据
     *
     * @param key 键
     */
    public static synchronized void remove(String key) {
        if (sp != null) {
            sp.edit().remove(key).apply();
        }
    }

    /**
     * 删除对应key的SharedPreferences数据
     *
     * @param keys 需删除的键的集合
     */
    public static synchronized void remove(String[] keys) {
        if (sp != null) {
            for (String key : keys) {
                sp.edit().remove(key).apply();
            }
        }
    }

    /**
     * 清空所有SharedPreferences数据
     */
    public static void clear() {
        if (sp != null) {
            sp.edit().clear().apply();
        }
    }


    public static void save(String key, List<String> value) {
        if (sp != null) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(key, new Gson().toJson(value)).apply();
        }
    }
}
