package com.w951.util.service;

import java.util.List;

public interface CommonService<T> {
	public String delete(T entity);
	public T get(String id);
	public long getCount();
	public String insert(T entity);
	public List<T> queryList(String... order);
	public List<T> queryPageList(int pageIndex, int pageSize, String... order);
	public String update(T entity);
}
