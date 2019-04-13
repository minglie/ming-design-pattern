package dtby;import javax.tools.*;import java.io.File;import java.net.URI;import java.net.URISyntaxException;import java.util.Arrays;interface MyInterface{   void invoke();}public class Dtby     {    public static void main(String[] args) {        String codes = "package dtby;\n" +                "\n" +                "public class Eval1 implements MyInterface {\n" +                "    public Eval1() {\n" +                "    }\n" +                "\n" +                "    public static void main(String[] var0) {\n" +                "        System.out.print(\"hello world\");\n" +                "    }\n" +                "\n" +                "    public void invoke() {\n" +                "        System.out.println(44);\n" +                "    }\n" +                "}\n";        String className = "dtby.Eval1";        MyInterface myInterface = (MyInterface)Dtby.getObject(className, codes);        myInterface.invoke();    }    private static Object  getObject(String className,String codes){        Class<?> clazz = compile(className, codes);        try {            // 生成对象            Object obj = clazz.newInstance();            return obj;        } catch (Exception e) {            e.printStackTrace();            return null;        }    }    /**     * 装载字符串成为java可执行文件     * @param className className     * @param javaCodes javaCodes     * @return Class     */    private static Class<?> compile(String className, String javaCodes) {        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);        StrSrcJavaObject srcObject = new StrSrcJavaObject(className, javaCodes);        Iterable<? extends JavaFileObject> fileObjects = Arrays.asList(srcObject);        String flag = "-d";        String outDir = "";        try {            File classPath = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());            outDir = classPath.getAbsolutePath() + File.separator;        } catch (URISyntaxException e1) {            e1.printStackTrace();        }        Iterable<String> options = Arrays.asList(flag, outDir);        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, options, null, fileObjects);        boolean result = task.call();        if (result == true) {            try {                return Class.forName(className);            } catch (ClassNotFoundException e) {                e.printStackTrace();            }        }        return null;    }    private static class StrSrcJavaObject extends SimpleJavaFileObject {        private String content;        StrSrcJavaObject(String name, String content) {            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);            this.content = content;        }        public CharSequence getCharContent(boolean ignoreEncodingErrors) {            return content;        }    }}