function solution(m, v) {
    var answer = 0;

    let count = 1;
    let row = m;
    let blocks = {"1" : 0};

    for(let i = 0; i < v.length; ++i){
        let isBlock = false;

        let keys = Object.keys(blocks).reverse();

        for(let j in keys){
            if(row - blocks[keys[j]] < v[i]){
                blocks[Number(keys[j]) + 1] = 0;
                blocks[Number(keys[j]) + 1] += v[i];
                console.log(blocks);
                isBlock = true;
                break;
            }
        }
        if(isBlock) continue;
        blocks[count] += v[i];
        console.log(blocks);
    }
    console.log("------");
    answer = Object.entries(blocks).length;
    return answer;
}


let m = 4;
let v = [2, 3, 1];

solution(m, v);

m = 4;
v = [3, 2, 3, 1];

solution(m, v);
