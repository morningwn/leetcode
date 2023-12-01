package ${packageName};

import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

<#list importClassList as importClass>
import ${importClass}
</#list>

/**
* <a href="https://leetcode.cn/problems/${titleSlug}/">${id}. ${title}</a>
* <ul>
* <li>{@link Difficulty#${difficulty}}</li>
<#list topics as topic>
* <li>{@link Topic#${topic}}</li>
</#list>
* </ul>
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
