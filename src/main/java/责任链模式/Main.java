package ������ģʽ;

import ������ģʽ.filter.FaceFilter;
import ������ģʽ.filter.FilterChain;
import ������ģʽ.filter.HTMLFilter;
import ������ģʽ.filter.SesitiveFilter;
import ������ģʽ.processor.MsgProcessor;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String msg = "��Һ�:)��<script>�����У�����ҵ�������ڿ�û�о�����Ϊ��������һ��";
		MsgProcessor mp = new MsgProcessor();
		mp.setMsg(msg);

		FilterChain fc = new FilterChain();
		fc.addFilter(new HTMLFilter())
		  .addFilter(new SesitiveFilter());

		FilterChain fc2 = new FilterChain();
		fc2.addFilter(new FaceFilter());


		fc.addFilter(fc2);


		mp.setFc(fc);

		String result = mp.process();
		System.out.println(result);
	}

}
