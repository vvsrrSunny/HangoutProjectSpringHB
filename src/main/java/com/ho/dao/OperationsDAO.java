package com.ho.dao;

import com.ho.to.HangoutEntry;

public interface OperationsDAO {
	public HangoutEntry getHangout(String id);
	public void saveHangout(HangoutEntry entry);
}
