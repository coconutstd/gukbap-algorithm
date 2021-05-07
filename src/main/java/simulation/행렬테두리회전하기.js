function rotate(map, q){
    let min = 10000000;
    let rowMin = q[0] - 1;
    let colMin = q[1] - 1;
    let rowMax = q[2] - 1;
    let colMax = q[3] - 1;
    let temp = map[rowMin][colMin];
    let arr = [temp];
    for(let i = rowMin; i < rowMax; ++i){
        map[i][colMin] = map[i + 1][colMin];
        arr.push(map[i + 1][colMin]);
    }
    for(let i = colMin; i < colMax; ++i){
        map[rowMax][i] = map[rowMax][i + 1];
        arr.push(map[rowMax][i + 1]);
    }
    for(let i = rowMax; i > rowMin; --i){
        map[i][colMax] = map[i - 1][colMax];
        arr.push(map[i - 1][colMax]);
    }
    for(let i = colMax; i > colMin; --i){
        map[rowMin][i] = map[rowMin][i - 1];
        arr.push(map[rowMin][i - 1]);
    }
    map[rowMin][colMin + 1] = temp;

    return Math.min.apply(null, arr);
}

function solution(rows, columns, queries) {
    let answer = [];
    const map = Array.from(Array(rows), () => new Array(columns))

    let val = 1;
    for(let i = 0; i < rows; ++i){
        for(let j = 0; j < columns; ++j){
            map[i][j] = val++;
        }
    }

    queries.forEach(q => {
       answer.push(rotate(map, q));
    });

    return answer;
}

solution(6, 6, [[2,2,5,4],[3,3,6,6],[5,1,6,3]]);


// [8, 10, 25]
