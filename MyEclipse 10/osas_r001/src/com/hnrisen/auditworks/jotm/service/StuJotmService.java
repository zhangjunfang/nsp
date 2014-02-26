package com.hnrisen.auditworks.jotm.service;
import com.hnrisen.auditworks.jotm.domain.TabA;
import com.hnrisen.auditworks.jotm.domain.TabB;

/**
 * 
 */

/**
 * @author ocean
 *
 */
public interface StuJotmService {
        /**
         * 同时保存TabA、TabB
         *
         * @param a TabA对象
         * @param b TabB对象
         */
        void saveAB(TabA a, TabB b); 

        /**
         * 同时更新TabA、TabB
         *
         * @param a TabA对象
         * @param b TabB对象
         */
        void updateAB(TabA a, TabB b);

        /**
         * 删除指定id的TabA、TabB记录
         *
         * @param id 指定id
         */
        void deleteABif(Long id);
}