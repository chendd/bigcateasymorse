#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 *
 * 
 * @author marshal
 * 
 */
public interface Presenter {
	/**
	 * 
	 * 
	 * @param container
	 */
	public abstract void go(final HasWidgets container);
}
