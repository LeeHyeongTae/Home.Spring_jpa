"use strict"
var user = user || {}
user = (() => {
	const WHEN_ERROR = `호출하는 JS 파일 찾지 못함`
	let admin_vue
	let init = () => {
		
		admin_vue = `/resources/vue/admin_vue.js`		
		onCreate()
	}
	let onCreate = () => {
		$.when(
			$.getScript(admin_vue)
		).done( ()=> {
			setContentView()
			$('#register_button')
			.click( e=> {
				e.preventDefault()
			$('#main_r').empty()
			$('#main_r').html(adminVue2.join())
			$(`<input type="button"/>`)
			.attr({value:'등록'})
			.css({width: '200px', height: '100px', 'font-size': '30px'})
			.appendTo('#join_box')
			.click( e=> {
				e.preventDefault()
				$.ajax({
					url:'/admins/register',
					type:'post',
					data: JSON.stringify({
						name:$('#name').val(),
						position:$('#position').val(),
						email:$('#email').val(),
						phoneNumber:$('#phoneNumber').val()
					}),
					dataType:'json',
					contentType:'application/json',
					success: d => {
						if(d === 'SUCCESS'){							
							
						}
					},
					error: (req, x, error) => {
						alert(req.status)
					}
				})
			})
			$(`<input type="button"/>`)
			.attr({value:'취소'})
			.css({width: '200px', height: '100px', 'font-size': '30px'})
			.appendTo('#join_box')
			.click( e=> {
				e.preventDefault()
				alert('취소버튼 클릭')
				})
			})
		
			$('#access_button')
			.click( e=> {
				e.preventDefault()
			$('#main_r').empty()
			$('#main_r').html(adminVue2.login())
			$(`<input type="button"/>`)
			.attr({value:'로그인'})
			.css({width: '200px', height: '100px', 'font-size':'30px'})
			.appendTo('#login_box')
			.click( e=> {
				e.preventDefault()
				$.ajax({
					url:'/admins/login',
					type:'post',
					data:JSON.stringify({
						employNumber:$('#employNumber').val(),
						password:$('#password').val()
					}),
					dataType:'json',
					contentType:'application/json',
					success: d=> {
						if(d === 'SUCCESS'){
							alert('로그인 성공')
							location.href="/admin"
						}
					},
					error: (req, x, error) => {
						alert(req.status)
					}
				})
			})
			$(`<input type="button/>"`)
			.attr({value:'취소'})
			.css({width: '200px', height: '100px', 'font-size':'30px'})
			.appendTo('#login_box')
			.click( e=> {
				e.preventDefault()
				alert('취소')
			})
			})
		}).fail(()=>{
			alert(WHEN_ERROR)
		})
		
		}
	let setContentView = () => {
		$('#first_page').css({width:'80%', height:'900px'}).addClass('border_black center')
		$('#first_page tr td').addClass('border_black')
		$('#top_menu').css({height:'80px'})
		$('#inner_menu').css({width:'100%'})
		$('#mid_menu').css({height: '50px'})
	}
	return {init}
})()