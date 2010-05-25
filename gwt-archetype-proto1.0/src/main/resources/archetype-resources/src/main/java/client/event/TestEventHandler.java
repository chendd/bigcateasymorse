#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface TestEventHandler extends EventHandler {
	void startLogin(TestEvent event);
}
