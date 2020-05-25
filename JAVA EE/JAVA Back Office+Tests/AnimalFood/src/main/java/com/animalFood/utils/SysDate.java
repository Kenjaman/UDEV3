package com.animalfood.utils;

import java.util.Date;

public class SysDate implements IDate {

	@Override
	public Date getNow() {
		return new Date();
	}

}
