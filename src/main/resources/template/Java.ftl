package ${packageName};

import org.junit.Test;

<#list importClassList as importClass>
import ${importClass}
</#list>

/**
* <a href="https://leetcode.cn/problems/${titleSlug}/">${id}. ${title}</a>
*
* @author morningwn
* @date ${dataTime}
*/
public class J${fileSuffix} {

@Test
public void test() {

}

${javaCode}
}
