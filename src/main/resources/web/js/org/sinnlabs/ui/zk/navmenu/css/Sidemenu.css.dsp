<%--
	Here you could do any styling job you want , all CSS stuff.
--%>
<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>

.z-sidemenu {
  overflow: auto;
  font-family: verdana;
  font-size: 12px;
  font-weight: 200;
  background-color: #2e353d;
  position: relative;
  color: #e1ffff;
}
.z-sidemenu .z-sidemenu-brand {
  background-color: #23282e;
  line-height: 50px;
  display: block;
  text-align: center;
  font-size: 14px;
}
.z-sidemenu .z-sidemenu-toggle-btn {
  display: none;
}
.z-sidemenu ul,
.z-sidemenu li {
  list-style: none;
  padding: 0px;
  margin: 0px;
  line-height: 35px;
  cursor: pointer;
  /*    
    .collapsed{
       .arrow:before{
                 font-family: FontAwesome;
                 content: "\f053";
                 display: inline-block;
                 padding-left:10px;
                 padding-right: 10px;
                 vertical-align: middle;
                 float:right;
            }
     }
*/
}
.z-sidemenu ul :not(collapsed) .arrow:before,
.z-sidemenu li :not(collapsed) .arrow:before {
  font-family: FontAwesome;
  content: "\f078";
  display: inline-block;
  padding-left: 10px;
  padding-right: 10px;
  vertical-align: middle;
  float: right;
}
.z-sidemenu ul .active,
.z-sidemenu li .active {
  border-left: 3px solid #d19b3d;
  background-color: #4f5b69;
}
.z-sidemenu ul .z-sidemenu-submenu li.active,
.z-sidemenu li .z-sidemenu-submenu li.active {
  color: #d19b3d;
}
.z-sidemenu ul .z-sidemenu-submenu li.active a,
.z-sidemenu li .z-sidemenu-submenu li.active a {
  color: #d19b3d;
}
.z-sidemenu ul .z-sidemenu-submenu li,
.z-sidemenu li .z-sidemenu-submenu li {
  background-color: #181c20;
  border: none;
  line-height: 28px;
  border-bottom: 1px solid #23282e;
  margin-left: 0px;
}
.z-sidemenu ul .z-sidemenu-submenu li:hover,
.z-sidemenu li .z-sidemenu-submenu li:hover {
  background-color: #020203;
}
.z-sidemenu ul .z-sidemenu-submenu li:before,
.z-sidemenu li .z-sidemenu-submenu li:before {
  font-family: FontAwesome;
  content: "\f105";
  display: inline-block;
  padding-left: 10px;
  padding-right: 10px;
  vertical-align: middle;
}
.z-sidemenu li {
  padding-left: 0px;
  border-left: 3px solid #2e353d;
  border-bottom: 1px solid #23282e;
}
.z-sidemenu li a {
  text-decoration: none;
  color: #e1ffff;
}
.z-sidemenu li a i {
  padding-left: 10px;
  width: 20px;
  padding-right: 20px;
}
.z-sidemenu li:hover {
  border-left: 3px solid #d19b3d;
  background-color: #4f5b69;
  -webkit-transition: all 1s ease;
  -moz-transition: all 1s ease;
  -o-transition: all 1s ease;
  -ms-transition: all 1s ease;
  transition: all 1s ease;
}
@media (max-width: 767px) {
  .z-sidemenu {
    position: relative;
    width: 100%;
    margin-bottom: 10px;
  }
  .z-sidemenu .z-sidemenu-toggle-btn {
    display: block;
    cursor: pointer;
    position: absolute;
    right: 10px;
    top: 10px;
    z-index: 10 !important;
    padding: 3px;
    background-color: #ffffff;
    color: #000;
    width: 40px;
    text-align: center;
  }
  .z-sidemenu-brand {
    text-align: left !important;
    font-size: 22px;
    padding-left: 20px;
    line-height: 50px !important;
  }
}
@media (min-width: 767px) {
  .z-sidemenu .z-sidemenu-menu-list .z-sidemenu-menu-content {
    display: block;
  }
}
