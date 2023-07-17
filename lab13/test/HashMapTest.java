import static com.google.common.truth.Truth.assertThat;
import org.junit.Test;

import java.util.HashSet;

public class HashMapTest {

    @Test
    public void testConstructor() {
        // assert constructors are initialized, seem to work correctly, and
        // don't cause errors
        HashMap<String, String> dictionary = new HashMap<String, String>();
        assertThat(dictionary.size()).isEqualTo(0);
        assertThat(dictionary.capacity()).isEqualTo(16);

        dictionary = new HashMap<String, String>(10);
        assertThat(dictionary.size()).isEqualTo(0);
        assertThat(dictionary.capacity()).isEqualTo(10);

        // simply test that the constructor exists, resizeTest will do the rest
        dictionary = new HashMap<String, String>(10, 1);
        assertThat(dictionary.size()).isEqualTo(0);
        assertThat(dictionary.capacity()).isEqualTo(10);
    }

    @Test
    public void testClear() {
        HashMap<String, String> h = new HashMap<String, String>();
        h.put("claire", "ko");
        assertThat(h.containsKey("claire")).isTrue();
        assertThat(h.get("claire")).isEqualTo("ko");
        assertThat(h.size()).isEqualTo(1);

        h.put("matt", "pancakes");
        assertThat(h.containsKey("matt")).isTrue();
        assertThat(h.get("matt")).isEqualTo("pancakes");
        assertThat(h.size()).isEqualTo(2);

        h.clear();
        assertThat(h.containsKey("claire")).isFalse();
        assertThat(h.containsKey("matt")).isFalse();
        assertThat(h.size()).isEqualTo(0);
    }

    @Test
    public void testPut() {
        HashMap<String, String> h = new HashMap<String, String>();
        h.put("mike", "parth");
        assertThat(h.containsKey("mike")).isTrue();
        assertThat(h.get("mike")).isEqualTo("parth");
        assertThat(h.containsKey("alex")).isFalse();
        assertThat(h.containsKey("henry")).isFalse();
        assertThat(h.size()).isEqualTo(1);
        
        h.put("eli", "kevin");
        assertThat(h.containsKey("eli")).isTrue();
        assertThat(h.containsKey("kevin")).isFalse();
        assertThat(h.size()).isEqualTo(2);
    }

    @Test
    public void testGet() {
        HashMap<String, String> h = new HashMap<String, String>();
        h.put("claire", "lam");
        assertThat(h.get("claire")).isEqualTo("lam");
    }

    @Test
    public void testRemove() {
        HashMap<String, String> h = new HashMap<String, String>();
        h.put("alex", "claire");
        assertThat(h.containsKey("alex")).isTrue();
        assertThat(h.get("alex")).isEqualTo("claire");
        assertThat(h.size()).isEqualTo(1);

        h.remove("alex");
        assertThat(h.containsKey("alex")).isFalse();
        assertThat(h.size()).isEqualTo(0);
    }

    @Test
    public void testResize() {
        HashMap<String, String> h = new HashMap<String, String>(2);
        assertThat(h.capacity()).isEqualTo(2);
        h.put("connor", "grace");
        h.put("zoe", "matt");
        assertThat(h.capacity()).isEqualTo(4);

        h = new HashMap<String, String>(10, 1);
        for (int i = 1; i <= 10; i += 1) {
            h.put(Integer.toString(i), Integer.toString(i));
        }
        assertThat(h.size()).isEqualTo(10);
        assertThat(h.capacity()).isEqualTo(10);

        h.put("matt", "matt");
        assertThat(h.size()).isEqualTo(11);
        assertThat(h.capacity()).isEqualTo(20);

        h.remove("matt");
        assertThat(h.size()).isEqualTo(10);
        assertThat(h.capacity()).isEqualTo(20);
    }

