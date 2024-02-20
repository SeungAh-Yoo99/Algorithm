import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class UserSolution {

        static class Node {

            int count;
            Map<Character, Node> trie;

            Node() {
                count = 0;
                trie = new HashMap<>();
            }

            int add(char str[], int s) {

                if(str[s] == '\0') {
                    count++;
                    return count;
                }

                Node n = trie.get(str[s]);
                if(n == null) {
                    n = new Node();
                    trie.put(str[s], n);
                }

                return n.add(str, s + 1);
            }

            int remove(char str[], int s) {

                int ret = 0;

                if(str[s] == '\0') {
                    ret = count;
                    count = 0;
                    return ret;
                }

                Node n;
                if(str[s] == '?') { // 와일드카드인 경우
                    Iterator<Character> iter = trie.keySet().iterator();
                    while(iter.hasNext()) {
                        n = trie.get(iter.next());
                        ret += n.remove(str, s + 1);
                    }
                }
                else { // 그 외
                    n = trie.get(str[s]);
                    if(n != null) {
                        ret += n.remove(str, s + 1);
                    }
                }

                return ret;
            }

            int search(char[] str, int s) {

                int ret = 0;

                if(str[s] == '\0') {
                    ret += count;
                    return ret;
                }

                Node n;
                char next;
                if(str[s] == '?') { // 와일드카드
                    Iterator<Character> iter = trie.keySet().iterator();
                    while(iter.hasNext()) {
                        n = trie.get(iter.next());
                        ret += n.search(str, s + 1);
                    }
                }
                else { // 그 외
                    n = trie.get(str[s]);
                    if(n != null) {
                        ret += n.search(str, s + 1);
                    }
                }

                return ret;
            }
        }

        Node root;

        void init() {

            root = new Node();

            return;
        }

        int add(char str[]) {
            int ret = root.add(str, 0);
            //System.out.println(ret);
            return ret;
        }

        int remove(char str[]) {
            int ret = root.remove(str, 0);
            //System.out.println(ret);
            return ret;
        }

        int search(char str[]) {
            int ret = root.search(str, 0);
            //System.out.println(ret);
            return ret;
        }
    }
