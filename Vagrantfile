# -*- mode: ruby -*-
# vi: set ft=ruby :

$script = <<SCRIPT
echo I am provisioning...
date > /etc/vagrant_provisioned_at
SCRIPT


Vagrant.configure("2") do |config|
  config.vm.provision "shell", inline: $script

  config.vm.define "db", primary: true do |mysql|
    mysql.vm.box = "ubuntu/trusty64"
    mysql.vm.box_url = "https://atlas.hashicorp.com/ubuntu/boxes/trusty64"
    mysql.vm.host_name = "mysql"

    mysql.vm.synced_folder "Vagrant-setup", "/mnt/bootstrap/db", :create => true
    mysql.vm.provision :shell, :path => "Vagrant-setup/bootstrap.sh"

    # PostgreSQL Server port forwarding
    mysql.vm.network "forwarded_port", guest: 3306, host: 3306
    mysql.vm.network "private_network", ip: "192.168.205.22"
  end

  config.vm.provider "virtualbox" do |vb|
    vb.customize ["modifyvm", :id, "--memory", "1048"]
  end

end
