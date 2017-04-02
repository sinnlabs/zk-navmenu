/**
* Here's the mold file , a mold means a HTML struct that the widget really presented.
* yep, we build html in Javascript , that make it more clear and powerful.
*/
function (out) {

	//Here you call the "this" means the widget instance. (@see Sidemenu.js)

	var zcls = this.getZclass(),
		uuid = this.uuid;
		logo = this.getLogo();

	//The this.domAttrs_() means it will prepare some dom attributes,
	//like the pseudo code below
	/*
		class="${zcls} ${this.getSclass()}" id="${uuid}"
	*/
	out.push('<div ', this.domAttrs_(), '>');
	if (logo) {
		out.push('<div id="'+ uuid + '-brand" class="' + this.$s('brand') + '">');
		out.push(logo);
		out.push('</div>');
	}
	out.push('<i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#'+ 
			uuid + '-menu-content"></i>');
	
	out.push('<div class="'+ this.$s('menu-list') + '">');
	
	// Menu itemslist
	out.push('<ul id="' + uuid + '-menu-content" class="'+ this.$s('menu-content') + ' collapse out">');
	for (var w = this.firstChild; w; w = w.nextSibling)
		w.redraw(out);
	out.push('</ul>');
	
	out.push('</div>');
	out.push('</div>');

}