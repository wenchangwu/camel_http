/*
 * 
 */
package jpa.domain.realname;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author ray
 * @since 1.4.0
 */
@Entity
@DiscriminatorValue(value = "10")
public class RealNameAuthRejectStatus extends RealNameAuthStatus {

	private static final long serialVersionUID = 5671320951898861410L;

	protected RealNameAuthRejectStatus() {
		super();
	}

}
