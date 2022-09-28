@echo on
SET var=00000
set /p var=commit name?:
git add .
git commit -m "%var%"
git push
PAUSE
