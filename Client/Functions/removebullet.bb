Function removebullet%(arg0%)
    If (((arg0 < $00) Or (arg0 >= bulletscount)) <> 0) Then
        Return $00
    EndIf
    freeentity(getbulletint(arg0, $00))
    If (arg0 < (bulletscount - $01)) Then
        copybank(bulletsbank, ((bulletscount - $01) * $14), bulletsbank, (arg0 * $14), $14)
    EndIf
    bulletscount = (bulletscount - $01)
    Return $00
End Function
