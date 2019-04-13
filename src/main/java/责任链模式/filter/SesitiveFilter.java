package 责任链模式.filter;

import 责任链模式.filter.baseInterface.Filter;

public class SesitiveFilter implements Filter {

	@Override
	public String doFilter(String str) {
		//process the sensitive words
		String r = str.replace("被就业", "就业")
			 .replace("敏感", "");
		
		return r;
	}

}
