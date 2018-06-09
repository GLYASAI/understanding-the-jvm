String str1 = new StringBuilder("计算机").append("软件").toString();
System.out.println(str1.intern() == str1);&#160;&#160;// 结果是true

String str3 = new StringBuilder("AbeWang").toString();
System.out.println(str3.intern() == str3);&#160;&#160;// 结果是false

因为String str3 = new StringBuilder("AbeWang").toString();在new的时候 “AbeWang”就已经进常量池了，然后再赋值到str3，str3不在常量池，因为常量池已经有“AbeWang”了.
\
用append的时候new StringBuilder("计算机").append("软件").toString();在new的时候常量池创建的是“计算机”和“软件”，然后赋值给str1的时候，常量池中没有“计算机软件”，所以这个时候的str1还不是常量池的，通过intern()把str1变成常量池的
