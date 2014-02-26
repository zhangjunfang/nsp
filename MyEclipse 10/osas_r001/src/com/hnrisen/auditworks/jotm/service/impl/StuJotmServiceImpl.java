package com.hnrisen.auditworks.jotm.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnrisen.auditworks.jotm.dao.TabADAO;
import com.hnrisen.auditworks.jotm.dao.TabBDAO;
import com.hnrisen.auditworks.jotm.domain.TabA;
import com.hnrisen.auditworks.jotm.domain.TabB;
import com.hnrisen.auditworks.jotm.service.StuJotmService;

/**
 * 
 */

/**
 * @author ocean
 *
 */
@Service("stuJotmService")
public class StuJotmServiceImpl implements StuJotmService {
	    @Autowired
        private TabADAO tabADAO;
	    @Autowired
        private TabBDAO tabBDAO;

        /**
         * 同时保存TabA、TabB
         *
         * @param a TabA对象
         * @param b TabB对象
         */
//        @Transactional(readOnly=false)
        public void saveAB(TabA a, TabB b) {
                
                tabBDAO.saveTabB(b);
                tabADAO.saveTabA(a);
        }

        /**
         * 同时更新TabA、TabB
         *
         * @param a TabA对象
         * @param b TabB对象
         */
//        @Transactional(readOnly=false)
        public void updateAB(TabA a, TabB b) {
                tabADAO.updateTabA(a);
                tabBDAO.updateTabB(b);
        }

        /**
         * 删除指定id的TabA、TabB记录
         *
         * @param id 指定id
         */
//        @Transactional(readOnly=false)
        public void deleteABif(Long id) {
                tabADAO.deleteTabAById(id);
                tabBDAO.deleteTabBById(id);
        }

        public void setTabADAO(TabADAO tabADAO) {
                this.tabADAO = tabADAO;
        }

        public void setTabBDAO(TabBDAO tabBDAO) {
                this.tabBDAO = tabBDAO;
        }
}
