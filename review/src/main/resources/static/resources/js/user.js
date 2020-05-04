"use strict"
var user = user || {}
user = (()=>{
	const WHEN_ERROR = `호출하는 JS 파일을 찾지 못했습니다.`
	let admin_vue
	let init = () => {
		admin_vue = `/resources/vue/admin_vue.js`
		onCreate()
	}
	let onCreate = () =>{
		$.when(
			$.getScript(admin_vue)
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
		     		alert('등록버튼 클릭')
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
		    		 location.href = "/admin"
		    		 /*$.ajax({
		    			 url : ``,
		    			 type : `post`,
		    			 data : JSON.stringify({
		    				 
		    			 }),
		    			 dataType : `json`,
		    			 contentType : `application/json`,
		    			 success : d => {
		    				// location.href = "/admin"
		    			 },
		    			 error : (r, x, e) => {
		    				 alert(r)
		    			 }
		    		 }) */
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