if [ ! -e "/bin/sharedDirectory/" ]; then
    pwd
    echo "shared directory does not exist, creating a new shared directory."
    sudo mkdir "/bin/sharedDirectory/"
fi
