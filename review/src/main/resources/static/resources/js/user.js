"use strict"
var user = user || {}
user = (()=>{
	const WHEN_ERROR = `호출하는 JS 파일을 찾지 못했습니다.`
	let admin_vue
	let user_vue
	let init = () => {
		admin_vue = `/resources/vue/admin_vue.js`
		user_vue = `/resources/vue/user_vue.js`
		onCreate()
	}
	let onCreate = () =>{
		$.when(
			$.getScript(admin_vue),
			$.getScript(user_vue)
		).done(()=>{
			setContentView()
			$('#register_a').click(e=>{
				e.preventDefault()
		     	$('#content').empty()
		     	$('#content').html(adminVue.join())
		     	$(`<input type="button"/>`)
		     	.attr({value:'등록'})
		     	.css({width: '200px', height: '100px','font-size': '30px'})
		     	.appendTo('#button_box')
		     	.click(e => {
		     		e.preventDefault()
		     		$.ajax({
		     			url:'/admins/register',
		     			type:'post',
		     			data:JSON.stringify({
		     				name:$('#name').val(),
		     				position:$('#position').val(),
		     				email:$('#email').val(),
		     				phoneNumber:$('#phoneNumber').val()
		     			}),
		     			dataType:'json',
		     			contentType:'application/json',
		     			success: d=> {
		     				if(d === 'SUCCESS'){
		     					loctaion.href='/home'
		     				}
		     			},
		     			error: (req, x, error) => {
		     				alert(req.status)
		     			}
		     			
		     		})
		     	})
		     	$(`<input type="button"/>`)
		     	.attr({value:'취소'})
		     	.css({width: '200px', height: '100px','font-size': '30px'})
		     	.appendTo('#button_box')
		     	.click( e=>{
		     		e.preventDefault()
		     		location.href='/home'
		     	})
		     	
		     })
		     $('#access_a').click(e=>{
		    	 e.preventDefault()
		    	 $('#content').empty()
		    	 $('#content').html(adminVue.login())
		    	 $(`<input type="button" >`)
		    	 .attr({value:"로그인"})
		    	 .appendTo('#login_box')
		    	 .click(e=>{
		    		 e.preventDefault()
		    		 $.ajax({
		    			 url : `/admins/login`,
		    			 type : `post`,
		    			 data : JSON.stringify({
		    				 employNumber:$('#employNumber').val(),
		    				 password:$('#password').val()
		    			 }),
		    			 dataType : `json`,
		    			 contentType : `application/json`,
		    			 success : d => {
		    				 if(d === 'SUCCESS') {
		    					 location.href = "/admin"		    					 
		    				 } else {
		    					 alert('로그인 실패')
		    				 }
		    			 },
		    			 error : (r, x, e) => {
		    				 alert(req.status)
		    			 }
		    		 }) 
		    	 })
				 $(`<input type="button">`)
				 .attr({value:"취소"})
				 .appendTo('#login_box')
				 .click(e => {
					 e.preventDefault()
					 location.href='/home'
				 	}) 
				 	
		    	})
		    
		    $('#join_a').click( e=> {
		    	e.preventDefault()
		    	$('#content').empty()
		    	$('#content').html(userVue.join())
		    	$(`<input type="button"/>`)
		    	.attr({value:'회원가입'})
		    	.appendTo('#button_box')
		    	.click( e=> {
		    		e.preventDefault()
		    		location.href=''
		    	})
		    	$(`<input type="button"/>`)
		    	.attr({value:'취소'})
		    	.appendTo('#button_box')
		    	.click( e => {
		    		e.preventDefault()
		    		location.href='/home'
		    	})
		    })
		    $('#login_a').click( e=> {
		    	e.preventDefault()
		    })
		}).fail(()=>{
			alert(WHEN_ERROR)
		})
		
		
	}
	let setContentView = () =>{
		$('#kcdc').css({ width: '80%', height: '900px' }).addClass('border_black center')
	     $('#tr_1').css({ width: '80%', height: '50px' }).addClass('border_black center')
	     $('#menu').css({ width: '80%', height: '50px' }).addClass('border_black center')
	     $('#kcdc td').addClass('border_black', 'width_full')
	}
	return {init}
	
})()