package DesignPattern.StructurePatterns.FlyWeightPattern.Solution;

import java.util.HashMap;

public class BulletTypeFactory {
    public static final HashMap<String,BulletType> bulletTypes=new HashMap<>();

    public static BulletType getBulletType(String type){
        if(!bulletTypes.containsKey(type)){
            bulletTypes.put(type,new BulletType(type));
        }
        return bulletTypes.get(type);
    }
}
