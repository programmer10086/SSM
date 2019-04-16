package xx.ssm.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import xx.ssm.dao.CoreDao;

public class CoreDaoImpl<T> extends SqlSessionDaoSupport implements CoreDao<T> {
	
	private final static String DOT = ".";
	private final static String INSERT = "insert";
	private final static String UPDATE = "update";
	private final static String DELETE = "delete";
	private final static String GET_ONE = "getOne";
	private final static String GET_LIST = "getList";
	private final static String GET_COUNT = "getCount";
	private final static String GET_PAGINATED_LIST = "getPaginatedList";

	public int insert(T t) {
		final String PREFIX = t.getClass().getName();
		return this.getSqlSession().insert(PREFIX + DOT + INSERT, t);
	}

	public int update(T t) {
		final String PREFIX = t.getClass().getName();
		return this.getSqlSession().update(PREFIX + DOT + UPDATE, t);
	}

	public int delete(T t) {
		final String PREFIX = t.getClass().getName();
		return this.getSqlSession().delete(PREFIX + DOT + DELETE, t);
	}

	public T getOne(T t) {
		final String PREFIX = t.getClass().getName();
		return this.getSqlSession().selectOne(PREFIX + DOT + GET_ONE, t);
	}

	public List<T> getList(T t) {
		final String PREFIX = t.getClass().getName();
		return this.getSqlSession().selectList(PREFIX + DOT + GET_LIST, t);
	}

	public int getCount(T t) {
		final String PREFIX = t.getClass().getName();
		return this.getSqlSession().selectOne(PREFIX + DOT + GET_COUNT, t);
	}

	public List<T> getPaginatedList(T t) {
		final String PREFIX = t.getClass().getName();
		return this.getSqlSession().selectList(PREFIX + DOT + GET_PAGINATED_LIST, t);
	}

}
