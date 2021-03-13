package com.gujun.OO;

/**
 * @ClassName gu
 * @Description 缓存实例的不可变类
 * @Author GuJun
 * @Date 2019/6/24 16:53
 * @Version 1.0
 **/
public class CacheImmutable {

    private static int MAX_SIZE=10;

    private static CacheImmutable[] caches=new CacheImmutable[MAX_SIZE];

    private static int pos=0;

    private final String name;

    public CacheImmutable(String name) {   //是否需要隐藏构造器取决于系统需求；此处public则使用new会产生最新的对象，valueOf()会先从缓存数组中取；
        this.name = name;
    }   //通过构造器产生的实例不会缓存

    public String getName() {
        return name;
    }

    public static CacheImmutable valueOf(String name){
        for(int i=0;i<MAX_SIZE;i++){
            if(caches[i]!=null&&caches[i].getName().equals(name)){
                return caches[i];
            }
        }
        if(pos==MAX_SIZE){
            caches[0]=new CacheImmutable(name);
            pos=1;
        }else{
            caches[pos++]=new CacheImmutable(name);
        }
        return caches[pos-1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CacheImmutable that = (CacheImmutable) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
