/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package cat.uvic.teknos.m06.bandhub.utilities;

import cat.uvic.teknos.m06.bandhub.list.LinkedList;

public class StringUtils {
    public static String join(LinkedList source) {
        return JoinUtils.join(source);
    }

    public static LinkedList split(String source) {
        return SplitUtils.split(source);
    }
}
