import java.util.*;

class UserSolution {

    private final static int NAME_MAXLEN	= 6;
        private final static int PATH_MAXLEN	= 1999;

        private static class Directory { // 하나의 디렉토리

            String name; // 디렉토리 명
            LinkedList<Directory> child; // 자식 디렉토리 리스트

            Directory(String name) {

                this.name = name;

                // 자식 리스트 생성
                child = new LinkedList<>();
            }

            private boolean equals(String name) { // name이 같으면 같은 디렉토리라고 봄
                if(this.name.equals(name)) return true;
                else return false;
            }

            private Directory findChildDirectory(String childDirectoryName) { // 하위 디렉토리 중, childDirectoryName을 가진 디렉토리 반환

                for (int i = 0; i < child.size(); i++) {
                    if(child.get(i).equals(childDirectoryName)) return child.get(i);
                }

                return null;
            }

            private void addNewDirectory(Directory d) { // 새 하위 디렉토리 추가
                child.add(d);
            }

            private void deleteChildDirectory(String name) { // 하위 디렉토리 삭제
                for (int i = 0; i < child.size(); i++) {
                    if(child.get(i).equals(name)) child.remove(i);
                }
            }

            private Directory copyDirectory() { // 똑같은 디렉토리 구조 복사

                Directory copy = new Directory(this.name);

                for (int i = 0; i < child.size(); i++) {
                    copy.addNewDirectory(child.get(i).copyDirectory());
                }

                return copy;
            }

            private int size() { // 하위 디렉토리의 개수

                int ret = 0;

                for (int i = 0; i < child.size(); i++) {
                    ret += child.get(i).size() + 1;
                }

                return ret;
            }
        }

        private Directory root;

        String charArrayToString(char[] charArray, int s, int e) {

            StringBuilder tmp = new StringBuilder();

            for (int i = s; i < e; i++) {
                tmp.append(charArray[i]);
            }

            return tmp.toString();
        }

        void init(int n) {

            // 루트 디렉토리 생성
            root = new Directory("/");
        }

        Directory moveSubdirectory(char[] path, int e) {

            Directory now = root;

            // path의 가장 하위 디렉토리로 이동
            int idx = 1; String nextDirectoryName; StringBuilder tmp;
            while(idx < e) {
                tmp = new StringBuilder();
                while(path[idx] != '/') tmp.append(path[idx++]);

                now = now.findChildDirectory(tmp.toString());
                idx++;
            }


            return now;
        }

        void cmd_mkdir(char[] path, char[] name) {

            // path의 가장 하위 디렉토리로 이동
            Directory now = moveSubdirectory(path, path.length - 2);

            // 가장 하위 디렉토리에 새 디렉토리 생성
            now.addNewDirectory(new Directory(charArrayToString(name, 0, name.length - 1)));
        }

        void cmd_rm(char[] path) {

            // path의 가장 하위 디렉토리의 상위 디렉토리로 이동
            int e = path.length - 3;
            while(e >= 0 && path[e] != '/') e--;
            Directory now = moveSubdirectory(path, e);

            // now의 자식 디렉토리 중 path의 가장 하위 디렉토리를 삭제
            now.deleteChildDirectory(charArrayToString(path, e + 1, path.length - 2));
        }

        void cmd_cp(char[] srcPath, char[] dstPath) {

            // srcPath의 디렉토리 가져오기
            Directory src = moveSubdirectory(srcPath, srcPath.length - 2);

            // dstPath의 디렉토리 가져오기
            Directory dst = moveSubdirectory(dstPath, dstPath.length - 2);

            // dstPath의 하위에 src 복사
            dst.addNewDirectory(src.copyDirectory());
        }

        void cmd_mv(char[] srcPath, char[] dstPath) {

            // src의 상위 디렉토리에서 src 지우기
            Directory src = moveSubdirectory(srcPath, srcPath.length - 2);

            int e = srcPath.length - 3;
            while(e >= 0 && srcPath[e] != '/') e--;
            Directory srcParent = moveSubdirectory(srcPath, e);

            srcParent.deleteChildDirectory(src.name);

            // dst에 src 저장
            Directory dst = moveSubdirectory(dstPath, dstPath.length - 2);
            dst.addNewDirectory(src);
        }

        int cmd_find(char[] path) {

            // path로 이동
            Directory now = moveSubdirectory(path, path.length - 2);

            return now.size();
        }
}
