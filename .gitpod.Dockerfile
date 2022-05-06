FROM gitpod/workspace-full

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh   &&  sdk install java 17.0.3-zulu    &&  sdk use java 17.0.3-zulu"
FROM gitpod/workspace-mongodb

FROM gitpod/workspace-mysql

RUN mysql -e "CREATE DATABASE order_service;" 
RUN mysql -e "ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root_password';"