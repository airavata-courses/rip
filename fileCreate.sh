if [ ! -e "/bin/sharedDirectory/" ]; then
    echo "shared directory does not exist, creating a new shared directory."
    sudo mkdir "/bin/sharedDirectory/"
fi

if [ ! -e "/sga/" ]; then
    echo "sga directory does not exist, creating a new sga directory."
    sudo mkdir "/sga/"
else
    rm -rf sga
fi


