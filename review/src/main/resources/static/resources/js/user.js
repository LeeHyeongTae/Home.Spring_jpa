"use strict"
var user = user || {}
user = (() => {
	let init = () => {
		onCreate()
	}
	let onCreate = () => {
		
		$('#register_button').click( e=> {
			e.preventDefault()
			location.href="/admin"
		})
		$('#access_button').click( e=> {
			$.ajax({
				
			})
			})
		$('#userjoin_button').click( e=> {
			location.href="user/join.html"
		})
		$('#userlogin_button').click( e=> {
			location.href="user/login.html"
		})
		setContentView()
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