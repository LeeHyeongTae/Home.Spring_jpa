"use strict"
const lostVue = {
	list: () => {
		return `<div id="content" style="width: 1200px; height: 500px;margin: 0 auto">
            		<table id="lostData">
                        <tr>
                            <td>
                                <a id="number">No.</a>
                            </td>
                            <td>
                                <a id="lostId">ID</a>
                            </td>
                             <td>
                                <a id="lostName">분실물명</a>
                            </td>
                           	<td>
                                <a id="lostDate">습득일자</a>
                            </td>
                            <td>
                                <a id="lostClass">습득물분류</a>
                            </td>
                            <td>
                                <a id="lostLocation">습득위치</a>
                            </td>
                        </tr>
                    </table>
            	</div>`
	},
	detail: () => {
		return `
		<div id="content_container">
		<table>
			<tr>
				<td id="title" colspan="3">분실물 정보</td>
			</tr>
			<tr>
				<td id="profile_pic" rowspan="7">
					<svg id="profile_pic_default" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
						<path d="M3 5v14c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2H5c-1.11 0-2 .9-2 2zm12 4c0 1.66-1.34 3-3 3s-3-1.34-3-3 1.34-3 3-3 3 1.34 3 3zm-9 8c0-2 4-3.1 6-3.1s6 1.1 6 3.1v1H6v-1z" />
						<path d="M0 0h24v24H0z" fill="none" />
					</svg>
				</td>
				<td class="userlabel">아이디</td>
				<td class="input">
					<p id="lostid"></p>
				</td>
			</tr>
			<tr>
				<td class="userlabel">이름</td>
				<td class="input">
					<p id="lostname"></p>
				</td>
			</tr>
			<tr>
				<td class="userlabel">습득일자</td>
				<td class="input">
					<p id="lostdate"></p>
				</td>
			</tr>
			<tr>
				<td class="userlabel">종류</td>
				<td class="input">
					<p id="lostclass"></p>
				</td>
			</tr>
			<tr>
				<td class="userlabel">습득장소</td>
				<td class="input">
					<p id="lostlocation"></p>
				</td>
			</tr>
			<tr>
				<td class="userlabel">비고</td>
				<td class="input">
					<p id="etc"></p>
				</td>
			</tr>
		</table>
	</div>
`
	}
}