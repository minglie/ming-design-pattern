package 责任链模式.filter;

import 责任链模式.filter.baseInterface.Filter;

public class FaceFilter implements Filter {

	@Override
	public String doFilter(String str) {
		return str.replace(":)", "^V^");
	}

}
