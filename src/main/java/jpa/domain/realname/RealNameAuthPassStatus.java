/*
 * 
 */
package jpa.domain.realname;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 已申请状态
 * @author ray
 * @since 1.4.0
 */
@Entity
@DiscriminatorValue(value = "20")
public class RealNameAuthPassStatus extends RealNameAuthStatus {

	private static final long serialVersionUID = 1L;
	
	protected RealNameAuthPassStatus() {
		super();
	}

}
