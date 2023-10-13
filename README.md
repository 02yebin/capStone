# capStone
저장소 저장 
  $ git remote add origin https://github.com/02yebin/capStone.git
저장소 확인
  $git remote -v
  
저장소에 코드 올리기
  $ git add .
  $ git status
  $ git commit -m '커밋 내용'
  $ git push origin master
  오류 ! [rejected] master -> master (fetch first) 가 뜨면
  이전의 올린 내용과 너무 달라 푸쉬가 막힌 것
  강제 푸쉬하기 $ git push origin +master

저장소에 있는 코드 가져오기
  $ git clone https://github.com/02yebin/capStone.git
  $ git branch -a
  $ git checkout origin/master 또는 $ git checkout origin/haram

!!! .git 상위폴더나 상위폴더 등에 여러개 있으면 오류날 확률 높음
