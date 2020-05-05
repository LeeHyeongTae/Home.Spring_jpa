"use strict"
const adminVue = {
		join : () =>{
			return `<table id="kcdc">
                <tr>
            <td id="content" colspan="4">
                <table id="admin" style="width: 80%; height:80%; margin: 0 auto">
			    <tr style="width: 80%;height: 50px;">
			      <td rowspan="4">
			        <img src="https://u5b8t9w6.stackpathcdn.com/wp-content/uploads/2014/12/profile-default-300x242.jpg">
			      </td>
			      <td style="height: 20%">
			        <label>이름</label>
			      </td>
			      <td>
			        <input id="name" type="text" />
			      </td>
			    </tr>  
			    <tr style="height: 20%">
			      <td >
			        <label>직급</label>
			      </td>
			      <td>
			        <input id="position" type="text" />
			      </td>
			    </tr>
			    <tr style="height: 20%">
			      <td>
			        <label>이메일</label>
			      </td>
			      <td>
			        <input id="email" type="text" />
			      </td>
			    </tr>
			    <tr style="height: 20%">
			      <td>
			        <label>전화번호</label>
			      </td>
			      <td>
			        <input id="phoneNumber" type="text" />
			      </td>
			    </tr>
			    <tr style="height: 20%">
			      <td colspan="3" id="button_box">
			      </td>
			    </tr>
			  </table>
            </td>
        </tr>
    </table>
	     	`
		},
		login : () =>{
			return `
				<article>
				   <form id="login_box">
				   	<label>EmployNumber </label> <br>
				   	<input id="employNumber" type="text"> <br>
				   	<label>PASSWORD</label><br>
				   	<input id="password" type="text"><br>
				   
				   </form>
				  </article>
			`
		},
		detail : () =>{
			return `
					<div id="content" style="width: 1200px; height: 500px;margin: 0 auto">
            		<table id="userData">
            			<tr>
            			<td><img src=""></td>
            			</tr>
                        <tr>
                            <td>
                            	<label>number</label><br>
                                <a id="number">1</a>
                            </td>
                            <td>
                            	<label>ID</label><br>
                                <a id="userid"></a>
                            </td>
                             <td>
                             	<label>name</label><br>
                                <a id="name"></a>
                            </td>
                           <td>
                           		<label>ssn</label><br>
                                <a id="ssn"></a>
                            </td>
                            <td>
                             	<label>E-mail</label><br>
                                <a id="email"></a>
                            </td>
                            <td>
                            	<label>phoneNumber</label><br>
                                <a id="phoneNumber"></a>
                            </td>
                            <td>
                            	<label>registerDate</label><br>
                                <a id="registerDate"></a>
                            </td>
                        </tr>
                    </table>
            	</div>`
		},
		adminList : () => {
			return`
			<div id="content" style="width: 1200px; height: 500px;margin: 0 auto">
            		<table id="userData">
                        <tr>
                            <td>
                                <a id="number">No.</a>
                            </td>
                            <td>
                                <a id="employNumber">사원번호</a>
                            </td>
                             <td>
                                <a id="name">이름</a>
                            </td>
                           <td>
                                <a id="position">직급</a>
                            </td>
                            <td>
                                <a id="email">이메일</a>
                            </td>
                            <td>
                                <a id="phoneNumber">전화번호</a>
                            </td>
                            <td>
                                <a id="registerDate">등록일자</a>
                            </td>
                        </tr>
                    </table>
            	</div>
			`
		}

}