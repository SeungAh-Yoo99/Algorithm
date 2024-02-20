import java.util.ArrayList;
import java.util.PriorityQueue;

class UserSolution {
	static class User {
            int uID;
            ArrayList<Integer> followList; // 팔로우 리스트
            ArrayList<Integer> postList; // 게시물
            int stamp; // 1000초 이내인 게시글 중 가장 오래된 게시글의 인덱스를 가리킨다.

            User(int uID) {
                this.uID = uID;
                followList = new ArrayList<>();
                postList = new ArrayList<>();
                stamp = 0;
            }

            void follow(int uID) { // uID 팔로우
                followList.add(uID);
            }

            void makePost(int pID) { // pID 게시글 게시
                postList.add(pID);
            }

            int getStamp(int timestamp, ArrayList<Post> allPostList) { // timestamp로부터 1000초 이내인 게시글 중 가장 오래된 게시글의 인덱스를 리턴

                while(this.stamp < this.postList.size()) {
                    if(timestamp - allPostList.get(this.postList.get(stamp)).timestamp > 1000) this.stamp++;
                    else break;
                }

                return this.stamp;
            }
        }

        static class Post {
            int pID;
            int timestamp;
            int like; // like 개수

            Post() {}

            Post(int pID, int timestamp) {
                this.pID = pID;
                this.timestamp = timestamp;
                like = 0;
            }

            void pushLike() {
                this.like++;
            }
        }

        User[] userList;
        ArrayList<Post> postList;

        public void init(int N)
        {
            // N만큼의 User 배열
            userList = new User[N + 1];

            // N명의 User 초기화
            for (int i = 1; i <= N; i++) {
                userList[i] = new User(i);
            }

            // post를 담을 수 있는 배열
            postList = new ArrayList<>();

            // pID가 1부터 시작하므로, 하나의 더미 데이터 넣어두기
            postList.add(new Post());

        }

        public void follow(int uID1, int uID2, int timestamp)
        {
            // uID1이 uID2 팔로우
            userList[uID1].follow(uID2);
        }

        public void makePost(int uID, int pID, int timestamp)
        {
            Post newPost = new Post(pID, timestamp);
            postList.add(newPost);
            userList[uID].makePost(pID);
        }

        public void like(int pID, int timestamp)
        {
            postList.get(pID).pushLike();
        }

        public void getFeed(int uID, int timestamp, int pIDList[])
        {
            User user = userList[uID];

            // 게시된지 1000초 이내인 게시글 정렬 큐
            PriorityQueue<Post> pq = new PriorityQueue<>((o1, o2) -> o1.like == o2.like ? o2.timestamp - o1.timestamp : o2.like - o1.like);

            // 자신이 게시한 글 큐에 넣기
            int stamp = user.getStamp(timestamp, postList);
            for (int i = stamp; i < user.postList.size(); i++) {
                pq.add(postList.get(user.postList.get(i)));
            }
            // 팔로우한 유저가 게시한 글 큐에 넣기
            int followingUserID; User followingUser;
            for (int i = 0; i < user.followList.size(); i++) {
                followingUserID = user.followList.get(i); // 팔로우 중인 userID
                followingUser = userList[followingUserID]; // 팔로우 중인 user
                stamp = followingUser.getStamp(timestamp, postList); // 팔로우 중인 user의 1000초 이내 게시물 인덱스

                for (int j = stamp; j < followingUser.postList.size(); j++) {
                    pq.add(postList.get(followingUser.postList.get(j)));
                }
            }

            // 게시된지 1000초 이내인 게시글 우선순위 반영하여 pIDList에 저장
            int idx = 0;
            while(!pq.isEmpty() && idx < 10) {
                pIDList[idx++] = pq.poll().pID;
            }

            // 만약 1000초 이내인 게시물로 10개의 게시물을 다 채웠다면
            if(idx == 10) return;

            // 10개의 게시물을 다 채우지 못했다면 1000초 초과 게시물 확인
            pq = new PriorityQueue<>((o1, o2) -> o2.timestamp - o1.timestamp);
            // 자신의 게시글
            stamp = user.stamp;
            for (int i = 0; i < stamp; i++) {
                pq.add(postList.get(user.postList.get(i)));
            }
            // 팔로우한 유저의 게시글
            for (int i = 0; i < user.followList.size(); i++) {
                followingUserID = user.followList.get(i);
                followingUser = userList[followingUserID];
                stamp = followingUser.stamp;

                for (int j = 0; j < stamp; j++) {
                    pq.add(postList.get(followingUser.postList.get(j)));
                }
            }

            while(!pq.isEmpty() && idx < 10) {
                pIDList[idx++] = pq.poll().pID;
            }
        }
}
