#!/bin/sh -e

sudo apt-get -y update

sudo apt-get -y install dos2unix

echo "mysql-server-5.5 mysql-server/root_password password sale" | debconf-set-selections
echo "mysql-server-5.5 mysql-server/root_password_again password sale" | debconf-set-selections
apt-get -y install mysql-server-5.5

sudo mysql_install_db

mysql -uroot -psale -e "create database sale"

sudo cp /mnt/bootstrap/db/my.cnf /etc/mysql/

dos2unix /mnt/bootstrap/db/my.cnf /etc/mysql/my.cnf

sudo service mysql restart

mysql -uroot -psale -e "GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';"

mysql -uroot -psale -e "FLUSH PRIVILEGES;"

mysql -uroot -psale -e "SET PASSWORD FOR 'root'@'%' = PASSWORD('sale');"