    @Test
    public void basicFunctionalityTest() {
        HashMap<String, String> dictionary = new HashMap<String, String>();
        assertThat(dictionary.size()).isEqualTo(0);
        assertThat(dictionary.capacity()).isEqualTo(16);

        // can put objects in dictionary and get them
        dictionary.put("grace", "connor");
        assertThat(dictionary.containsKey("grace")).isTrue();
        assertThat(dictionary.get("grace")).isEqualTo("connor");
        assertThat(dictionary.size()).isEqualTo(1);

        // putting with existing key replaces key
        dictionary.put("grace", "kevin");
        assertThat(dictionary.size()).isEqualTo(1);
        assertThat(dictionary.get("grace")).isEqualTo("kevin");
        assertThat(dictionary.remove("grace")).isEqualTo("kevin");
        assertThat(dictionary.get("grace") == null).isTrue();
        assertThat(dictionary.size()).isEqualTo(0);

        // placing key in multiple times does not affect behavior
        HashMap<String, Integer> studentIDs = new HashMap<String, Integer>();
        studentIDs.put("zoe", 12345);
        assertThat(studentIDs.size()).isEqualTo(1);
        assertThat(studentIDs.get("zoe").intValue()).isEqualTo(12345);
        
        studentIDs.put("shreya", 345);
        assertThat(studentIDs.size()).isEqualTo(2);
        assertThat(studentIDs.get("zoe").intValue()).isEqualTo(12345);
        assertThat(studentIDs.get("shreya").intValue()).isEqualTo(345);

        studentIDs.put("shreya", 345);
        assertThat(studentIDs.size()).isEqualTo(2);
        assertThat(studentIDs.get("zoe").intValue()).isEqualTo(12345);
        assertThat(studentIDs.get("shreya").intValue()).isEqualTo(345);

        studentIDs.put("shreya", 345);
        assertThat(studentIDs.size()).isEqualTo(2);
        assertThat(studentIDs.get("zoe").intValue()).isEqualTo(12345);
        assertThat(studentIDs.get("shreya").intValue()).isEqualTo(345);
        assertThat(studentIDs.containsKey("zoe")).isTrue();
        assertThat(studentIDs.containsKey("shreya")).isTrue();

        // ensure that containsKey does not always return true
        assertThat(studentIDs.containsKey("jay")).isFalse();
        assertThat(studentIDs.containsKey("travis")).isFalse();
        studentIDs.put("travis", 612);
        studentIDs.put("jay", 216);
        assertThat(studentIDs.containsKey("travis")).isTrue();
        assertThat(studentIDs.containsKey("jay")).isTrue();

        // confirm hash map can handle values being the same
        assertThat(studentIDs.get("shreya").intValue()).isEqualTo(345);
        studentIDs.put("anya", 345);
        assertThat(studentIDs.get("anya").intValue()).isEqualTo(345);
        assertThat(studentIDs.get("anya")).isEqualTo(studentIDs.get("shreya"));
    }

    @Test
    public void iteratorTest() {
        // replicate basic functionality test while building database
        HashMap<String, Integer> studentIDs = new HashMap<String, Integer>();
        studentIDs.put("zoe", 12345);
        studentIDs.put("jay", 345);
        assertThat(studentIDs.containsKey("zoe")).isTrue();
        assertThat(studentIDs.containsKey("jay")).isTrue();

        // ensure that containsKey does not always return true
        assertThat(studentIDs.containsKey("jay")).isTrue();
        assertThat(studentIDs.containsKey("travis")).isFalse();
        assertThat(studentIDs.containsKey("ryan")).isFalse();
        studentIDs.put("ryan", 162);
        assertThat(studentIDs.containsKey("ryan")).isTrue();

        // confirm hashMap can handle values being the same
        studentIDs.put("grace", 12345);
        assertThat(studentIDs.get("grace")).isEqualTo(studentIDs.get("zoe"));

        HashSet<String> expected = new HashSet<String>();
        expected.add("zoe");
        expected.add("jay");
        expected.add("ryan");
        expected.add("grace");

        HashSet<String> output = new HashSet<String>();
        for (String name : studentIDs) {
            output.add(name);
        }
        assertThat(output).isEqualTo(expected);
    }

}
