/**
 * 
 */
package org.sinnlabs.ui.zk.navmenu;

import org.zkoss.lang.Objects;
import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.impl.XulElement;

/**
 * @author peter.liverovsky
 *
 */
public class Sidemenugroup extends XulElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1060553513391236888L;

	static {
		addClientEvent(Sidemenugroup.class, "onSelect", 0);
	}
	
	private String _label;
	private String _icon;
	private boolean _active;
	private String _href;
	private String _target;
	private Sidemenuitem _activeItem;
	private Sidemenu _menu;

	/**
	 * Gets group label
	 * @return label text
	 */
	public String getLabel() {
		return _label;
	}
	
	/**
	 * Gets group icon
	 * @return icon class
	 */
	public String getIcon() {
		return _icon;
	}
	
	/**
	 * Gets group status
	 * @return true if group is active, otherwise false
	 */
	public boolean isActive() {
		return _active;
	}
	
	/**
	 * Gets href
	 * @return href link
	 */
	public String getHref() {
		return _href;
	}
	
	/**
	 * Gets target frame
	 * @return target
	 */
	public String getTarget() {
		return _target;
	}
	
	/**
	 * Gets active item
	 * @return active menu item otherwise null
	 */
	public Sidemenuitem getActiveItem() {
		return _activeItem;
	}
	
	/*package*/ void setActiveItem(Sidemenuitem item) {
		if (_activeItem != null)
			_activeItem.setActive(false);
		_activeItem = item;
		setActive(true);
	}
	
	/**
	 * Sets href
	 * @param href href content
	 */
	public void setHref(String href) {
		if (!Objects.equals(href, _href)) {
			_href = href;
			smartUpdate("href", _href);
		}
	}
	
	/**
	 * Sets target frame
	 * @param target Target frame name
	 */
	public void setTarget(String target) {
		if (!Objects.equals(target, _target)) {
			_target = target;
			smartUpdate("target", _target);
		}
	}

	/**
	 * Sets group label
	 * @param text label content
	 */
	public void setLabel(String text) {
		if (!Objects.equals(_label, text)) {
			_label = text;
			smartUpdate("label", _label);
		}
	}
	
	/**
	 * Sets group icon
	 * @param text glyphcon or fontawesome style class
	 */
	public void setIcon(String text) {
		if (!Objects.equals(_icon, text)) {
			_icon = text;
			smartUpdate("icon", _icon);
		}
	}
	
	/**
	 * Sets group status
	 * @param active true or false
	 */
	public void setActive(boolean active) {
		if (_active != active) {
			if (_menu != null && active) {
				_menu.setActiveGroup(this);
			}
			if (getActiveItem() != null && !active) {
				getActiveItem().setActive(false);
			}
			_active = active;
			smartUpdate("active", _active);
		}
	}

	@Override
	public void beforeChildAdded(Component child, Component insertBefore) {
		if (!(child instanceof Sidemenuitem)) {
			throw new UiException("Unsupported child for sidemenugroup: " + child);
		}
		super.beforeChildAdded(child, insertBefore);
	}
	
	@Override
	public void beforeParentChanged(Component parent) {
		if (_active) {
			if (_menu != null) {
				_menu.setActiveGroup(null);
				setActive(false);
			}
		}
		if (parent instanceof Sidemenu) {
			_menu = (Sidemenu) parent;
		} else {
			_menu = null;
		}
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

	/**
	 * The default zclass is "z-navgroup"
	 */
	public String getZclass() {
		return (this._zclass != null ? this._zclass : "z-sidemenu");
	}
}

