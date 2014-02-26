package com.hnrisen.auditworks.jotm.dao;
import com.hnrisen.auditworks.jotm.domain.TabB;

/**
 * 
 */

/**
 * @author ocean
 *
 */
public interface TabBDAO {

        /**
         * 保存一个TabB对象
         *
         * @param tabA TabB对象
         * @return 返回保存后的对象
         */
        TabB saveTabB(TabB tabb);

        /**
         * 更新一个TabB
         *
         * @param tabA TabB对象
         * @return 返回更新后的对象
         */
        TabB updateTabB(TabB tabb);

        /**
         * 删除指定标识的一个TabB
         *
         * @param id TabB标识
         */
        void deleteTabBById(Long id);

        /**
         * 获取指定标识的TabB
         *
         * @param id TabB标识
         * @return 所查询到的TabB
         */
        TabB findTabBById(Long id);
}
