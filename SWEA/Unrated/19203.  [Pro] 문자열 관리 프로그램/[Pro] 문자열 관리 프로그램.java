import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class UserSolution {

        // 문자열 해시값을 구하기 위한 MOD 값
        final int MOD = ('Z' - 'A' + 2);
        final int MOD2 = (int)Math.pow(MOD, 2); // MOD 2제곱
        final int MOD3 = (int)Math.pow(MOD, 3); // MOD 3제곱

        // 문자열 저장 배열
        Deque<Integer> dq;

        // 문자열이 뒤집어 있는지 확인하는 변수
        boolean isReverse;

        // 현재 문자열 4 이하 길이의 모든 부분 문자열 해시값
        HashMap<Integer, Integer> hashMap;

        // 문자열 앞 문자 1개의 해시값
        int first1;
        // 문자열 앞 문자 2개의 해시값
        int first2;
        // 문자열 앞 문자 3개의 해시값
        int first3;
        // 문자열 앞 문자 4개의 해시값
        int first4;
        // 문자열 뒤 문자 1개의 해시값
        int last1;
        // 문자열 뒤 문자 2개의 해시값
        int last2;
        // 문자열 뒤 문자 3개의 해시값
        int last3;
        // 문자열 뒤 문자 4개의 해시값
        int last4;

        void init(char mStr[]) {

            dq = new LinkedList<>();
            hashMap = new HashMap<>();
            isReverse = false;

            first1 = -1; first2 = -1; first3 = -1; first4 = -1;
            last1 = -1; last2 = -1; last3 = -1; last4 = -1;

            appendWord(mStr);
        }

        void appendWord(char mWord[]) {

            int idx = 0;
            while(mWord[idx] != '\0') {
                add(mWord[idx++] - 'a' + 1);
            }
        }

        void add(int c) { // 문자열 추가 메소드

            // 정방향인 경우
            if(!isReverse) {
                dq.addLast(c);

                // c를 포함한 길이 4의 해시값
                if(dq.size() >= 4) {
                    last4 = last3 * MOD + c;
                    hashMap.put(last4, hashMap.getOrDefault(last4, 0) + 1);
                }
                // c를 포함한 길이 3의 해시값
                if(dq.size() >= 3) {
                    last3 = last2 * MOD + c;
                    hashMap.put(last3, hashMap.getOrDefault(last3, 0) + 1);
                }
                // c를 포함한 길이 2의 해시값
                if(dq.size() >= 2) {
                    last2 = last1 * MOD + c;
                    hashMap.put(last2, hashMap.getOrDefault(last2, 0) + 1);
                }
                last1 = c;
            }
            // 문자열을 뒤집은 경우
            else {
                dq.addFirst(c);

                // c를 포함한 길이 4의 해시값
                if(dq.size() >= 4) {
                    first4 = c * MOD3 + first3;
                    hashMap.put(first4, hashMap.getOrDefault(first4, 0) + 1);
                }
                // c를 포함한 길이 3의 해시값
                if(dq.size() >= 3) {
                    first3 = c * MOD2 + first2;
                    hashMap.put(first3, hashMap.getOrDefault(first3, 0) + 1);
                }
                // c를 포함한 길이 2의 해시값
                if(dq.size() >= 2) {
                    first2 = c * MOD + first1;
                    hashMap.put(first2, hashMap.getOrDefault(first2, 0) + 1);
                }
                first1 = c;
            }

            // c의 해시값
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        void cut(int k) {

            int idx = 0;
            int[] poll = new int[5];

            // 문자열이 정방향인 경우
            if(!isReverse) {
                while(idx++ < k) {
                    hashMap.put(last1, hashMap.get(last1) - 1);
                    last1 = last2 / MOD;

                    if(dq.size() >= 2) {
                        hashMap.put(last2, hashMap.get(last2) - 1);
                        last2 = last3 / MOD;
                    }

                    if(dq.size() >= 3) {
                        hashMap.put(last3, hashMap.get(last3) - 1);
                        last3 = last4 / MOD;
                    }
                    if(dq.size() >= 4) {
                        hashMap.put(last4, hashMap.get(last4) - 1);
                        if(dq.size() >= 5) {
                            for (int i = 0; i < 5; i++) {
                                poll[i] = dq.pollLast();
                            }
                            last4 = poll[4] * MOD3 + last3;
                            for (int i = 4; i >= 0; i--) {
                                dq.addLast(poll[i]);
                            }
                        }
                        else last4 = -1;
                    }

                    dq.pollLast();
                }
            }
            // 문자열이 뒤집힌 경우
            else {
                while(idx++ < k) {
                    hashMap.put(first1, hashMap.get(first1) - 1);
                    first1 = first2 % MOD;

                    if(dq.size() >= 2) {
                        hashMap.put(first2, hashMap.get(first2) - 1);
                        first2 = first3 % MOD2;
                    }

                    if(dq.size() >= 3) {
                        hashMap.put(first3, hashMap.get(first3) - 1);
                        first3 = first4 % MOD3;
                    }
                    if(dq.size() >= 4) {
                        hashMap.put(first4, hashMap.get(first4) - 1);
                        if(dq.size() >= 5) {
                            for (int i = 0; i < 5; i++) {
                                poll[i] = dq.pollFirst();
                            }
                            first4 = first3 * MOD + poll[4];
                            for (int i = 4; i >= 0; i--) {
                                dq.addFirst(poll[i]);
                            }
                        }
                        else first4 = -1;
                    }

                    dq.pollFirst();
                }
            }

        }

        void reverse() {

            if(isReverse) isReverse = false;
            else {
                isReverse = true;

                // 처음으로 뒤집는 경우
                if(first1 == -1) {
                    int[] poll = new int[4];
                    int idx = 0;
                    while(idx < 4 && !dq.isEmpty()) {
                        poll[idx++] = dq.pollFirst();
                    }

                    if(idx >= 1) first1 = poll[0];
                    if(idx >= 2) first2 = first1 * MOD + poll[1];
                    if(idx >= 3) first3 = first2 * MOD + poll[2];
                    if(idx == 4) first4 = first3 * MOD + poll[3];

                    for (int i = idx - 1; i >= 0; i--) {
                        dq.addFirst(poll[i]);
                    }
                }
            }
        }

        int countOccurrence(char mWord[]) {

            // mWord의 해시값 구하기
            int idx = 0;
            int hash = 0;

            // 문자열이 정방향으로 있을 경우의 해시값
            if(!isReverse) {
                while(mWord[idx] != '\0') {
                    hash = hash * MOD + mWord[idx++] - 'a' + 1;
                }
            }
            // 문자열이 뒤집혀 있을 경우의 해시값
            else {
                while(mWord[idx] != '\0') {
                    idx++;
                }

                for (int i = idx - 1; i >= 0 ; i--) {
                    hash = hash * MOD + mWord[i] - 'a' + 1;
                }
            }

            // 현재 문자열에서 겹치는 경우가 몇 개인지 구하기
            int ret = hashMap.getOrDefault(hash, 0);

            return ret;
        }
    }
