package com.ssg.dojangfarm.dao;

import com.ssg.dojangfarm.domain.Normal;

public interface DiscountDAO {
	void newDiscount(Normal normal);// throws dataAcception; //?λΆκ³Ό κ³΅λκ΅¬λ§€? ?΄?Ή??
	void deleteDiscount(int saleNo);// throws dataAcception;

}
