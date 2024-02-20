public class UserSolution {
       static class Node{

            int uID;
            int income;
            Node pre;
            Node next;

            Node() {}

            Node(int uID, int income) {
                this.uID = uID;
                this.income = income;
            }

            int compare(Node other) {

                if (this.income == other.income) {
                    return this.uID - other.uID;
                }
                return other.income - this.income;
            }
        }

        static class ArrayList {

            Node head;
            int size;

            ArrayList() {
                head = new Node();
                size = 0;
            }

            void add(int uID, int income) {

                Node node = new Node(uID, income);
                Node now = head;

                for (int i = 0; i < (10 < size + 1 ? 10 : size + 1); i++) {

                    if(now.next == null) {
                        now.next = node;
                        node.pre = now;
                        break;
                    }

                    now = now.next;

                    if(node.compare(now) < 0) {
                        node.pre = now.pre;
                        node.next = now;

                        now.pre = node;
                        node.pre.next = node;

                        break;
                    }

                }

                size++;
            }

            int getTop10(int[] result) {

                Node now = head;

                for (int i = 0; i < (10 < size ? 10 : size); i++) {
                    now = now.next;
                    result[i] = now.uID;
                }

                return 10 < size ? 10 : size;
            }

        }

        private ArrayList list;

        public void init() {
            list = new ArrayList();
        }

        public void addUser(int uID, int income) {
            list.add(uID, income);
        }

        int getTop10(int[] result) {

            return list.getTop10(result);
        }
}
