"use strict"

var admin = admin || {}

admin = (() => {
	let admin_vue
	let init = () => {
		admin_vue = `/resources/vue/admin_vue.js`
		onCreate()
	}
	let onCreate = () => {
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
                        	$('#content').empty()
                        	$('#content').html(adminVue.detail())
                        	$.getJSON(`/users/${j.name}`, d=> {
                        		
//                        		$('#name').text(d.name)
//                        		$('#userid').text(d.userid)
//                        		$('#ssn').text(d.ssn)
//                        		$('#email').text(d.email)
//                        		$('#phoneNumber').text(d.phoneNumber)
//                        		$('#registerDate').text(d.registerDate)
                        	})
                        	
                        })
                        
			}) // each
		}) // getJSON
		
	}
	let setContentView = () => {
		$('#userData tr').first().css({'background-color':'yellow'})
	}
	return {init}
	
})()