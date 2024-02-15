package design_patterns.factory;

public class Flutter {

    public static UIFactory getUIFactoryByPlatform(Platform platform){
        if(platform.equals(Platform.IOS)){
            return new IosFactory();
        }else if(platform.equals(Platform.ANDROID)){
            return new AndroidFactory();
        }
        else {
            throw new UnsupportedOperationException("This platform is not yet available");
        }
    }
}
