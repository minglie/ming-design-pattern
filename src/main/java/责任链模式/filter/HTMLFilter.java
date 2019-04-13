package ������ģʽ.filter;

import ������ģʽ.filter.baseInterface.Filter;

public class HTMLFilter implements Filter {

	@Override
	public String doFilter(String str) {
		//process the html tag <>
		String r = str.replace('<', '[')
				   .replace('>', ']');
		return r;
	}

}
