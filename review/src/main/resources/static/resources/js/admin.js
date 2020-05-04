"use strict"
var admin = admin || {}
admin = (() => {
	let init = () => {
		onCreate()
	}
	let onCreate = () => {
		setContentView()
		$.getJSON('/user/list', d => {
			$.each(d, (i, j) => {
				$(`<td>
                                <span>${i+1}</span>
                            </td>
                            <td>
                                <span>${j.userid}</span>
                            </td>
                             <td>
                                <span id="user_"+${i+1}></span>
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
                            </td>`)
				.appendTo('#userData')
				$(`<a>${j.name}</a>`)
				.css({cursor : 'pointer', color:'blue'})
				.appendTo("#user_"+`${i+1}`)
				.click( e => {
				e.preventDefault()
				alert('')
				})//each
			}) //getjson
		}
		
	}
	let setContentView = () => {
		$('#userData tr').first().css({'background-color':'yellow'})
	}
	return {init}
	
})()