package br.com.project_abcel.abcel.access.utils;

public class ClassInstanceHelper<T> implements AutoCloseable {

	private Class<T> type;

	public ClassInstanceHelper(Class<T> type) {
		this.type = type;
	}

	public T createInstance() throws Exception {
		return type.getDeclaredConstructor().newInstance();
	}

	@Override
	public void close() throws Exception {
	}
}
