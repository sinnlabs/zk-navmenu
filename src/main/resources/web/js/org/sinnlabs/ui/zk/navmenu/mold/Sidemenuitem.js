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
	var cls = '';
	if (active) {
		cls = 'active';
	}
	var linkAttrs = '';
	if (href) {
		linkAttrs = ' href ="' + href + '"';
		if (target) {
			linkAttrs += ' target="' + target + '"';
		}
	}
	out.push('<li ', this.domAttrs_({domClass_:1}), ' class="', cls, '" >');
	out.push('<a id="', uuid, '-link" ', linkAttrs, ' >');
	if (icon) {
		out.push('<span id="' + uuid + '-icon" class="', icon, '" ></span>');
	}
	out.push('<span id="' + uuid +'-cave" >');
	out.push(zUtl.encodeXML(label));
	out.push('</span>');
	out.push('</a>');
	out.push('</li>');
}