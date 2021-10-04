## RMI 

컴퓨터간 통신을 쉬운 예제로 구현    
    
1. RmiIntf Interface    
  server 컴퓨터와 client 컴퓨터가 모두 가지고 있어야한다.    
    
2. InrfImplement class    
  server 컴퓨터가 가지고 있어서, client의 요청으로 실행된다.    
      
3. AddServer class     
  server 컴퓨터에서 실행되고 있어야함.     
      
4. AddClient class     
  client 컴퓨터에서 실행. AddServer가 server 컴퓨터에서 실행되고 있는 동안에 AddClient를 통해 작업을 요청할 수 있다.      
  

* serial2 의 경우 객체를 전달하는 목적의 RMI 프로그램으로, serialize class를 추가하였다.    
