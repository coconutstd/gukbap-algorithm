const enter = [1,3,2]
const leave = [1,2,3]
const enter2 = [1,4,2,3]
const leave2 = [2,1,3,4]
const enter3 = [3,2,1]
const leave3 = [2,1,3]
const enter4 = [3,2,1]
const leave4 = [1,3,2]
const enter5 = [1,4,2,3]
const leave5 = [2,1,4,3]

function solution(enter, leave) {
  const encounteredInfo = {}
  const room = []
  const enterCopy = [...enter]
  const leaveCopy = [...leave]

  let enterIndex = 0
  const firstElementOfLeave = 0
  while(leaveCopy.length !== 0) {
    if(room.includes(leaveCopy[firstElementOfLeave])) {
      room.splice(room.indexOf(leaveCopy[firstElementOfLeave]), 1)
      leaveCopy.shift()
    } else {
      room.push(enterCopy[enterIndex])
      // 새로운 방문자가 회의실에 들어옴에 따라 encounteredInfo 업데이트
      // {'1': [2, 3], '2': [1], '3': [1]} <-- 이런식으로 만들거임
      for(let i = 0; i < room.length; ++i){
        if(encounteredInfo[room[i]] === undefined) encounteredInfo[room[i]] = []
        for(let j = 0; j < room.length; ++j){
          if(encounteredInfo[room[j]] === undefined) encounteredInfo[room[j]] = []
          if(room[i] !== room[j] && !encounteredInfo[room[i]].includes(room[j])) {
            encounteredInfo[room[i]].push(room[j])
            encounteredInfo[room[j]].push(room[i])
          }
        }
      }
     enterIndex++
    }
  }

  const result = []
  for(const key in encounteredInfo) {
    result.push(encounteredInfo[key].length)
  }
  console.log(result)
}

solution(enter, leave)
solution(enter2, leave2)
solution(enter3, leave3)
solution(enter4, leave4)
solution(enter5, leave5)
