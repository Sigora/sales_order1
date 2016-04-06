#!/bin/sh -e

sudo apt-get -y update

echo "mysql-server-5.5 mysql-server/root_password password sale" | debconf-set-selections
echo "mysql-server-5.5 mysql-server/root_password_again password sale" | debconf-set-selections
apt-get -y install mysql-server-5.5

sudo mysql_install_db