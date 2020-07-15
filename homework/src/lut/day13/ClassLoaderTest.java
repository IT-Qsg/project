package lut.day13;

public class ClassLoaderTest extends ClassLoader{
    @Override
    protected Class<?> findClass(String name)throws ClassNotFoundException{
        return  null;
    }
}
