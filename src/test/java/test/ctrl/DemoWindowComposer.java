package test.ctrl;

import org.sinnlabs.ui.zk.navmenu.Sidemenu;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;

public class DemoWindowComposer extends SelectorComposer<Component> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5725088276541257934L;
	@Wire
	private Sidemenu myComp;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		myComp.setLogo("Hello ZK Component!! Please click me.");
	}
	
	public void onFoo$myComp (ForwardEvent event) {
		Event mouseEvent = (Event) event.getOrigin();
		alert("You listen onFoo: " + mouseEvent.getTarget());
	}
}