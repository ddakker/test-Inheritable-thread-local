package service;

import data.ThreadLocalData;

public class TestSerice {
    public int test1(String s) {
        ThreadLocalData vo = ThreadLocalData.tl.get();
        vo.add("C : " + Thread.currentThread().getName() + ", s: " + s);
        return 0;
    }
}
