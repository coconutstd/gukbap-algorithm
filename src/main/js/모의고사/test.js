const table = ["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"]
const languages1 = ["PYTHON", "C++", "SQL"]
const preference1 = [7, 5, 5]
const languages2 = ["JAVA", "JAVASCRIPT"]
const preference2 = [7, 5]

function solution(table, languages1, preference1) {
  const scoreTable = table.map(domain => domain.split(' '))
  const result = {}
  for(let i = 0; i < languages1.length; ++i) {
    for(let j = 0; j < 5; ++j) {
      let langaugeScore = 0
      const index = scoreTable[j].indexOf(languages1[i])
      const domain = scoreTable[j][0]
      if(index !== -1) {
        langaugeScore += (6 - index) * preference1[i]
      }
      
      if (result[domain]) {
        result[domain] += langaugeScore
      } else {
        result[domain] = langaugeScore
      }
    }
  }

  const answer = []
  let max = -Infinity;

  for(const domain in result) {
    if(result[domain] > max) {
      max = result[domain]
    }
  }
  for(const domain in result) {
    if(result[domain] === max) {
      answer.push(domain)
    }
  }
  
  answer.sort()
  console.log(answer[0])
}

solution(table, languages1, preference1)
solution(table, languages2, preference2)