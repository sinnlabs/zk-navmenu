/**
* Here's the mold file , a mold means a HTML struct that the widget really presented.
* yep, we build html in Javascript , that make it more clear and powerful.
*/
function (out) {

	//Here you call the "this" means the widget instance. (@see Sidemenu.js)

	var zcls = this.getZclass(),
		uuid = this.uuid;
		label = this.getLabel();
		icon = this.getIcon();
		active = this.isActive();
		href = this.getHref();
		target = this.getTarget();

	//The this.domAttrs_() means it will prepare some dom attributes,
	//like the pseudo code below
	/*
		class="${zcls} ${this.getSclass()}" id="${uuid}"
	*/
	// if has child elements
	var cls = '';
	var attrs = '';
	if (this.firstChild) {
		cls = 'collapsed';
		attrs = 'data-toggle="collapse" data-target="#' + uuid + '-subitems"';
	}
	if (active) {
		cls += ' active';
	}
	var linkAttr = '';
	if (href) {
		linkAttr += ' href="' + href + '"';
		if (target) {
			linkAttr += ' target="' + target + '"';
		}
	}
	out.push('<li ', this.domAttrs_({domClass_:1}), 'class="' + cls + '"', attrs, ' >');
	out.push('<a id="', uuid, '-link" ', linkAttr, '>');
	if (icon) {
		out.push('<i id="' + uuid + '-icon" class="', icon, '" ></i>');
	}
	out.push('<span id="' + uuid +'-cave" >');
	out.push(zUtl.encodeXML(label));
	out.push('</span>');
	if (this.firstChild) {
		out.push('<span class="arrow"></span>');
	}
	out.push('</a>');
	out.push('</li>');
	if (this.firstChild) {
		out.push('<ul id="', uuid, '-subitems" class="', this.$s('submenu'),  ' collapse" >');
		for (var w = this.firstChild; w; w = w.nextSibling)
			w.redraw(out);
		out.push('</ul>');
	}
}