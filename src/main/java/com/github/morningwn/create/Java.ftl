package ${packageName};

import org.junit.Test;

<#list importClassList as importClass>
import ${importClass}
</#list>

/**
* <a href="https://leetcode.cn/problems/${titleSlug}/">${id}. ${title}</a>
*
* @author morningwn
* @date
*/
public class ${className} {

@Test
public void test() {

}

${javaCode}
}
