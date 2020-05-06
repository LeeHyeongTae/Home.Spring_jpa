"use strict"

var admin = admin || {}

admin = (() => {
	const WHEN_ERROR = `error`
	let admin_vue
	let user_vue
	let lost_vue
	let init = () => {
		admin_vue = `/resources/vue/admin_vue.js`
		user_vue = `/resources/vue/user_vue.js`
		lost_vue = `/resources/vue/lost_vue.js`
		onCreate()
	}
	let onCreate = () => {
		$.when(
			$.getScript(user_vue)
		).done(()=>{
			setContentView()
			$.getJSON('/users', d => {
				$('#total_count').text('총회원수  : '+d.length)
				$.each(d, (i, j) => {
					$(`<tr>
	                        	<td>
	                                <span>${i+1}</span>
	                            </td>
	                            <td>
	                                <span>${j.userid}</span>
	                            </td>
	                            <td>
	                                <span id="user_`+(i+1)+`"></span>
	                            </td>
	                             <td>
	                                <span>${j.ssn}</span>
	                            </td>
	                           <td>
	                                <span>${j.email}</span>
	                            </td>
	                            <td>
	                                <span>${j.phoneNumber}</span>
	                            </td>
	                            <td>
	                                <span>${j.registerDate}</span>
	                            </td>
	                            
	                        </tr>`).appendTo('#userData')
	                        $(`<a>${j.name}</a>`)
	                        .appendTo("#user_"+(i+1))
	                        .css({cursor: 'pointer',color: 'blue'})
	                        .click(e => {
	                        	e.preventDefault()
	                        	$('#userData').empty()
	                        	$(userVue.detail()).appendTo('#userData')
	                        	$.getJSON(`/users/${j.userid}`, d=> {
	                        		$('#name').text(d.name)
	                        		$('#userid').text(d.userid)
	                        		$('#ssn').text(d.ssn)
	                        		$('#email').text(d.email)
	                        		$('#phoneNumber').text(d.phoneNumber)
	                        		$('#registerDate').text(d.registerDate)
	                        	})
	                        })
	                        
				}) // each
			}) // getJSON
			$('#admin_list_button').click( e=> {
				e.preventDefault()
				$('#userData').empty()
				$('#content').html(adminVue.adminList())
				$.getJSON('/admins', d=> {
					$.each(d, (i, j) => {
					$(`<tr>
	                        	<td>
	                                <span>${i+1}</span>
	                            </td>
	                            <td>
	                                <span>${j.employNumber}</span>
	                            </td>
	                            <td>
	                                <span>${j.name}</span>
	                            </td>
	                             <td>
	                                <span>${j.position}</span>
	                            </td>
	                           <td>
	                                <span>${j.email}</span>
	                            </td>
	                            <td>
	                                <span>${j.phoneNumber}</span>
	                            </td>
	                            <td>
	                                <span>${j.registerDate}</span>
	                            </td>
	                            
	                        </tr>`).appendTo('#userData')
				})
			})
			$('#userData tr').first().css({'background-color':'yellow'})
		})
		$('#user_list_button').click( e=> {
			e.preventDefault()
			location.href='/admin'
		})
		$('#lost_list_button').click( e=> {
			e.preventDefault()
			$('#content').empty()
			$('#content').html(lostVue.list())
			$('#lostData tr').first().css({'background-color':'yellow'})
			$.getJSON('/losts', d => {
				$('#total_count').text('총분실물 수  : '+d.length)
				$.each(d, (i, j) => {
					$(`<tr>
								<td>
	                                <span>${i+1}</span>
								</td>
								<td>
	                                <span>${j.lostId}</span>
	                            </td>
	                            <td>
	                                <span id="lost_`+(i+1)+`"></span>
	                            </td>
	                             <td>
	                                <span>${j.lostDate}</span>
	                            </td>
	                           <td>
	                                <span>${j.lostClass}</span>
	                            </td>
	                            <td>
	                                <span>${j.lostLocation}</span>
	                            </td>
	                        </tr>`).appendTo('#lostData')
	                        $(`<a>${j.lostName}</a>`)
	                        .appendTo('#lost_'+(i+1))
	                        .css({cursor: 'pointer',color: 'blue'})
	                        .click( e=> {
	                        	e.preventDefault()
	                        	$('#lostData').empty()
	                        	$(lostVue.detail()).appendTo('#lostData')
	                        	$.getJSON(`/losts/${j.lostId}`, d => {
	                        		$('#lostid').text(d.lostId)
	                        		$('#lostname').text(d.lostName)
	                        		$('#lostdate').text(d.lostDate)
	                        		$('#lostclass').text(d.lostClass)
	                        		$('#lostlocation').text(d.lostLocation)                        		
	                        	})
	                        })
				})
			})//getjson
			
		})//
		}).fail(()=>{alert(WHEN_ERROR)})
		
	}
	let setContentView = () => {
		$('#userData tr').first().css({'background-color':'yellow'})
	}
	return {init}
	
})()