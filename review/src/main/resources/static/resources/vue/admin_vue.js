"use strict"
var adminVue2 = {
	join:() => {
	return `<table id="register_main">
	<tr>
	<td rowspan="4"><img alt="" src="https://www.musiciansdfw.org/wp-content/uploads/2018/11/default-profile.jpg"><br>
	<input id="profile_button" type="button" value="profile update"></td>
	<td rowspan="4" colspan="3">
	<label>name</label><br><input id="name" type="text"><br>
	<label>position</label><br><input id="position" type="text"><br>
	<label>email</label><br><input id="email" type="text"><br>
	<label>phoneNumber</label><br><input id="phoneNumber" type="text"><br>
	</tr>
	<tr></tr><tr></tr><tr></tr>
	<tr style="height: 20%">
	<td id="join_box" colspan="4">
	</td>
	</tr>
	</table>`
	},
	login : ()=> {
		return `<table id="register_main">
	<tr>
	<td rowspan="4" colspan="3">
	<label>EmployNumber</label><br><input id="employNumber" type="text"><br>
	<label>PASSWORD</label><br><input id="password" type="text"><br>
	</tr>
	<tr></tr><tr></tr><tr></tr>
	<tr style="height: 20%">
	<td id="login_box" colspan="4">
	</td>
	</tr>
	</table>`
	}
};