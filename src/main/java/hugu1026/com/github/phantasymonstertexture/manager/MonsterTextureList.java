package hugu1026.com.github.phantasymonstertexture.manager;

import java.util.HashMap;
import java.util.Map;

public class MonsterTextureList {

    private static final Map<String, Integer> textureList = new HashMap<>();

    static {
        //(key is mob name, and value is meta(texture number))
        textureList.put("テスト", 1);
    }

    public static Map<String, Integer> getTextureList() {
        return textureList;
    }
}
