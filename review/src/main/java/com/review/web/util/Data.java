package com.review.web.util;

import java.io.File;

public enum Data {
		USER_PATH, ADMIN_PATH, CSV, LIST;
		
		@Override
		public String toString() {
			String returnValue = "";
			switch(this) {
			case USER_PATH: returnValue="Users"+File.separator+"iheyongtae"+File.separator+"git"+File.separator+
					"repository2"+File.separator+"review"+File.separator+"src"+File.separator+"main"+File.separator+
					"resources"+File.separator+"static"+File.separator+"admin"+File.separator;
					break;
			case ADMIN_PATH: returnValue="Users"+File.separator+"iheyongtae"+File.separator+"git"+File.separator+
					"repository2"+File.separator+"review"+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+
					"resources"+File.separator+"static"+File.separator+"user"+File.separator;
			break;
			case CSV: returnValue=".csv"; break;
			default:
				break;
			}
			return returnValue;
		}
}
