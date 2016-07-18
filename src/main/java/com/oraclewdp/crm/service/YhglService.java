package com.oraclewdp.crm.service;

import java.util.List;

import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.util.Pages;

public interface YhglService {

	public Pages<UserRole> listUserRole();
}
