package com.oraclewdp.crm.service;

import java.util.Date;

import com.oraclewdp.crm.entity.CustomerCare;
import com.oraclewdp.crm.entity.CustomerLink;
import com.oraclewdp.crm.entity.DicAll;
import com.oraclewdp.crm.entity.User;
import com.oraclewdp.crm.util.Pages;

public interface KhsrcxService {

	/**
	 * 查询生日在当前一周的客户联系人
	 * @author gui
	 * @time 2016年7月20日 下午6:35:28
	 * @tags @param date
	 * @tags @return
	 */
	public Pages<CustomerLink> getLinkByWeek();

	/**
	 * 查询生日在当前一个月的客户联系人
	 * @author gui
	 * @time 2016年7月20日 下午6:36:43
	 * @tags @param date
	 * @tags @return
	 */
    public Pages<CustomerLink> getLinkByMonth();
    
    /**
     * 根据ID得到到customerId
     * @author gui
     * @time 2016年7月21日 上午1:51:41
     * @tags @param linkId
     * @tags @return
     */
    public CustomerLink getLink(int linkId);
    
    /**
     * 得到随机的一个祝福语
     * @author gui
     * @time 2016年7月21日 上午1:55:22
     * @tags @return
     */
    public DicAll getEmailContent();
    
    public User getUser(int id);
    
    /**
     * 保存客户关怀表
     * @author gui
     * @time 2016年7月21日 上午3:13:18
     * @tags @param customerCare
     * @tags @return
     */
    public int saveCustomerCare(CustomerCare customerCare);
}
