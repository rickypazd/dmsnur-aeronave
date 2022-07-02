 docker image build -t rickypazd/aeronave:1.4 . 
 docker container run -p 80:80 --name aeronaveContainer aeronave:1.4