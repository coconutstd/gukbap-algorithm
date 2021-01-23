function solution(n, record) {
    var answer = [];
    let dic = {};
    for(let i = 1; i <= n; ++i){
        dic[i] = [];
    }
    for(let i = 0; i < record.length; ++i){
        let serverNo = record[i].split(" ")[0];
        let nickName = record[i].split(" ")[1];
        if(!dic[serverNo].includes(nickName)){
            if(dic[serverNo].length == 5){
                dic[serverNo].shift();
                dic[serverNo].push(nickName);
            } else {
                dic[serverNo].push(nickName);
            }
        }
    }

    for(let i in dic){
        if(dic[i].length !== 0){
            answer += [...dic[i]]
        }
    }
    console.log(answer);
    return answer;
}


let n = 1;
let record = ["1 fracta", "1 sina","1 hana","1 robel","1 abc", "1 sina", "1 lynn"];

solution(n, record);

n = 4;
record = ["1 a","1 b","1 abc","3 b","3 a","1 abcd","1 abc","1 aaa","1 a","1 z","1 q", "3 k", "3 q", "3 z", "3 m", "3 b"];
solution(n, record);
