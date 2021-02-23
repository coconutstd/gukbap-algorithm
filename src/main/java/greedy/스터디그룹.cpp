/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Student {
  int power;
  vector<int> list;
};

bool cmp(Student a, Student b){
    return a.power < b.power;
}

int main()
{
    int n, k, d;
    scanf("%d %d %d", &n, &k, &d);
    vector<Student> students;
    int algos[k + 1] = {0, };
    for(int i = 0; i < n; ++i){
        int num, power;
        scanf("%d %d", &num, &power);
        vector<int> list(num);
        for(int j = 0; j < num; ++j){
            scanf("%d", &list[j]);
        }
        students.push_back(Student{power, list});
    }
    sort(students.begin(), students.end(), cmp);


    for(int num : students[0].list){
        algos[num]++;
    }

    int answer = 0;
    int minIdx = 0, maxIdx = 0;
    for(int i = 1; i < n; ++i){
        maxIdx = i;
        while(students[maxIdx].power - students[minIdx].power > d){
            for(int num : students[minIdx].list){
                algos[num]--;
            }
            minIdx++;
        }

        for(int num : students[maxIdx].list){
            algos[num]++;
        }

        int allKnow = 0;
        int sameKnow = 0;
        for(int j = 1; j <= k; ++j){
            if(algos[j] == 0) {
                continue;
            } else if(algos[j] == maxIdx - minIdx + 1){
                allKnow++;
                sameKnow++;
            } else {
                allKnow++;
            }
        }
        answer = max(answer, (allKnow - sameKnow) * (maxIdx - minIdx + 1));
    }
    cout << answer << endl;
    return 0;
}
