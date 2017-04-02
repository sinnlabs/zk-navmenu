/**
 * 
 */
package org.sinnlabs.ui.zk.navmenu;

import org.zkoss.lang.Objects;
import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.impl.XulElement;

/**
 * @author peter.liverovsky
 *
 */
public class Sidemenuitem extends XulElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7565312540580771371L;
	
	static {
		addClientEvent(Sidemenuitem.class, "onSelect", 0);
	}

	private String _label;
	
	private String _icon;
	
	private boolean _active;
	
	private String _href;
	
	private String _target;
	
	private Sidemenugroup _group;
	
	/**
	 * Gets menu label
	 * @return label text
	 */
	public String getLabel() {
		return _label;
	}
	
	/**
	 * Gets menu icon
	 * @return icon class
	 */
	public String getIcon() {
		return _icon;
	}
	
	/**
	 * Gets menu status
	 * @return true if item is active otherwise false
	 */
	public boolean isActive() {
		return _active;
	}
	
	/**
	 * Gets href
	 * @return url
	 */
	public String getHref() {
		return _href;
	}
	
	/**
	 * Gets target frame
	 */
	public String getTarget() {
		return _target;
	}
	
	/**
	 * Sets href
	 * @param href new href
	 */
	public void setHref(String href) {
		if (!Objects.equals(href, _href)) {
			_href = href;
			smartUpdate("href", _href);
		}
	}
	
	/**
	 * Sets target frame
	 * @param target target frame name (like _blank)
	 */
	public void setTarget(String target) {
		if (!Objects.equals(target, _target)) {
			_target = target;
			smartUpdate("target", _target);
		}
	}
	
	/**
	 * Sets the active state
	 * @param active true - Active state, false - Deactivate
	 */
	public void setActive(boolean active) {
		if (active) {
			_group.setActiveItem(this);
		}
		if (active != _active) {
			_active = active;
			smartUpdate("active", _active);
		}
	}

	/**
	 * Sets the label
	 */
	public void setLabel(String text) {
		if (!Objects.equals(_label, text)) {
			_label = text;
			smartUpdate("label", _label);
		}
	}
	
	/**
	 * Sets the icon class
	 * @param text icon class (glyphicon or z-icon)
	 */
	public void setIcon(String text) {
		if (!Objects.equals(_icon, text)) {
			_icon = text;
			smartUpdate("icon", _icon);
		}
	}
	
	@Override
	public void beforeParentChanged(Component parent) {
		if (_active) {
			_group.setActiveItem(null);
			setActive(false);
		}
		if (parent instanceof Sidemenugroup) {
			_group = (Sidemenugroup) parent;
		} else {
			_group = null;
		}
	}

	@Override
	public void beforeChildAdded(Component child, Component insertBefore) {
		super.beforeChildAdded(child, insertBefore);
	}
	
	@Override
	protected boolean isChildable() {
		return false;
	}

	@Override
	protected void renderProperties(org.zkoss.zk.ui.sys.ContentRenderer renderer)
	throws java.io.IOException {
		super.renderProperties(renderer);

		render(renderer, "label", _label);
		render(renderer, "icon", _icon);
		render(renderer, "active", _active);
		render(renderer, "href", _href);
		render(renderer, "target", _target);
	}
	
	@Override
	public void service(AuRequest request, boolean everError) {
		final String cmd = request.getCommand();

		if (cmd.equals("onSelect")) {
			Events.postEvent(Event.getEvent(request));
		} else
			super.service(request, everError);
	}

	public String getZclass() {
		return (this._zclass != null ? this._zclass : "z-sidemenu");
	}
}
