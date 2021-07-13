FILE=$1

FILE_LINES=`cat ${FILE} | wc -l`

if [ $FILE_LINES -lt 10 ]; then
  echo 'less than 10'
  else
    awk 'NR == 10' ${FILE}
fi

# sed -n 10p file.txt