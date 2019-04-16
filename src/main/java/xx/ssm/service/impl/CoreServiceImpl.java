package xx.ssm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import xx.ssm.service.CoreService;

@Service
public class CoreServiceImpl<T> implements CoreService<T> {

	public int create(T t) {
		return 0;
	}

	public int modify(T t) {
		return 0;
	}

	public int remove(T t) {
		return 0;
	}

	public T getOne(T t) {
		return null;
	}

	public List<T> getList(T t) {
		return null;
	}

	public int getCount(T t) {
		return 0;
	}

	public List<T> getPaginatedList(T t) {
		return null;
	}

}
