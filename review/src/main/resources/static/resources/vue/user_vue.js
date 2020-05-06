"use strict"
var userVue = {
		join : () =>{
			return `<table id="kcdc">
                <tr>
            <td id="content" colspan="4">
                <table id="admin" style="width: 80%; height:80%; margin: 0 auto">
			    <tr style="width: 80%;height: 50px;">
			      <td rowspan="4">
			        <img src="https://u5b8t9w6.stackpathcdn.com/wp-content/uploads/2014/12/profile-default-300x242.jpg">
			      </td>
			      <td style="height: 10%">
			        <label>ID</label>
			      </td>
			      <td>
			        <input id="userid" type="text" />
			      </td>
			    </tr>
			    <tr style="height: 10%">
			      <td >
			        <label>PASSWORD</label>
			      </td>
			      <td>
			        <input id="password" type="text" />
			      </td>
			    </tr>
			    <tr style="height: 10%">
			      <td >
			        <label>이름</label>
			      </td>
			      <td>
			        <input id="name" type="text" />
			      </td>
			    </tr>
			    <tr style="height: 10%">
			      <td >
			        <label>주민번호</label>
			      </td>
			      <td>
			        <input id="ssn" type="text" />
			      </td>
			    </tr>
			    <tr style="height: 10%">
			      <td >
			        <label>주소</label>
			      </td>
			      <td>
			        <input id="address" type="text" />
			      </td>
			    </tr>
			    <tr style="height: 10%">
			      <td >
			        <label>프로필사진</label>
			      </td>
			      <td>
			        <input id="profile" type="text" />
			      </td>
			    </tr>  
			    <tr style="height: 10%">
			      <td >
			        <label>E-mail</label>
			      </td>
			      <td>
			        <input id="email" type="text" />
			      </td>
			    </tr>
			    <tr style="height: 10%">
			      <td>
			        <label>전화번호</label>
			      </td>
			      <td>
			        <input id="phoneNumber" type="text" />
			      </td>
			      <td id="button_box"></td>
			    </tr>
			  </table>
            </td>
        </tr>
    </table>
	     	`
		},
		login : ()=>{
			return `
				<article>
				   <form id="login_box">
				   	<label>ID </label> <br>
				   	<input id="userid" type="text"> <br>
				   	<label>PASSWORD</label><br>
				   	<input id="passwd" type="text"><br>
				   
				   </form>
				  </article>
			`
		},
		detail : () => {
			return`
			<div id="content_container">
			<table>
				<tr>
					<td id="title" colspan="3">사용자 정보</td>
				</tr>
				<tr>
					<td id="profile_pic" rowspan="7">
						<svg id="profile_pic_default" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
							<path d="M3 5v14c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2H5c-1.11 0-2 .9-2 2zm12 4c0 1.66-1.34 3-3 3s-3-1.34-3-3 1.34-3 3-3 3 1.34 3 3zm-9 8c0-2 4-3.1 6-3.1s6 1.1 6 3.1v1H6v-1z" />
							<path d="M0 0h24v24H0z" fill="none" />
						</svg>
					</td>
					<td class="userlabel">아이디</td>
					<td class="input">
						<p id="userid"></p>
					</td>
				</tr>
				<tr>
					<td class="userlabel">이름</td>
					<td class="input">
						<p id="name"></p>
					</td>
				</tr>
				<tr>
					<td class="userlabel">주민번호</td>
					<td class="input">
						<p id="ssn"></p>
					</td>
				</tr>
				<tr>
					<td class="userlabel">이메일</td>
					<td class="input">
						<p id="email"></p>
					</td>
				</tr>
				<tr>
					<td class="userlabel">전화번호</td>
					<td class="input">
						<p id="phoneNumber"></p>
					</td>
				</tr>
				<tr>
					<td class="userlabel">가입일</td>
					<td class="input">
						<p id="registerDate"></p>
					</td>
				</tr>
			</table>
		</div>
	`
		}
}