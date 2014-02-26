package com.hnrisen.auditworks.jotm.dao;
import com.hnrisen.auditworks.jotm.domain.TabA;

/**
 * 
 */

/**
 * @author ocean
 *
 */
public interface TabADAO {

        /**
         * 保存一个TabA对象
         *
         * @param tabA TabA对象
         * @return 返回保存后的对象
         */
        TabA saveTabA(TabA tabA);

        /**
         * 更新一个TabA
         *
         * @param tabA TabA对象
         * @return 返回更新后的对象
         */
        TabA updateTabA(TabA tabA);

        /**
         * 删除指定标识的一个TabA
         *
         * @param id TabA标识
         */
        void deleteTabAById(Long id);

        /**
         * 获取指定标识的TabA
         *
         * @param id TabA标识
         * @return 所查询到的TabA
         */
        TabA findTabAById(Long id);
}
