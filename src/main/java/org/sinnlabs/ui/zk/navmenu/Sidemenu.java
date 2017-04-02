package org.sinnlabs.ui.zk.navmenu;

import org.zkoss.lang.Objects;
import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zul.impl.XulElement;

public class Sidemenu extends XulElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4280386319945420178L;

	static {
		//addClientEvent(Navmenu.class, "onSelect", 0);
	}
	
	/* Here's a simple example for how to implements a member field */

	private String _logo;
	
	private Sidemenugroup _activeGroup;

	/**
	 * Gets corrent brand logo text
	 * @return current logo text
	 */
	public String getLogo() {
		return _logo;
	}

	/**
	 * Sets brand logo text
	 * @param text logo text
	 */
	public void setLogo(String text) {
		if (!Objects.equals(_logo, text)) {
			_logo = text;
			smartUpdate("logo", _logo);
		}
	}
	
	/**
	 * Get active group item
	 * @return Active menu item otherwise null
	 */
	public Sidemenugroup getActiveGroup() {
		return _activeGroup;
	}
	
	/**
	 * Get active menu item or null
	 * @return Active menu item otherwise null
	 */
	public Sidemenuitem getActiveItem() {
		if (_activeGroup != null)
			return _activeGroup.getActiveItem();
		return null;
	}
	
	/*package*/ void setActiveGroup(Sidemenugroup group) {
		if (_activeGroup != null) {
			_activeGroup.setActive(false);
		}
		_activeGroup = group;
	}

	@Override
	public void beforeChildAdded(Component newChild, Component insertBefore) {
		if (!(newChild instanceof Sidemenugroup)) {
			throw new UiException("Unsupported child for sidemenu: " + newChild);
		}
		super.beforeChildAdded(newChild, insertBefore);
	}

	//super//
	protected void renderProperties(org.zkoss.zk.ui.sys.ContentRenderer renderer)
	throws java.io.IOException {
		super.renderProperties(renderer);

		render(renderer, "logo", _logo);
	}
	
	public void service(AuRequest request, boolean everError) {
		super.service(request, everError);
	}

	/**
	 * The default zclass is "z-sidemenu"
	 */
	public String getZclass() {
		return (this._zclass != null ? this._zclass : "z-sidemenu");
	}
}