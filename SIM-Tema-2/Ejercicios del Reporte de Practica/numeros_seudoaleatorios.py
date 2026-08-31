import datetime


def random():
    return datetime.datetime.now().microsecond % 101

for _ in range(0, 101):
   print(random())    