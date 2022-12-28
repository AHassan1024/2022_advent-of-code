#!/bin/bash
# Creates a new day directory and files based on day input

echo "Hello! Today, I'll be helping you create a Day's directories and intial files."

# Let X be the day input, e.g. 4.
day=$1

echo "... Setting up Day "$day "..."

# [+] Create DayX directory
mkdir Day$day
# [+] cd into DayX directory
cd Day$day

# [+] Create 0X substring:
mdFile="$day"
printf -v mdFile "%02d" $mdFile


# [+] Create Day0Xa.java, Day0Xb.java files using the DayTemplate.txt template, substituting in {$day} and {$part}
PARTS=('a' 'b')
for part in ${PARTS[@]}
do
  echo "... Setting up Part $part files ..."
  fileName="Day$mdFile$part"".java"
  echo $fileName
  export day
  export part
  export mdFile

  envsubst < "../DayTemplate.txt" > "temp.txt"
  cp temp.txt $fileName
  rm temp.txt

done

# [+] Create src directory
echo "... Creating subdirectory ..."
mkdir src

# [+] cd into src directory
cd src

# [+] Create empty test_input, input .txt 
echo "" > test_input.txt
echo "" > input.txt

# [] Create Day0X_Problem .md, with first line already there. "Source .. /X".

printf "Source: https://adventofcode.com/2022/day/$day\n\n#" > "Day$mdFile""_Problem.md"