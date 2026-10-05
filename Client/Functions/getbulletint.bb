Function getbulletint%(arg0%, arg1%)
    Return peekint(bulletsbank, ((arg0 * $14) + arg1))
    Return $00
End Function
