  
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
                        .css({cursor: 'pointer',color: 'blue'})
                        .appendTo("#user_"+(i+1))
                        .click(e => {
                        	$('#content').empty()
                        	$.getJSON('/users'+`${j.name}`, d=> {
                        		$(`<tr>
                                    	<td>
                                            <span>1</span>
                                        </td>
                                        <td>
                                            <span>${d.userid}</span>
                                        </td>
                                        <td>
                                            <span>${d.name}</span>
                                        </td>
                                         <td>
                                            <span>${d.ssn}</span>
                                        </td>
                                       <td>
                                            <span>${d.email}</span>
                                        </td>
                                        <td>
                                            <span>${d.phoneNumber}</span>
                                        </td>
                                        <td>
                                            <span>${d.registerDate}</span>
                                        </td>
                                        
                                    </tr>`).appendTo('#userData')
                        	})
                        	
                        })
                        
			}) // each
		}) // getJSON
//		$.('#user_list_button').click( e=> {
//			$('#content').empty()
//		})
	}
	let setContentView = () => {
		$('#userData tr').first().css({'background-color':'yellow'})
	}
	return {init}
	
})()