/**
 *
 * Base naming rule:
 * The stuff start with "_" means private , end with "_" means protect ,
 * others mean public.
 *
 * All the member field should be private.
 *
 * Life cycle: (It's very important to know when we bind the event)
 * A widget will do this by order :
 * 1. $init
 * 2. set attributes (setters)
 * 3. rendering mold (@see mold/sidemenu.js )
 * 4. call bind_ to bind the event to dom .
 *
 * this.deskop will be assigned after super bind_ is called,
 * so we use it to determine whether we need to update view
 * manually in setter or not.
 * If this.desktop exist , means it's after mold rendering.
 *
 */
org.sinnlabs.ui.zk.navmenu.Sidemenuitem = zk.$extends(zul.Widget, {
	_label:'', //default value for label attribute
	_icon:'', // default icon
	_zclass: 'z-sidemenu',
	_active: false,
	_href: '',
	_target: '',
	
	/**
	 * Don't use array/object as a member field, it's a restriction for ZK object,
	 * it will work like a static , share with all the same Widget class instance.
	 *
	 * if you really need this , assign it in bind_ method to prevent any trouble.
	 *
	 * TODO:check array or object , must be one of them ...I forgot. -_- by Tony
	 */
	
	$define: {
		/**
		 * The member in $define means that it has its own setter/getter.
		 * (It's a coding sugar.)
		 *
		 * If you don't get this ,
		 * you could see the comment below for another way to do this.
		 *
		 * It's more clear.
		 *
		 */
		label: function(v) { //this function will be called after setText() .
		
			if(this.desktop) {
				var n = this.$n('cave')
				if (n) {
					n.innerHTML = zUtl.encodeXML(v);
				}
			}
		},
		icon: function(v) {
			if (this.desktop) {
				var n = this.$n('icon');
			}
		},
		active: function(v) {
			if (this.desktop) {
				var n = this.$n();
				if (n) {
					if (v) {
						jq(n).addClass('active');
					} else {
						jq(n).removeClass('active');
					}
				}
			}
		},
		href: function(v) {
			if (this.desktop) {
				var n = this.$n('link');
				if (n) {
					n.href = v || '';
				}
			}
		},
		target: this.resetTarget
	},
	resetTarget: function(v) {
			if (this.desktop) {
				var n = this.$n('link');
				if (n) {
					n.target = v || '';
				}
			}
	},
	/**
	 * If you don't like the way in $define ,
	 * you could do the setter/getter by yourself here.
	 *
	 * Like the example below, they are the same as we mentioned in $define section.
	 */
	/*
	getText:function(){ return this._text; },
	setText:function(val){
		this._text = val;
		if(this.desktop){
		//update the UI here.
		}
	},
	*/
	_checkTarget : function(target) {
		zk.log('Check target: ' + target);
		if (target) {
			if (target.startsWith('$')) {
				// try detect zk widget
				var n = jq(target);
				zk.log('jq returned: ' + n[0]);
				zk.log('jq: ');
				zk.log(n);
				if (n[0]) {
					var id = n[0].id;
					if (id)
						return id;
				}
			}
		}
		return target;
	},
	
	bind_: function () {
		/**
		 * For widget lifecycle , the super bind_ should be called
		 * as FIRST STATEMENT in the function.
		 * DONT'T forget to call supers in bind_ , or you will get error.
		 */
		this.$supers(org.sinnlabs.ui.zk.navmenu.Sidemenuitem,'bind_', arguments);
	
		//A example for domListen_ , REMEMBER to do domUnlisten in unbind_.
		this.domListen_(this.$n(), "onClick", "doClick_");
	},
	/*
		A example for domListen_ listener.
	*/
	/*
	_doItemsClick: function (evt) {
		alert("item click event fired");
	},
	*/
	unbind_: function () {
	
		// A example for domUnlisten_ , should be paired with bind_
		this.domUnlisten_(this.$n(), "onClick", "doClick_");
		
		/*
		* For widget lifecycle , the super unbind_ should be called
		* as LAST STATEMENT in the function.
		*/
		this.$supers(org.sinnlabs.ui.zk.navmenu.Sidemenuitem,'unbind_', arguments);
	},
	/*
		widget event, more detail 
		please refer to http://books.zkoss.org/wiki/ZK%20Client-side%20Reference/Notifications
	 */
	doClick_: function (evt) {
		this.$super('doClick_', evt, true);//the super doClick_ should be called
		this.fire('onSelect', {foo: 'myData'});
	}
});