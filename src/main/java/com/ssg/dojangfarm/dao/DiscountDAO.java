package com.ssg.dojangfarm.dao;

import com.ssg.dojangfarm.domain.Normal;

public interface DiscountDAO {
	void newDiscount(Normal normal);// throws dataAcception; //?��분과 공동구매?�� ?��?��?��?��
	void deleteDiscount(int saleNo);// throws dataAcception;

}
