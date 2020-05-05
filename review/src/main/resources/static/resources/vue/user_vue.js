"use strict"
const userVue = {
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
		}
}