package xx.ssm.dao;

import java.util.List;

public interface CoreDao<T> {

	public int insert(T t);

	public int update(T t);

	public int delete(T t);

	public T getOne(T t);

	public List<T> getList(T t);

	public int getCount(T t);

	public List<T> getPaginatedList(T t);

}
