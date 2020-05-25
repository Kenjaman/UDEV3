package com.animalFood.models;

import java.util.Date;

import com.animalFood.utils.IDate;

public class Movement {
	private Date date;
	private int qty;
	private IStockItem stockItem;

	public Movement(IStockItem stockItem, int qty, IDate myDate) {
		if(stockItem==null) {
			throw new NullPointerException("Food cannot be null");
		}
		this.date = myDate.getNow();
		this.stockItem = stockItem;
		this.qty = qty;
	}

	public boolean isReplenish() {
		return this.qty >= 0;
	}

	public boolean isRemove() {
		return this.qty < 0;
	}

	public Date getDate() {
		return this.date;
	}

	public IStockItem getFood() {
		return this.stockItem;
	}

	public void apply() throws IllegalStateException {
		if(isReplenish()) {
			stockItem.replenish(qty);
		}
		else if(isRemove()) {
			stockItem.remove(-qty);
		}
	}

	public void cancel() throws IllegalStateException {
		if(isRemove()) {
			stockItem.replenish(-qty);
		}
		else if(qty != 0) {
			stockItem.remove(qty);
		} 
	}

}
