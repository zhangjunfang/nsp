package com.hnrisen.auditworks.jotm.domain;
import java.io.Serializable;

/**
 * 
 */

/**
 * @author ocean
 *
 */
public class TabA  implements Serializable {
	
	
	private static final long serialVersionUID = -8510777445808478078L;
		private Long id;
        private String name;
        
        private String address;
		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the address
		 */
		public String getAddress() {
			return address;
		}
		/**
		 * @param address the address to set
		 */
		public void setAddress(String address) {
			this.address = address;
		} 
        
        
}
