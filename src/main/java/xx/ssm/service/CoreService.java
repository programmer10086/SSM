package xx.ssm.service;

import java.util.List;

public interface CoreService<T> {

	public int create(T t);

	public int modify(T t);

	public int remove(T t);

	public T getOne(T t);

	public List<T> getList(T t);

	public int getCount(T t);

	public List<T> getPaginatedList(T t);

}
