package data;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalData {
	public static ThreadLocal<ThreadLocalData> tl = null;

	private List<String> infos = new ArrayList<>();
	
	static {
		tl = new InheritableThreadLocal() {
			protected ThreadLocalData initialValue() {
				System.out.println("ThreadLocal.initialValue");
	            return new ThreadLocalData();
	        }
		};
	}
	
	private String name;

	public ThreadLocalData() {
		this.name = Thread.currentThread().getName();
		System.out.println("TestVo() this.name: " + this.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add(String info) {
		infos.add(info);
	}
	
	public void print() {
		System.out.println("print: " + toString());
	}

	@Override
	public String toString() {
		return "ThreadLocalData{" +
				"infos=" + infos +
				", name='" + name + '\'' +
				'}';
	}
}
